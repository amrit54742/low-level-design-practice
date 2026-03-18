package lld.taskmanagement.strategy;

import lld.taskmanagement.model.Task;

import java.util.List;

public interface TaskFilterStrategy {
    List<Task> filter(List<Task> tasks);
}
