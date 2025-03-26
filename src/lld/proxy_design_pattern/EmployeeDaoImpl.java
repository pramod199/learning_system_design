package lld.proxy_design_pattern;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void create(String client, EmployeeDao obj) throws Exception {
        System.out.println("Created new row in employee table");
    }

    @Override
    public void update(String client, int empId) throws Exception {
        System.out.println("Updated row in employee table");
    }

    @Override
    public EmployeeDao get(String client, int empId) throws Exception {
        System.out.println("Fetched row from employee table");
        return new EmployeeDaoImpl();
    }
}
