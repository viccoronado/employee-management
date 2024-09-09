package com.employee.management.application.services;

import com.employee.management.application.dto.request.WorkedHoursRequestDto;
import com.employee.management.domain.exceptions.DuplicateWorkedHoursException;
import com.employee.management.domain.exceptions.ExceedMaxWorkedHoursException;
import com.employee.management.domain.models.WorkedHours;
import com.employee.management.domain.repositories.WorkedHoursRepository;
import com.employee.management.domain.validators.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WorkedHoursServiceTest {

    @Mock
    private WorkedHoursRepository workedHoursRepository;

    @Mock
    private Validator<Long> employeeExistsValidator;

    @InjectMocks
    private WorkedHoursService workedHoursService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldAddWorkedHoursSuccessfully() {
        // Arrange
        WorkedHoursRequestDto requestDto = WorkedHoursRequestDto.builder()
                .employeeId(1L)
                .workedHours(8)
                .workedDate(LocalDate.now())
                .build();

        WorkedHours workedHours = WorkedHours.builder()
                .id(UUID.randomUUID())
                .employeeId(1L)
                .workedHours(8)
                .workedDate(LocalDate.now())
                .build();

        when(workedHoursRepository.save(any(WorkedHours.class))).thenReturn(workedHours);
        doNothing().when(employeeExistsValidator).validate(1L);

        // Act
        WorkedHours result = workedHoursService.addWorkedHours(requestDto);

        // Assert
        assertEquals(1L, result.getEmployeeId());
        assertEquals(8, result.getWorkedHours());
        verify(workedHoursRepository, times(1)).save(any(WorkedHours.class));
    }

    @Test
    void shouldThrowExceedMaxWorkedHoursException() {
        // Arrange
        WorkedHoursRequestDto requestDto = WorkedHoursRequestDto.builder()
                .employeeId(1L)
                .workedHours(25)
                .workedDate(LocalDate.now())
                .build();

        // Act & Assert
        assertThrows(ExceedMaxWorkedHoursException.class, () -> {
            workedHoursService.addWorkedHours(requestDto);
        });
    }

    @Test
    void shouldThrowDuplicateWorkedHoursException() {
        // Arrange
        WorkedHoursRequestDto requestDto = WorkedHoursRequestDto.builder()
                .employeeId(1L)
                .workedHours(8)
                .workedDate(LocalDate.now())
                .build();

        when(workedHoursRepository.existsByEmployeeAndDate(1L, LocalDate.now())).thenReturn(true);

        // Act & Assert
        assertThrows(DuplicateWorkedHoursException.class, () -> {
            workedHoursService.addWorkedHours(requestDto);
        });
    }
}
