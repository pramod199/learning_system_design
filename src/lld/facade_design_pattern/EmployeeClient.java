package lld.facade_design_pattern;

public class EmployeeClient {
    public static void main(String[] args) {
        EmployeeFacade employeeFacade = new EmployeeFacade();
        employeeFacade.insertEmployee(new Employee("John", "123 Main St", "123-456-7890"));
    }
}
