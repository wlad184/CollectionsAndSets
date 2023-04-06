package CollectionsAndSets;

import CollectionsAndSets.Excertions.EmployeeAlreadyAddedException;
import CollectionsAndSets.Excertions.EmployeeNotFoundException;
import CollectionsAndSets.Excertions.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeListService employeeListService;

    public EmployeeController(EmployeeListService employeeListService) {
        this.employeeListService = employeeListService;
    }
    /*/employee/add?firstName=Ivan&lastName=Ivanov*/


    @GetMapping(path = "/add")
    public String add(@RequestParam("firstName") String firstName, String lastName) {
        try {
            return " Сотрудник " + employeeListService.addEmpl(firstName, lastName) + " добавлен в спискок";

        } catch (EmployeeAlreadyAddedException ex) {
            return "Такой сотрудник уже есть, введите другие данные!!!";

        }
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam("firstName") String firstName, String lastName) {
        try {
            return " Сотрудник " + employeeListService.removeEmpl(firstName, lastName) + " удален из списка";

        } catch (EmployeeNotFoundException ex) {
            return "Такой сотрудник отсутствует в списках, введите другие данные!!!";
        }

    }

    @GetMapping(path = "/find")
    public String find(@RequestParam("firstName") String firstName, String lastName) {
        try {
            return " Сотрудник " + employeeListService.findEmpl(firstName, lastName) + " существует в списках";

        } catch (EmployeeNotFoundException ex) {
            return "Такой сотрудник отсутствует в списках!!!";
        }
    }

    @GetMapping(path = "/print")
    public List<Employee> print() {

        return employeeListService.empl;
    }



}


