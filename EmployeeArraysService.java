package CollectionsAndSets;
import CollectionsAndSets.Excertions.EmployeeAlreadyAddedException;
import CollectionsAndSets.Excertions.EmployeeNotFoundException;
import CollectionsAndSets.Excertions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;


public class EmployeeArraysService {
    Employee[] empl = {
            new Employee("Вера", "Койнова"),
            new Employee("Виктор", "Сидоров"),
            new Employee("Серьгей", "Сидоров"),
            new Employee("Антон", "Сидоров"),
            new Employee("Семён", "Фёдоров"),
            new Employee("Роман", "Романюк"),
            new Employee("Светлана", "Фёдорова"),
            null,
            null

    };
    public String addEmpl(String firstName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, lastName);

        for (int i = 0; i < empl.length; i++) {
            if (employee.equals(empl[i])){
                throw new EmployeeAlreadyAddedException();
            }
            if (empl[i] == null){
                empl[i] = new Employee(firstName, lastName);
                return employee.toString();
            }
            if (i == empl.length - 1){
                throw new EmployeeStorageIsFullException();
            }
        }
        return "";
    }
    public String removeEmpl(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < empl.length; i++) {
            if (employee.equals(empl[i])){
                empl[i] = null ;
                return employee.toString();
            }
        }
        throw new EmployeeNotFoundException();
    }

    public String findEmpl(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < empl.length; i++) {
            if (employee.equals(empl[i])){
                return employee.toString();
            }
        }
        throw new EmployeeNotFoundException();
    }




}

