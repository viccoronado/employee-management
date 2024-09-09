@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;

    public EmployeeService(EmployeeRepository employeeRepository, 
                           JobRepository jobRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    public List<Employee> getEmployeesByJob(Long jobId) {
        validateJobExists(jobId);

        return employeeRepository.findByJobId(jobId);
    }

    private void validateJobExists(Long jobId) {
        jobRepository.findById(jobId)
            .orElseThrow(() -> new JobNotFoundException("Job not found for ID: " + jobId));
    }
}
