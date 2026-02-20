package machine_coding.uber.job_scheduler.job_sch_youtube;

public class DependencyNotFoundException extends RuntimeException{

    DependencyNotFoundException(String msg){
        super(msg);
    }

}
