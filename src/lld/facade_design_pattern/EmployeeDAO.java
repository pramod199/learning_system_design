package lld.facade_design_pattern;

// this has lot more method but client is interested in only insert.
public class EmployeeDAO {
    public void insert(Employee employee) {
        System.out.println("Employee inserted");
    }

    public void update(Employee employee) {
        System.out.println("Employee updated");
    }

    public void delete(Employee employee) {
        System.out.println("Employee deleted");
    }

    public void getEmployee(int employeeId) {
        System.out.println("Employee fetched");
    }
}
