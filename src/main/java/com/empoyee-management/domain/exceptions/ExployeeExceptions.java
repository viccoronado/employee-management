// Custom exception: Invalid job ID
public class InvalidJobIdException extends RuntimeException {
    public InvalidJobIdException(String message) {
        super(message);
    }
}

// Custom exception: No employees found for a given job
public class EmployeesNotFoundException extends RuntimeException {
    public EmployeesNotFoundException(String message) {
        super(message);
    }
}

// Custom exception: Job itself is not found
public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException(String message) {
        super(message);
    }
}

// Custom exception: Invalid employee ID
public class InvalidEmployeeIdException extends RuntimeException {
    public InvalidEmployeeIdException(String message) {
        super(message);
    }
}

// Custom exception: Invalid date range
public class InvalidDateRangeException extends RuntimeException {
    public InvalidDateRangeException(String message) {
        super(message);
    }
}

// Custom exception: Employee not found
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}