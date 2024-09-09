package com.employee.management.domain.services;

import com.employee.management.application.dto.EmployeeRequestDto;
import com.employee.management.application.dto.EmployeeResponseDto;
import com.employee.management.domain.exceptions.*;
import com.employee.management.domain.models.Employee;
import com.employee.management.domain.models.WorkedHours;
import com.employee.management.domain.repositories.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;
    private final PaymentRepository paymentRepository;
    private final GenderRepository genderRepository;
    private final WorkedHoursRepository workedHoursRepository;

    public EmployeeService(EmployeeRepository employeeRepository,
                           JobRepository jobRepository,
                           PaymentRepository paymentRepository,
                           GenderRepository genderRepository,
                           WorkedHoursRepository workedHoursRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
        this.paymentRepository = paymentRepository;
        this.genderRepository = genderRepository;
        this.workedHoursRepository = workedHoursRepository;
    }

    public List<Employee> getEmployeesByJob(Long jobId) {
        validateJobExists(jobId);
        return employeeRepository.findByJobId(jobId);
    }

    public double calculateTotalAmountPaid(Long employeeId, LocalDate startDate, LocalDate endDate) {
        validateEmployeeExists(employeeId);
        validateDates(startDate, endDate);
        return paymentRepository.calculateTotalAmount(employeeId, startDate, endDate);
    }

    public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto) throws InvalidEmployeeDataException, InvalidEmployeeAgeException, GenderNotFoundException, JobNotFoundException, EmployeeAlreadyExistsException {
        Employee employee = new Employee.Builder()
                .withName(employeeRequestDto.getName())
                .withLastName(employeeRequestDto.getLastName())
                .withBirthDate(employeeRequestDto.getDateOfBirth())
                .withGenderId(employeeRequestDto.getGenderId())
                .withJobId(employeeRequestDto.getJobId())
                .build();

        Employee savedEmployee = employeeRepository.save(employee);

        return new EmployeeResponseDto(savedEmployee.getId(), true);
    }

    private void validateEmployeeUniqueness(String name, String lastName) {
        if (employeeRepository.findByNameAndLastName(name, lastName).isPresent()) {
            throw new EmployeeAlreadyExistsException("An employee with this name and last name already exists.");
        }
    }

    private void validateEmployeeAge(LocalDate birthDate) {
        if (LocalDate.now().getYear() - birthDate.getYear() < 18) {
            throw new InvalidEmployeeAgeException("Employee must be at least 18 years old.");
        }
    }

    private void validateGenderExists(Long genderId) {
        if (!genderRepository.existsById(genderId)) {
            throw new GenderNotFoundException("Gender not found for ID: " + genderId);
        }
    }

    private void validateJobExists(Long jobId) {
        if (!jobRepository.existsById(jobId)) {
            throw new JobNotFoundException("Job not found for ID: " + jobId);
        }
    }

    private void validateEmployeeExists(Long employeeId) {
        if (employeeRepository.findById(employeeId).isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found for ID: " + employeeId);
        }
    }

    private void validateDates(LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            throw new InvalidDateRangeException("Start date must be before end date.");
        }
    }

    public double calculateTotalHoursWorked(Long employeeId, LocalDate startDate, LocalDate endDate)
            throws EmployeeNotFoundException, InvalidDateRangeException {
        if (startDate.isAfter(endDate)) {
            throw new InvalidDateRangeException("Start date must be before end date.");
        }

        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found.");
        }

        List<WorkedHours> workedHoursList = workedHoursRepository.findByEmployeeIdAndWorkedDateBetween(employeeId, startDate, endDate);

        double totalHours = workedHoursList.stream()
                .mapToInt(WorkedHours::getWorkedHours)
                .sum();

        return totalHours;
    }
}
