import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> findByNameAndLastName(String name, String lastName);
    Optional<Employee> findById(Long id);
    Employee save(Employee employee);
}
