// Custom exception: Worked hours are invalid
public class InvalidWorkedHoursException extends RuntimeException {
    public InvalidWorkedHoursException(String message) {
        super(message);
    }
}

// Custom exception: Invalid date is provided
 */
public class InvalidDateException extends RuntimeException {
    public InvalidDateException(String message) {
        super(message);
    }
}

// Custom exception: Duplicate time entry is detected for the same employee on the same day
 */
public class DuplicateTimeEntryException extends RuntimeException {
    public DuplicateTimeEntryException(String message) {
        super(message);
    }
}
