@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;
    private final GenderRepository genderRepository;

    public EmployeeService(EmployeeRepository employeeRepository, 
                           JobRepository jobRepository, 
                           GenderRepository genderRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
        this.genderRepository = genderRepository;
    }

    public Employee createEmployee(Employee employee) {

        validateEmployeeUniqueness(employee.getName(), employee.getLastName());
        validateEmployeeAge(employee.getBirthDate());
        validateGenderExists(employee.getGenderId());
        validateJobExists(employee.getJobId());

        return employeeRepository.save(employee);
    }

    private void validateEmployeeUniqueness(String name, String lastName) {
        employeeRepository.findByNameAndLastName(name, lastName)
            .ifPresent(e -> {
                throw new EmployeeAlreadyExistsException("Employee with this name and last name already exists.");
            });
    }

    private void validateEmployeeAge(LocalDate birthDate) {
        if (Period.between(birthDate, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("Employee must be at least 18 years old.");
        }
    }

    private void validateGenderExists(Long genderId) {
        genderRepository.findById(genderId)
            .orElseThrow(() -> new EntityNotFoundException("Gender not found."));
    }

    private void validateJobExists(Long jobId) {
        jobRepository.findById(jobId)
            .orElseThrow(() -> new EntityNotFoundException("Job not found."));
    }
}
