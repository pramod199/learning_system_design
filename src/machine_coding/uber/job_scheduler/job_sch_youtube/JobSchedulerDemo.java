package machine_coding.uber.job_scheduler.job_sch_youtube;

import java.time.Instant;
import java.util.Collections;

public class JobSchedulerDemo {
    /*
    Design async task management.

    - User can define task
    - Do we support one time task or recurring task also? - recurring as well (with fixed delay)
    - Do we have task dependency ?  yes
    - can task have cyclic dependency-> no, if yes we will have to resolve using topo sort.
    - Do we support task cancel? -> yes
    - what will happen if task get exception or fail ->  simply logging and marking it as failed.
    - do we support multiple task running in parallel? - yes, run multiple tasks concurrently using a configurable number of worker threads.


    Task interface
    ScheduledTask -> id, task, schedulePolicy, nextRunningTime - it will implement Comparable
    ITaskService interface
        - schedule(task, delay)
        - schedule(task, delay, interval)

        - schedule(TaskSpec)
        - cancel(taskId)
        - shutDown()

    TaskSpec
        - task
        - SchedulePolicy
        - dependentTask[]

    TaskService implement ITaskService
    SchedulerEngine
     - queue
     - workers
     - dispatcher thread

    CustomException
     - DependencyNotFound
    TaskStatus enum










     */
    public static void main(String[] args) throws InterruptedException {
        TaskSchedulerImpl scheduler = new TaskSchedulerImpl(2);

        Task t1 = () -> System.out.println("running task 1");
        Task t2 = () -> System.out.println("running task 2");
        Task t3 = () -> System.out.println("running task 3");
        System.out.println("------testing dependency------");
        String t2Id = scheduler.schedule(new TaskSpec(t2)
                .policy(new OneTimeSchedule(System.currentTimeMillis()))
        );


        String t1Id = scheduler.schedule(new TaskSpec(t1)
                .policy(new OneTimeSchedule(System.currentTimeMillis()))
                .dependsOn(Collections.singletonList(t2Id))
        );


        String t3Id = scheduler.schedule(new TaskSpec(t3)
                .policy(new OneTimeSchedule(System.currentTimeMillis()))
        );

        Thread.sleep(2000);
        System.out.println("------testing dependency with delay------");

        String d2Id = scheduler.schedule(new TaskSpec(t2)
                .policy(new OneTimeSchedule(Instant.now().plusSeconds(3).toEpochMilli()))
        );


        scheduler.schedule(new TaskSpec(t1)
                .policy(new OneTimeSchedule(System.currentTimeMillis()))
                .dependsOn(Collections.singletonList(d2Id))
        );


        scheduler.schedule(new TaskSpec(t3)
                .policy(new OneTimeSchedule(System.currentTimeMillis()))
        );

        Thread.sleep(6000);
//        System.out.println("------testing recurring------");
//
//        scheduler.schedule(new TaskSpec(t2)
//                .policy(new FixedRecurringSchedule(Instant.now().plusSeconds(1).toEpochMilli(), 1000))
//        );
//
//        Thread.sleep(6000);
//        scheduler.shutDown();

    }
}
