package machine_coding.uber.meeting_schedular;

public class Employee implements BookingObserver {
    int id;

    public Employee(int id) {
        this.id = id;
    }


    @Override
    public void notify(String message) {
        System.out.println("Employee " + id + " "+message);
    }
}
