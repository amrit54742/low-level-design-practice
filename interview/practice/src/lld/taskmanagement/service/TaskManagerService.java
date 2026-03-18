package lld.taskmanagement.service;

import lld.taskmanagement.model.Task;
import lld.taskmanagement.model.TaskStatus;
import lld.taskmanagement.model.User;
import lld.taskmanagement.observer.Observer;
import lld.taskmanagement.strategy.TaskFilterStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManagerService {
    private static TaskManagerService instance;

    private Map<String, Task> taskMap = new HashMap<>();
    private List<Observer> observers = new ArrayList<>();

    private TaskManagerService() {}

    public static TaskManagerService getInstance() {
        if (instance == null)
            instance = new TaskManagerService();
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(Task task) {
        for (Observer o : observers) {
            o.update(task);
        }
    }

    public void createTask(Task task) {
        taskMap.put(task.getId(), task);
    }

    public void assignTask(String taskId, User user) {

        Task task = taskMap.get(taskId);
        task.setAssignedUser(user);

        notifyObservers(task);
    }

    public void updateStatus(String taskId, TaskStatus status) {

        Task task = taskMap.get(taskId);
        task.setStatus(status);
    }

    public List<Task> getTasks(TaskFilterStrategy strategy) {

        return strategy.filter(new ArrayList<>(taskMap.values()));
    }
}
