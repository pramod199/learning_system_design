package lld.facade_design_pattern;

public class EmployeeFacade {
    private EmployeeDAO employeeDAO;

    public EmployeeFacade() {
        this.employeeDAO = new EmployeeDAO();
    }

    public void insertEmployee(Employee employee) {
        employeeDAO.insert(employee);
    }
}
