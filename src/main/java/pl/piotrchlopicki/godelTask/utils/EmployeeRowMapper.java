package pl.piotrchlopicki.godelTask.utils;

import org.springframework.jdbc.core.RowMapper;
import pl.piotrchlopicki.godelTask.db.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(rs.getInt("employee_id"));
        employee.setDepartmentId(rs.getInt("department_id"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setJobTitle(rs.getString("job_title"));
        return employee;
    }
}
