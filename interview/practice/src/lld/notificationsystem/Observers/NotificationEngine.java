package lld.notificationsystem.Observers;

import lld.notificationsystem.Observer.IObserver;
import lld.notificationsystem.Observer.NotificationObservable;
import lld.notificationsystem.Service.NotificationService;
import lld.notificationsystem.strategy.INotificationStrategy;

import java.util.ArrayList;
import java.util.List;

public class NotificationEngine implements IObserver {
    private NotificationObservable notificationObservable;
    private List<INotificationStrategy> notificationStrategies = new ArrayList<>();

    public NotificationEngine() {
        this.notificationObservable = NotificationService.getInstance().getObservable();
        notificationObservable.addObserver(this);
    }

    public void addNotificationStrategy(INotificationStrategy ns) {
        this.notificationStrategies.add(ns);
    }

    public void update() {
        String notificationContent = notificationObservable.getNotificationContent();
        for (INotificationStrategy strategy : notificationStrategies) {
            strategy.sendNotification(notificationContent);
        }
    }
}