//import org.example.Exception.RecipeException;
import org.example.Model.Employee;
import org.example.Service.EmployeeManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class EmployeeManagerTest {

    EmployeeManager EmployeeManager;

    /**
     * Before every single test, we should reset the recipe service to a
     * newly-instantiated object.
     */
    @Before
    public void setUp() {
        EmployeeManager = new EmployeeManager();
    }

    /**
     * When the recipe service is first created, it should contain zero recipes.
     */
    @Test
    public void mainappEmptyatthestart() {
        List<Employee> employees = EmployeeManager.getEmployees();
//        ensure that at the start, there are no recipes
        Assert.assertTrue(employees.size() == 0);
    }
}

