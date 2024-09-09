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
    public ResponseEntity<TimeEntryResponseDto> addWorkedHours(@RequestBody TimeEntryRequestDto timeEntryRequestDto) {
        try {
            TimeEntryResponseDto responseDto = timeEntryService.addWorkedHours(timeEntryRequestDto);
            return ResponseEntity.ok(responseDto);
        } catch (EmployeeNotFoundException | InvalidWorkedHoursException | InvalidDateException | DuplicateTimeEntryException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new TimeEntryResponseDto(null, false));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TimeEntryResponseDto(null, false));
        }
    }
}
