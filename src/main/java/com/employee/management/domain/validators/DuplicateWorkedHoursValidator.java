package com.employee.management.domain.validators;

import com.employee.management.application.dto.request.WorkedHoursRequestDto;

@FunctionalInterface
public interface DuplicateWorkedHoursValidator extends Validator<WorkedHoursRequestDto> {}