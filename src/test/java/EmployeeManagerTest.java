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
    public void testDeleteEmployee() {
            EmployeeManager employeeManager = new EmployeeManager();
            Employee employeeToDelete = new Employee (1, "John","Calvin",130000.0);
            employeeManager.addEmployee(employeeToDelete);
            EmployeeManager.deleteEmployee(1);
            assertTrue(employeeManager.getEmployees().isEmpty());
        }
}

