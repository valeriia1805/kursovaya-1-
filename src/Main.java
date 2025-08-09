import java.util.Objects;



class Employee {

    private static int idCounter = 1;



    private final int id;

    private final String fullName;

    private int department;

    private double salary;



    public Employee(String fullName, int department, double salary) {

        this.id = idCounter++;

        this.fullName = fullName;

        this.department = department;

        this.salary = salary;

    }



    public int getId() {

        return id;

    }



    public String getFullName() {

        return fullName;

    }



    public int getDepartment() {

        return department;

    }



    public double getSalary() {

        return salary;

    }



    public void setDepartment(int department) {

        this.department = department;

    }



    public void setSalary(double salary) {

        this.salary = salary;

    }



    @Override

    public String toString() {

        return "Employee{" +

                "id=" + id +

                ", fullName='" + fullName + '\'' +

                ", department=" + department +

                ", salary=" + salary +

                '}';

    }



    @Override

    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Employee employee)) return false;

        return id == employee.id &&

                department == employee.department &&

                Double.compare(employee.salary, salary) == 0 &&

                fullName.equals(employee.fullName);

    }



    @Override

    public int hashCode() {

        return Objects.hash(id, fullName, department, salary);

    }

}



public class Main {

    private static final Employee[] employees = new Employee[10];



    public static void main(String[] args) {

        employees[0] = new Employee("Ivanov Ivan", 1, 50000);

        employees[1] = new Employee("Petrov Petr", 2, 60000);

        employees[2] = new Employee("Sidorov Semen", 1, 45000);

        employees[3] = new Employee("Kuznetsov Vacheslav", 3, 70000);

        employees[4] = new Employee("Andreeva Anna", 4, 80000);

        employees[5] = new Employee("Morozov Nikolay", 5, 40000);

        employees[6] = new Employee("Vasiliev Stepan", 2, 62000);

        employees[7] = new Employee("Smirnova Vika", 3, 75000);

        employees[8] = new Employee("Fedorov Artemy", 4, 55000);

        employees[9] = new Employee("Tikhonov Yaroslav", 5, 47000);



        printAllEmployees();

        System.out.println("Total Salary: " + calculateTotalSalary());

        System.out.println("Min Salary Employee: " + findEmployeeWithMinSalary());

        System.out.println("Max Salary Employee: " + findEmployeeWithMaxSalary());

        System.out.println("Average Salary: " + calculateAverageSalary());

        System.out.println("List:");

        printAllEmployeeNames();

    }



    public static void printAllEmployees() {

        for (Employee emp : employees) {

            System.out.println(emp);

        }

    }



    public static double calculateTotalSalary() {

        double sum = 0;

        for (Employee emp : employees) {

            sum += emp.getSalary();

        }

        return sum;

    }



    public static Employee findEmployeeWithMinSalary() {

        Employee min = employees[0];

        for (Employee emp : employees) {

            if (emp.getSalary() < min.getSalary()) {

                min = emp;

            }

        }

        return min;

    }



    public static Employee findEmployeeWithMaxSalary() {

        Employee max = employees[0];

        for (Employee emp : employees) {

            if (emp.getSalary() > max.getSalary()) {

                max = emp;

            }

        }

        return max;

    }



    public static double calculateAverageSalary() {

        return calculateTotalSalary() / employees.length;

    }



    public static void printAllEmployeeNames() {

        for (Employee emp : employees) {

            System.out.println(emp.getFullName());

        }

    }

}