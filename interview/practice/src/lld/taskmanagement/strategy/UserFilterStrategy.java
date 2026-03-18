package lld.taskmanagement.strategy;

import lld.taskmanagement.model.Task;
import lld.taskmanagement.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserFilterStrategy implements TaskFilterStrategy{
    private User user;

    public UserFilterStrategy(User user) {
        this.user = user;
    }

    @Override
    public List<Task> filter(List<Task> tasks) {
        return tasks.stream()
                .filter(t -> t.getAssignedUser().getId().equals(user.getId()))
                .collect(Collectors.toList());
    }
}
