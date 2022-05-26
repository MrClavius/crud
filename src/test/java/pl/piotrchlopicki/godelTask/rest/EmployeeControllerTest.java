package pl.piotrchlopicki.godelTask.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.piotrchlopicki.godelTask.db.EmployeeDAO;
import pl.piotrchlopicki.godelTask.service.EmployeeService;
import pl.piotrchlopicki.godelTask.utils.EmployeeMapper;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class EmployeeControllerTest {
    @Mock
    EmployeeController employeeMapper;
    @Mock
    EmployeeDAO employeeDao;

    EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeService(employeeDao, employeeMapper);
    }


}