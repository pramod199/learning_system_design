package lld.proxy_design_pattern;

public class ProxyDesignPattern {
    public static void main(String[] args) {
        try{
            EmployeeDao employeeDaoProxy = new EmployeeDaoProxy();

            employeeDaoProxy.create("abc", new EmployeeDaoImpl());
            employeeDaoProxy.update("admin", 1);
            employeeDaoProxy.get("admin", 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
