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

        public void addEmployee(Employee employee){
            employees.add(employee);
        }
        public List<Employee> getEmployees () {
            return new ArrayList<>(employees);
        }
        public void updateEmployee ( int employeeId, Employee updatedEmployee){
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getEmployeeID() == employeeId) {
                employees.set(i, updatedEmployee);
                return;
            }
        }
        throw new IllegalArgumentException("Employee not found update");
    }

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
}