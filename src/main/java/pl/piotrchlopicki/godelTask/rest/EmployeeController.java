package pl.piotrchlopicki.godelTask.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piotrchlopicki.godelTask.rest.dto.EmployeeDTO;
import pl.piotrchlopicki.godelTask.service.EmployeeService;
import pl.piotrchlopicki.godelTask.utils.RequestValidator;

import java.util.List;

@RequestMapping("/api")
@RestController
@Slf4j
@RequiredArgsConstructor

public class EmployeeController {
    private final EmployeeService employeeService;
    private final RequestValidator requestValidator;

    @GetMapping("/employee")
    public List<EmployeeDTO> getEmployeeList() {
        log.info("get-/employee");
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> employeeByID(@PathVariable long id) {
        log.info("get-/employee/{}", id);
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable long id) {
        log.info("delete-/employee/{}", id);
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/employee")
    public void postEmployee(@RequestBody EmployeeDTO employeeDTO) {
        log.info("post-/employee");
        requestValidator.validatePost(employeeDTO);
        employeeService.insertEmployee(employeeDTO);
    }

    @PutMapping("/employee")
    public void updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        log.info("put-/employee");
        requestValidator.validatePut(employeeDTO);
        employeeService.updateEmployee(employeeDTO);
    }


}