package machine_coding.uber.job_scheduler.async_job_scheduler;

class DependencyNotFoundException extends RuntimeException {
    DependencyNotFoundException(String msg) {
        super(msg);
    }
}
