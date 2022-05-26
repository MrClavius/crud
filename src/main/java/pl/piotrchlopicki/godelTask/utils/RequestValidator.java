package pl.piotrchlopicki.godelTask.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import pl.piotrchlopicki.godelTask.rest.dto.EmployeeDTO;
import pl.piotrchlopicki.godelTask.rest.exception.BadRequestException;

@Component
@Slf4j
public class RequestValidator {

    public void validatePost(EmployeeDTO employeeDTO) {
        if (employeeDTO.getEmployeeId() != null){
            log.error("Post new employee cannot contain employee ID!");
            throw new BadRequestException("Post new employee cannot contain employee ID!", HttpStatus.BAD_REQUEST.name());
        }
        if (employeeDTO.getDepartmentId() == null || employeeDTO.getFirstName() == null || employeeDTO.getLastName() == null || employeeDTO.getJobTitle() == null){
            log.error("Missing required input, request: {}", employeeDTO);
            throw new BadRequestException("Missing required input!", HttpStatus.BAD_REQUEST.name());
        }
    }

    public void validatePut(EmployeeDTO employeeDTO){
        if (employeeDTO.getEmployeeId() == null || employeeDTO.getDepartmentId() == null || employeeDTO.getFirstName() == null || employeeDTO.getLastName() == null || employeeDTO.getJobTitle() == null) {
            log.error("Missing required input, request: {}", employeeDTO);
            throw new BadRequestException("Missing required input!", HttpStatus.BAD_REQUEST.name());
        }
    }
}
