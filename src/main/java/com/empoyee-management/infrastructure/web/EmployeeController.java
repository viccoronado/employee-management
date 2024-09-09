import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/by-job")
    public ResponseEntity<List<Employee>> getEmployeesByJob(@RequestParam Long jobId) {
        try {
            if (jobId == null || jobId <= 0) {
                throw new InvalidJobIdException("Job ID must be a positive number.");
            }

            List<Employee> employees = employeeService.getEmployeesByJob(jobId);

            if (employees.isEmpty()) {
                throw new EmployeesNotFoundException("No employees found for the given job ID.");
            }

            return ResponseEntity.ok(employees);

        } catch (InvalidJobIdException | EmployeesNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.emptyList());

        } catch (JobNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{employeeId}/hours")
    public ResponseEntity<?> getTotalHoursWorked(
            @PathVariable Long employeeId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        try {
            if (employeeId == null || employeeId <= 0) {
                throw new InvalidEmployeeIdException("Employee ID must be a positive number.");
            }

            if (startDate == null || endDate == null) {
                throw new InvalidDateRangeException("Start date and end date must be provided.");
            }

            double totalHours = employeeService.calculateTotalHoursWorked(employeeId, startDate, endDate);
            return ResponseEntity.ok(totalHours);

        } catch (InvalidEmployeeIdException | InvalidDateRangeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());

        } catch (EmployeeNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
