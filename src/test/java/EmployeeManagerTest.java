import org.example.Exception.InvalidInputException;
import org.example.Model.Employee;
import org.example.Service.EmployeeManager;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.util.List;


public class EmployeeManagerTest {
        @Test
        public void testAddEmployee() {
            EmployeeManager employeeManager = new EmployeeManager();
            Employee employee = new Employee();
            employee.setEmployeeID(1);
            employee.setFirstName("John");
            employee.setLastName("Keeper");
            employee.setSalary(1234);
            employeeManager.addEmployee(employee);
            List<Employee> employees = employeeManager.getEmployees();
            assertEquals(1, employees.size());
            assertEquals(employee, employees.get(0));
        }

        @Test
    public void testUpdateEmployee () {

            EmployeeManager employeeManager = new EmployeeManager();
            Employee originalEmployee = new Employee(1, "John","Calvin",120000.0);
            Employee updatedEmployee = new Employee (1, "John","Calvin",130000.0);

            employeeManager.addEmployee(originalEmployee);
            employeeManager.updateEmployee(1,updatedEmployee);

            Employee retrievedEmployee = employeeManager.getEmployees().get(0);
            assertEquals(updatedEmployee,retrievedEmployee);
        }

        @Test
    public void testDeleteEmployee() throws InvalidInputException {
            EmployeeManager employeeManager = new EmployeeManager();
            Employee employeeToDelete = new Employee (1, "John","Calvin",130000.0);
            EmployeeManager.addEmployee(employeeToDelete);
            EmployeeManager.deleteEmployee(1);
            assertTrue(employeeManager.getEmployees().isEmpty());
        }

        @Test
    public void TestSearchEmployeeBySalary() {
            EmployeeManager employeeManager = new EmployeeManager();
            EmployeeManager.addEmployee(new Employee(1, "John", "Calvin", 12.0));
            EmployeeManager.addEmployee(new Employee(2, "Jane", "Smith", 13.0));
            EmployeeManager.addEmployee(new Employee(3, "Ben", "Yam", 14.0));
            EmployeeManager.addEmployee(new Employee(4, "Abraham", "Ted", 15.0));

            List<Employee> result = EmployeeManager.GetEmployeeBySalary(13.0);
            assertEquals(1, result.size());

            Employee foundEmployee = result.get(0);
            assertEquals(2, foundEmployee.getEmployeeID());
            assertEquals("Jane", foundEmployee.getFirstName());
            assertEquals("Smith", foundEmployee.getLastName());



        }
}

