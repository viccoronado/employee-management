import org.springframework.stereotype.Service;
import com.employee.management.domain.exceptions.EmployeeAlreadyExistsException;
import com.employee.management.domain.exceptions.InvalidEmployeeAgeException;
import com.employee.management.domain.exceptions.GenderNotFoundException;
import com.employee.management.domain.exceptions.JobNotFoundException;
import com.employee.management.domain.exceptions.EmployeeNotFoundException;
import com.employee.management.domain.exceptions.InvalidDateRangeException;


import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;
    private final TimeEntryRepository timeEntryRepository;
    private final PaymentRepository paymentRepository;
    private final GenderRepository genderRepository;

    public EmployeeService(EmployeeRepository employeeRepository,
                           JobRepository jobRepository,
                           TimeEntryRepository timeEntryRepository,
                           PaymentRepository paymentRepository,
                           GenderRepository genderRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
        this.timeEntryRepository = timeEntryRepository;
        this.paymentRepository = paymentRepository;
        this.genderRepository = genderRepository;
    }

    public List<Employee> getEmployeesByJob(Long jobId) {
        validateJobExists(jobId);
        return employeeRepository.findByJobId(jobId);
    }

    public double calculateTotalHoursWorked(Long employeeId, LocalDate startDate, LocalDate endDate) {
        validateEmployeeExists(employeeId);
        validateDates(startDate, endDate);
        return timeEntryRepository.calculateTotalHours(employeeId, startDate, endDate);
    }

    public double calculateTotalAmountPaid(Long employeeId, LocalDate startDate, LocalDate endDate) {
        validateEmployeeExists(employeeId);
        validateDates(startDate, endDate);
        return paymentRepository.calculateTotalAmount(employeeId, startDate, endDate);
    }

    public Employee createEmployee(EmployeeRequestDTO employeeRequestDTO) {
        validateEmployeeUniqueness(employeeRequestDTO.getName(), employeeRequestDTO.getLastName());
        validateEmployeeAge(employeeRequestDTO.getBirthDate());
        validateGenderExists(employeeRequestDTO.getGenderId());
        validateJobExists(employeeRequestDTO.getJobId());

        Employee employee = new Employee.EmployeeBuilder()
                .withName(employeeRequestDTO.getName())
                .withLastName(employeeRequestDTO.getLastName())
                .withBirthDate(employeeRequestDTO.getBirthDate())
                .withGenderId(employeeRequestDTO.getGenderId())
                .withJobId(employeeRequestDTO.getJobId())
                .build();

        return employeeRepository.save(employee);
    }

    private void validateEmployeeUniqueness(String name, String lastName) {
        if (employeeRepository.findByNameAndLastName(name, lastName).isPresent()) {
            throw new EmployeeAlreadyExistsException("An employee with this name and last name already exists.");
        }
    }

    private void validateEmployeeAge(LocalDate birthDate) {
        if (LocalDate.now().getYear() - birthDate.getYear() < 18) {
            throw new InvalidEmployeeAgeException("Employee must be at least 18 years old.");
        }
    }

    private void validateGenderExists(Long genderId) {
        if (!genderRepository.existsById(genderId)) {
            throw new GenderNotFoundException("Gender not found for ID: " + genderId);
        }
    }

    private void validateJobExists(Long jobId) {
        if (!jobRepository.existsById(jobId)) {
            throw new JobNotFoundException("Job not found for ID: " + jobId);
        }
    }

    private void validateEmployeeExists(Long employeeId) {
        if (!employeeRepository.findById(employeeId).isPresent()) {
            throw new EmployeeNotFoundException("Employee not found for ID: " + employeeId);
        }
    }

    private void validateDates(LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            throw new InvalidDateRangeException("Start date must be before end date.");
        }
    }
}