package com.example.domain.repositories;

import com.example.domain.models.TimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {

    @Query("SELECT SUM(te.workedHours) FROM TimeEntry te WHERE te.employeeId = :employeeId AND te.workedDate BETWEEN :startDate AND :endDate")
    Double calculateTotalHours(@Param("employeeId") Long employeeId, 
                               @Param("startDate") LocalDate startDate, 
                               @Param("endDate") LocalDate endDate);

    @Query("SELECT t FROM TimeEntry t WHERE t.employeeId = :employeeId AND t.workedDate = :workedDate")
    Optional<TimeEntry> findByEmployeeIdAndWorkedDate(@Param("employeeId") Long employeeId, 
                                                      @Param("workedDate") LocalDate workedDate);

}