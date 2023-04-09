package CollectionsAndSets;

import CollectionsAndSets.Excertions.EmployeeAlreadyAddedException;
import CollectionsAndSets.Excertions.EmployeeNotFoundException;
import CollectionsAndSets.Excertions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeListService {

    Map<String, Employee> empl = new HashMap(Map.of(
            "Вера Койнова", new Employee("Вера", "Койнова"),
            "Виктор Сидоров", new Employee("Виктор", "Сидоров"),
            "Серьгей Сидоров", new Employee("Серьгей", "Сидоров"),
            "Антон Сидоров", new Employee("Антон", "Сидоров"),
            "Семён Фёдоров", new Employee("Семён", "Фёдоров"),
            "Роман Романюк", new Employee("Роман", "Романюк"),
            "Светлана Фёдорова", new Employee("Светлана", "Фёдорова")
    ));

    public Employee addEmpl(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
            if ((empl.containsKey(firstName + " " + lastName))) {
                throw new EmployeeAlreadyAddedException();
            }
        empl.put(firstName + " " + lastName, employee);
        return employee;
    }

    public String removeEmpl(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
            if (!(empl.containsKey(firstName + " " + lastName))) {
                throw new EmployeeNotFoundException();
            }
            empl.remove(firstName + " " + lastName);
        return employee.toString();
    }

    public String findEmpl(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < empl.size(); i++) {
            if ((empl.containsKey(firstName + " " + lastName))) {
                return employee.toString();
            }
        }
        throw new EmployeeNotFoundException();
    }




}




