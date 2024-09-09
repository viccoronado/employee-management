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
}
