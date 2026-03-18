package lld.taskmanagement.observer;

import lld.taskmanagement.model.Task;

public class NotificationService implements Observer {

    @Override
    public void update(Task task) {
        System.out.println("Notification: Task assigned to "
                + task.getAssignedUser().getName());
    }
}
