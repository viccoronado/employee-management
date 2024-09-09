import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {

    @Query("SELECT SUM(te.hours) FROM TimeEntry te WHERE te.employeeId = :employeeId AND te.date BETWEEN :startDate AND :endDate")
    Double calculateTotalHours(@Param("employeeId") Long employeeId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}