package lld.taskmanagement;

import lld.taskmanagement.model.Priority;
import lld.taskmanagement.model.Task;
import lld.taskmanagement.model.TaskStatus;
import lld.taskmanagement.model.User;
import lld.taskmanagement.observer.NotificationService;
import lld.taskmanagement.service.TaskManagerService;
import lld.taskmanagement.strategy.UserFilterStrategy;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        TaskManagerService service = TaskManagerService.getInstance();

        service.addObserver(new NotificationService());

        User u1 = new User("1", "Amrit");
        User u2 = new User("2", "Rahul");

        Task t1 = new Task("T1", "Design System",
                "LLD prep", u1,
                Priority.HIGH,
                LocalDate.now().plusDays(2));

        Task t2 = new Task("T2", "Fix Bug",
                "Critical bug", u2,
                Priority.MEDIUM,
                LocalDate.now().plusDays(1));

        service.createTask(t1);
        service.createTask(t2);

        service.assignTask("T1", u2);

        service.updateStatus("T1", TaskStatus.IN_PROGRESS);

        System.out.println("\nFiltered Tasks (Assigned to Rahul):");

        service.getTasks(new UserFilterStrategy(u2))
                .forEach(task -> System.out.println(task.getId()));
    }
}
