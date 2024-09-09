import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;
    private final TimeEntryRepository timeEntryRepository;

    public EmployeeService(EmployeeRepository employeeRepository, 
                           JobRepository jobRepository,
                           TimeEntryRepository timeEntryRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
        this.timeEntryRepository = timeEntryRepository;
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

    private void validateJobExists(Long jobId) {
        jobRepository.findById(jobId)
            .orElseThrow(() -> new JobNotFoundException("Job not found for ID: " + jobId));
    }

    private void validateEmployeeExists(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new EmployeeNotFoundException("Employee not found for ID: " + employeeId);
        }
    }

    private void validateDates(LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            throw new InvalidDateRangeException("Start date must be before end date.");
        }
    }
}
