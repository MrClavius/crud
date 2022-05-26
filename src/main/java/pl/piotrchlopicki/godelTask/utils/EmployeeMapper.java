package pl.piotrchlopicki.godelTask.utils;

import org.springframework.stereotype.Component;
import pl.piotrchlopicki.godelTask.db.model.Employee;
import pl.piotrchlopicki.godelTask.rest.dto.EmployeeDTO;

@Component
public class EmployeeMapper {

    public EmployeeDTO mapEmployeetoDTO(Employee source){
        return EmployeeDTO.builder()
                .employeeId(source.getEmployeeId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .jobTitle(source.getJobTitle())
                .departmentId(source.getDepartmentId())
                .build();
    }

    public Employee mapDTOtoEmployee(EmployeeDTO source){
        return Employee.builder()
                .employeeId(source.getEmployeeId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .jobTitle(source.getJobTitle())
                .departmentId(source.getDepartmentId())
                .build();
    }
}
