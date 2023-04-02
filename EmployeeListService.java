package CollectionsAndSets;

import CollectionsAndSets.Excertions.EmployeeAlreadyAddedException;
import CollectionsAndSets.Excertions.EmployeeNotFoundException;
import CollectionsAndSets.Excertions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeListService {
    List<Employee> empl = new ArrayList<>(List.of(
            new Employee("Вера", "Койнова"),
            new Employee("Виктор", "Сидоров"),
            new Employee("Серьгей", "Сидоров"),
            new Employee("Антон", "Сидоров"),
            new Employee("Семён", "Фёдоров"),
            new Employee("Роман", "Романюк"),
            new Employee("Светлана", "Фёдорова")
    ));

    public String addEmpl(String firstName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, lastName);
            if ((empl.contains(employee))) {
                throw new EmployeeAlreadyAddedException();
            }
        empl.add(new Employee(firstName, lastName));
        return "";
    }

    public String removeEmpl(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
            if (!(empl.contains(employee))) {
                throw new EmployeeNotFoundException();
            }
            empl.remove(employee);
        return employee.toString();
    }

    public String findEmpl(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < empl.size(); i++) {
            if ((empl.contains(employee))) {
                return employee.toString();
            }
        }
        throw new EmployeeNotFoundException();
    }




}




