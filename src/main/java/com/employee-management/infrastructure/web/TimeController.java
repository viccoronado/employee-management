import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private final TimeEntryService timeEntryService;

    public TimeEntryController(TimeEntryService timeEntryService) {
        this.timeEntryService = timeEntryService;
    }

    @PostMapping
    public ResponseEntity<TimeEntryResponse> addWorkedHours(@RequestBody TimeEntryRequest request) {
        try {
            TimeEntryResponse response = timeEntryService.addWorkedHours(request);
            return ResponseEntity.ok(response);
        } catch (EmployeeNotFoundException | InvalidWorkedHoursException | InvalidDateException | DuplicateTimeEntryException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new TimeEntryResponse(null, false));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TimeEntryResponse(null, false));
        }
    }
}