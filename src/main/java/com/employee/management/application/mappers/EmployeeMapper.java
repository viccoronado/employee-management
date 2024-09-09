package com.employee.management.application.mappers;

import com.employee.management.application.dto.request.EmployeeRequestDto;
import com.employee.management.application.dto.response.EmployeeResponseDto;
import com.employee.management.domain.models.Employee;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto toEmployeeResponseDto(Employee employee);
    List<EmployeeResponseDto> toEmployeeResponseDtoList(List<Employee> employees);
}
