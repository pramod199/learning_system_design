package machine_coding.uber.job_scheduler.async_job_scheduler;

import java.time.Instant;

public class SchedulerFinalDemo {
    public static void main(String[] args) throws InterruptedException {
        TaskScheduler scheduler = new TaskScheduler(2);
        System.out.println("======test 1: dependency test=======");
        Task t1 = () -> System.out.println("running task1");
        Task t2 = () -> System.out.println("running task2");
        Task t3 = () -> System.out.println("running task3");

        String task2 = scheduler.schedule(new TaskSpec().task(t2).policy(new OneTimePolicy(System.currentTimeMillis())));
        String task1 = scheduler.schedule(
                new TaskSpec()
                        .task(t1)
                        .policy(new OneTimePolicy(System.currentTimeMillis()))
                        .dependsOn(task2));

        String task3 = scheduler.schedule(
                new TaskSpec()
                        .task(t3)
                        .policy(new OneTimePolicy(System.currentTimeMillis()))
        );

        Thread.sleep(2000);
        System.out.println("\n=== TEST 2: delay + dependency ===");

        String d2 = scheduler.schedule(
                new TaskSpec()
                        .task(() -> System.out.println("running delayed task2"))
                        .policy(new OneTimePolicy(Instant.now().plusSeconds(3).toEpochMilli()))
        );

        String d1 = scheduler.schedule(
                new TaskSpec()
                        .task(() -> System.out.println("running task1 after task2"))
                        .policy(new OneTimePolicy(System.currentTimeMillis()))
                        .dependsOn(d2)
        );

        String d3 = scheduler.schedule(
                new TaskSpec()
                        .task(() -> System.out.println("running task3"))
                        .policy(new OneTimePolicy(System.currentTimeMillis()))
        );

        Thread.sleep(6000);
        System.out.println("\n=== TEST 3: recurring every 1s ===");

        scheduler.schedule(
                new TaskSpec()
                        .task(() -> System.out.println(
                                "tick " + System.currentTimeMillis() / 1000))
                        .policy(new FixedDelayPolicy(1000))
        );

        Thread.sleep(4500); // expect ~4 ticks


//        scheduler.shutdown();
    }
}
