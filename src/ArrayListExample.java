import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class Employee implements Serializable {
    @NonNull String test;
    String id;
    String firstName;
    String lastName;

    //Getters and setters

    public Employee(String id, String firstName, String lastName) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}


public class ArrayListExample
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("1", "lokesh", "gupta"));
        employees.add(new Employee("2", "brian", "motto"));

        try
        {
            FileOutputStream fos = new FileOutputStream("employeeData.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employees);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}