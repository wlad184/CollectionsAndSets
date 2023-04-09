package CollectionsAndSets;

import java.util.Objects;

public class Employee {


    private String firstName;
    private String lastName;

    //private final int id;
    public static int country = 0;



    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //id = country++;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*public int getId() {
        return id;
    }*/

    public static int getCountry() {
        return country;
    }


    @Override
    public String toString() {
        return
                "Фамилия=  " + firstName +
                        ", Отчество = " + lastName/* +
                        " Id= " + id*/;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && /*id == employee.id && */lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName/*, id*/);
    }

}
