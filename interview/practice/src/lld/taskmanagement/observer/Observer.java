package lld.taskmanagement.observer;

import lld.taskmanagement.model.Task;

public interface Observer {
    void update(Task task);
}
