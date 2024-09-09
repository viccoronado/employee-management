import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TimeEntryService {

    private final EmployeeRepository employeeRepository;
    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryService(EmployeeRepository employeeRepository, TimeEntryRepository timeEntryRepository) {
        this.employeeRepository = employeeRepository;
        this.timeEntryRepository = timeEntryRepository;
    }

    @Transactional
    public TimeEntryResponse addWorkedHours(TimeEntryRequest request) {
        validateEmployeeExists(request.getEmployeeId());
        validateWorkedHours(request.getWorkedHours());
        validateDate(request.getWorkedDate());
        validateNoDuplicateEntry(request.getEmployeeId(), request.getWorkedDate());

        TimeEntry timeEntry = new TimeEntry();
        timeEntry.setEmployeeId(request.getEmployeeId());
        timeEntry.setWorkedHours(request.getWorkedHours());
        timeEntry.setWorkedDate(request.getWorkedDate());

        TimeEntry savedEntry = timeEntryRepository.save(timeEntry);
        return new TimeEntryResponse(savedEntry.getId(), true);
    }

    private void validateEmployeeExists(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new EmployeeNotFoundException("Employee not found for ID: " + employeeId);
        }
    }

    private void validateWorkedHours(Double workedHours) {
        if (workedHours <= 0 || workedHours > 20) {
            throw new InvalidWorkedHoursException("Worked hours must be between 0 and 20.");
        }
    }

    private void validateDate(LocalDate workedDate) {
        if (workedDate.isAfter(LocalDate.now())) {
            throw new InvalidDateException("Worked date cannot be in the future.");
        }
    }

    private void validateNoDuplicateEntry(Long employeeId, LocalDate workedDate) {
        Optional<TimeEntry> existingEntry = timeEntryRepository.findByEmployeeIdAndWorkedDate(employeeId, workedDate);
        if (existingEntry.isPresent()) {
            throw new DuplicateTimeEntryException("An entry for this employee on this date already exists.");
        }
    }
}
