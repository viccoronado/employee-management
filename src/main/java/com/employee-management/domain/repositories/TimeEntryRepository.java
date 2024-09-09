import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {

    @Query("SELECT SUM(te.hours) FROM TimeEntry te WHERE te.employeeId = :employeeId AND te.date BETWEEN :startDate AND :endDate")
    Double calculateTotalHours(@Param("employeeId") Long employeeId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT t FROM TimeEntry t WHERE t.employeeId = :employeeId AND t.workedDate = :workedDate")
    Optional<TimeEntry> findByEmployeeIdAndWorkedDate(@Param("employeeId") Long employeeId, 
                                                      @Param("workedDate") LocalDate workedDate);

}