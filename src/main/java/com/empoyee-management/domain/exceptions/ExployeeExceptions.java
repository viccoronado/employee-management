// Custom exception: Invalid job ID
public class InvalidJobIdException extends RuntimeException {
    public InvalidJobIdException(String message) {
        super(message);
    }
}

// Custom exception: No found employees for a given job
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
