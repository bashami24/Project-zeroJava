package org.example.Model;

public class Employee {
    private int employeeID;
    private String FirstName;
    private String LastName;
    private double Salary;

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public int getEmployeeID(){
    return employeeID;
}
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}
