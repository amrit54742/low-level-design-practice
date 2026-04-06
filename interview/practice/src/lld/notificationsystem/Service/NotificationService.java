package lld.notificationsystem.Service;

import lld.notificationsystem.Notification.INotification;
import lld.notificationsystem.Observer.NotificationObservable;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private NotificationObservable observable;
    private static NotificationService instance = null;
    //todo: below line is redundant. it is just keeping the history of all the events that were sent to the observers.
    // It is useful in production systems, but not here!
    private List<INotification> notifications = new ArrayList<>(); //redundant

    private NotificationService() {
        observable = new NotificationObservable();
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public NotificationObservable getObservable() {
        return observable;
    }

    public void sendNotification(INotification notification) {
        notifications.add(notification);
        observable.setNotification(notification);
    }
}