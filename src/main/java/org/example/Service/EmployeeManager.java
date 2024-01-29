package org.example.Service;


import org.example.Model.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




public class EmployeeManager {
    private static List<Employee> employees;

    public EmployeeManager() {

        this.employees = new ArrayList<>();
    }

    /*
    The system allows to add new employees by providing details such as employeeId,First name last name etc

     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    /*
    The application supports updating Employee's details including modifying ID number, first or last name
     */
    public void updateEmployee(int employeeId, Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID() == employeeId) {
                employees.set(i, updatedEmployee);
                return;
            }
        }
        throw new IllegalArgumentException("Employee not found update");
    }

    /*
       Users can also remove employees from the system by providing their employee ID. The system ensures that
       the provided ID is valid and corresponds to an existing employee before executing the deletion.
        */
    public static void deleteEmployee(int employeeId) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getEmployeeID() == employeeId) {
                iterator.remove();
                return;
            }
        }
        throw new IllegalArgumentException("Employee not found for deletion");
    }

    public static List<Employee> GetEmployeeBySalary(double targetsalary) {
        List<Employee> result = new ArrayList<>();
      //  for (Employee employee : employees) {
       //     double salary = employee.getSalary();
       //     if (salary >= minSalary && salary <= maxSalary) {
        //        result.add(employee);
         for (Employee employee : employees) {
          if(employee.getSalary() == targetsalary) {
              result.add(employee);
         }
        }
        return result;
    } 

}