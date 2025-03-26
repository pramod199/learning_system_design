package lld.proxy_design_pattern;

public interface EmployeeDao {
    void create(String client, EmployeeDao obj) throws Exception;
    void update(String client, int empId) throws Exception;
    EmployeeDao get(String client, int empId) throws Exception;

}
