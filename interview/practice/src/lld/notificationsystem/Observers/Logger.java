package lld.notificationsystem.Observers;

import lld.notificationsystem.Observer.IObserver;
import lld.notificationsystem.Observer.NotificationObservable;
import lld.notificationsystem.Service.NotificationService;

public class Logger implements IObserver {
    private NotificationObservable notificationObservable;

    public Logger() {
        this.notificationObservable = NotificationService.getInstance().getObservable();
        notificationObservable.addObserver(this);
    }

    public void update() {
        System.out.println("Logging New Notification : \n" +
                notificationObservable.getNotificationContent());
    }
}