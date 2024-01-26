package org.example.View;

import org.example.Model.Employee;
import org.example.Service.EmployeeManager;


import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Employee newEmployee = createEmployeeFromUserInput(scanner);
                    employeeManager.addEmployee(newEmployee);
                    System.out.println("Employee added successfully");
                    break;
                case 2:
                    System.out.println("Employees");
                    for (Employee employee : employeeManager.getEmployees()) {
                        System.out.println(employee);
                    }
                    break;
                case 3:
                    updateEmployee(employeeManager, scanner);
                    break;
                case 4:
                    deleteEmployee(employeeManager, scanner);
                    break;
                case 0:
                    System.out.println("Exiting the application GoodBye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static Employee createEmployeeFromUserInput(Scanner scanner) {
        Employee employee = new Employee();
        System.out.print("Enter Employee ID: ");
        employee.setEmployeeID(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter First Name: ");
        employee.setFirstName(scanner.nextLine());
        System.out.print("Enter Last Name: ");
        employee.setLastName(scanner.nextLine());
        System.out.print("Enter salary: ");
        employee.setSalary(scanner.nextDouble());
        return employee;
    }

    private static void updateEmployee(EmployeeManager employeeManager, Scanner scanner) {
        System.out.print("Enter the employee ID to update: ");
        int employeeID = scanner.nextInt();
        scanner.nextLine();
        Employee exsitingEmployee = findEmployeeID(employeeManager, employeeID);
        if (exsitingEmployee != null) {
            Employee updatedEmployee = createEmployeeFromUserInput(scanner);
            employeeManager.updateEmployee(employeeID, updatedEmployee);
            System.out.println("Employee Updated Successfully");
        } else {
            System.out.println("Employee not found for update.");

        }
    }

    private static void deleteEmployee(EmployeeManager employeeManager, Scanner scanner) {
        System.out.println("Enter employee ID to delete: ");
        int employeeID = scanner.nextInt();
        scanner.nextLine();
        Employee exsitingEmployee = findEmployeeID(employeeManager, employeeID);
        if (exsitingEmployee != null) {
            EmployeeManager.deleteEmployee(employeeID);
            System.out.println("Employee deleted Successfully");
        } else {
            System.out.println("Employee not found for deletion.");

        }
    }

    private static Employee findEmployeeID(EmployeeManager employeeManager, int employeeID) {
        for (Employee employee : employeeManager.getEmployees()) {
            if (employee.getEmployeeID() == employeeID) {
                return employee;
            }

        }
        return null;
    }
}
