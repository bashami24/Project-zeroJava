import org.example.Model.Employee;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EmployeeTest {
    @Override
    public String toString() {
        return "EmployeeTest{}";
    }

    @Test

    public void testToString() {
    Employee employee = new Employee();
    employee.setEmployeeID(1);
    employee.setFirstName("John");
    employee.setLastName("Keeper");
    employee.setSalary(1234);
    String ExpectedString = "Employee{" + "employeeID=1, " + "FirstName='John', " + "LastName='Keeper', " + "Salary=1234.0" + "}";
    assertEquals(ExpectedString, employee.toString());

}
@Test
  public void testEquals() {
   Employee employee1 = new Employee();
        employee1.setEmployeeID(2);
        employee1.setFirstName("Mike");
        employee1.setLastName("Fish");
        employee1.setSalary(1235);
    Employee employee2 = new Employee();
        employee2.setEmployeeID(2);
        employee2.setFirstName("Mike");
        employee2.setLastName("Fish");
        employee2.setSalary(1235);

    Employee employee3 = new Employee();
    employee3.setEmployeeID(3);
    employee3.setFirstName("Michel");
    employee3.setLastName("Larry");
    employee3.setSalary(4567);
    assertEquals(employee1, employee2);
    assertNotEquals(employee1, employee3);
  }
}

