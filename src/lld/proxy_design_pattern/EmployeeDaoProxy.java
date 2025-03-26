package lld.proxy_design_pattern;

public class EmployeeDaoProxy implements EmployeeDao {

    EmployeeDao employeeDao;

    EmployeeDaoProxy() {
        this.employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, EmployeeDao obj) throws Exception {
        if (client.equals("admin")) {
            employeeDao.create(client, obj);
        } else {
            throw new Exception("You are not authorized to create a new employee");
        }
    }

    @Override
    public void update(String client, int empId) throws Exception {
        if (client.equals("admin")) {
            employeeDao.update(client, empId);
        } else {
            throw new Exception("You are not authorized to update an employee");
        }
    }

    @Override
    public EmployeeDao get(String client, int empId) throws Exception {
        if (client.equals("admin") || client.equals("user")) {
            return employeeDao.get(client, empId);
        } else {
            throw new Exception("You are not authorized to get an employee");
        }
    }
}
