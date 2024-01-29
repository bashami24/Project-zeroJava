package org.example.Model;

import java.util.Objects;

public class Employee {
    private int employeeID;
    private String FirstName;
    private String LastName;
    private double Salary;
public Employee (int employeeID, String FirstName, String LastName,double Salary){
    this.employeeID = employeeID;
    this.FirstName =  FirstName;
    this.LastName = LastName;
    this.Salary = Salary;
}
public Employee () {
    this(0,"","",0.0);
}
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
public double getSalary() {
    return Salary;
}
    public int getEmployeeID(){
        return employeeID;
    }

    public String getFirstName() { return FirstName; }

    public String getLastName () { return LastName;}
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Salary=" + Salary +
                '}';
    }
        public boolean equals(Object obj) {
            if (this == obj) { return true;
            }

            if(obj ==null || getClass() != obj.getClass()) {
                return false;
            }
            Employee employee = (Employee) obj;
            return employeeID == employee.employeeID &&
                    Double.compare(employee.Salary,Salary) == 0 &&
                    Objects.equals(FirstName, employee.FirstName) &&
                    Objects.equals(LastName, employee.LastName);
        }
        public int hashCode() {
            return Objects.hash(employeeID,FirstName,LastName,Salary);
        }
    }
