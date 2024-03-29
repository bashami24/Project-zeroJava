package org.example.View;

import org.example.Model.Employee;
import org.example.Service.EmployeeManager;
import java.util.InputMismatchException;
import org.example.Exception.InvalidInputException;

import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class MainApp {
    private static final Logger logger = LoggerFactory.getLogger(MainApp.class);
    public static void main(String[] args) throws InvalidInputException {
        EmployeeManager employeeManager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search for Employee");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");

            int choice;
            try { choice = Integer.parseInt(String.valueOf(scanner.nextInt())); }
            catch (NumberFormatException e) {
                System.out.println("Invalid input please enter a valid option");
                continue;
            }

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
                case 5:
                    System.out.println("Enter the salary to search: ");
                    double targetsalary = scanner.nextDouble();
                    scanner.nextLine();
                    List<Employee> employeeWithSalary = EmployeeManager.GetEmployeeBySalary(targetsalary);
                    if (employeeWithSalary.isEmpty()) {
                        System.out.println("No employee found with the specified Salary. ");
                    }
                    else {
                        System.out.println("Employees with the specified salary: ");
                        for (Employee employee : employeeWithSalary) {
                            System.out.println(employee);
                        }


                    }
                    break;
                case 0:
                    System.out.println("Exiting the application GoodBye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static Employee createEmployeeFromUserInput(Scanner scanner) throws InvalidInputException {
        logger.info("Creating a new employee from user input...");
        Employee employee = new Employee();
        System.out.print("Enter Employee ID: ");
        while (true) {
            try {
                employee.setEmployeeID(scanner.nextInt());
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                logger.error("Invalid input exception: {}",e.getMessage(),e);
                System.out.println("Invalid input. Please enter a valid EmployeeID: ");
                scanner.next();
            }
        }

                System.out.print("Enter First Name: ");
                while(true) {
                    try {
                        String FirstName = scanner.nextLine();
                        if (!isValidString(FirstName)) {
                            throw new InputMismatchException();
                        }
                        employee.setFirstName(FirstName);
                        break;
                    } catch (InputMismatchException e) {
                        logger.error("Invalid input exception: {}",e.getMessage(),e);
                        System.out.println("Invalid input. Please enter a valid First Name: ");
                    }
                }
                System.out.print("Enter Last Name: ");
                while(true) {try {
                    String LastName = scanner.nextLine();
                    if (!isValidString(LastName)) {throw new InputMismatchException();
                    }
                    employee.setLastName(LastName);
                    break;
                } catch (InputMismatchException e) {
                    logger.error("Invalid input exception: {}",e.getMessage(),e);
                    System.out.println("Invalid input. Please enter a valid Last Name: ");
                     }
                }
               // employee.setLastName(scanner.nextLine());
                System.out.print("Enter salary: ");
                while (true) {
                    try {
                        employee.setSalary(scanner.nextDouble());
                        scanner.nextLine();
                        break;
                    } catch
                    (InputMismatchException e) {
                        logger.error("Invalid input exception: {}",e.getMessage(),e);
                        System.out.println("Invalid input. Please enter a valid Salary: ");
                        scanner.next();
                    }
                }
                logger.info("Employee created successfully");
                return employee;
            }
       private static boolean isValidString(String input) {
 //String input = scanner.nextLine();
 return input.matches("[a-zA-Z]+");
}
    private static void updateEmployee(EmployeeManager employeeManager, Scanner scanner) {
        logger.info("Updating Employee...");
        boolean isUpdateSuccessful =  false;
        while (!isUpdateSuccessful) {
            try {
                System.out.print("Enter the employee ID to update: ");
                int employeeID = scanner.nextInt();
                scanner.nextLine();

                if (employeeID == -1) {
                    break;
                }
                Employee exsitingEmployee = findEmployeeID(employeeManager, employeeID);
                if (exsitingEmployee != null) {
                    Employee updatedEmployee = createEmployeeFromUserInput(scanner);
                    employeeManager.updateEmployee(employeeID, updatedEmployee);
                    logger.info("Employee Updated Successfully");
                    isUpdateSuccessful = true;
                } else {
                    logger.error("Employee not found for update .Invalid ID : {}", employeeID);
                    //throw new InputMismatchException ("Employee not found for update.");
                    System.out.println("Employee not found for update or enter -1 to exit.");
                    continue;

                }
                System.out.println("Press Enter to continue: ");
                scanner.nextLine();

            } catch (InputMismatchException e) {
                logger.error("Invalid input exception: {}", e.getMessage(), e);
                System.out.println("Invalid input. Please enter a valid ID: ");
                scanner.next();
            } catch (InvalidInputException e) {
                logger.error("Invalid input exception: {}", e.getMessage(), e);
                System.out.println("Invalid input. " + e.getMessage());
                System.out.println("Press Enter to continue..");
                scanner.nextDouble();
                // throw new RuntimeException(e);
            }
        }
    }
    private static void deleteEmployee(EmployeeManager employeeManager, Scanner scanner) {
        logger.info("Deleting Employee...");
        boolean isDeleteSuccessful =  false;
        while (!isDeleteSuccessful) {
            try {

            System.out.println("Enter employee ID to delete: ");
            int employeeID = scanner.nextInt();
            scanner.nextLine();
            if (employeeID == -1) {
             break;
            }

                Employee exsitingEmployee = findEmployeeID(employeeManager, employeeID);
                if (exsitingEmployee != null) {
                    EmployeeManager.deleteEmployee(employeeID);
                    logger.info("Employee deleted Successfully");
                    System.out.println("Employee deleted Successfully");
                    isDeleteSuccessful  = true;
                } else {
                    logger.error("Employee not found for deletion. Invalid ID: {}", employeeID);
                    System.out.println("Employee not found for deletion. Please enter a valid ID or enter -1 to exit: ");
                    continue;
                }
                System.out.println("Press Enter to continue: ");
                scanner.nextLine();

            } catch (InputMismatchException e) {
                logger.error("Invalid input exception: {}", e.getMessage(), e);
                System.out.println("Invalid input. Please enter a valid ID: ");
                scanner.next();
            } catch (InvalidInputException e) {
              logger.error("Invalid input exception: {}", e.getMessage(), e);
              System.out.println("Invalid input. " + e.getMessage());
                System.out.println("Press Enter to continue..");
                scanner.nextDouble();
            }
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