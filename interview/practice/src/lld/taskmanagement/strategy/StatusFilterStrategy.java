package lld.taskmanagement.strategy;

import lld.taskmanagement.model.Task;
import lld.taskmanagement.model.TaskStatus;

import java.util.List;
import java.util.stream.Collectors;

public class StatusFilterStrategy implements TaskFilterStrategy{
    private TaskStatus status;

    public StatusFilterStrategy(TaskStatus status) {
        this.status = status;
    }

    @Override
    public List<Task> filter(List<Task> tasks) {
        return tasks.stream()
                .filter(t -> t.getStatus() == status)
                .collect(Collectors.toList());
    }
}
