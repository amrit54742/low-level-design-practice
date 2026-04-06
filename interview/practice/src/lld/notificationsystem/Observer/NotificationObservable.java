package lld.notificationsystem.Observer;

import lld.notificationsystem.Notification.INotification;

import java.util.ArrayList;
import java.util.List;

public class NotificationObservable implements IObservable {
    private List<IObserver> observers = new ArrayList<>();
    private INotification currentNotification = null;

    @Override
    public void addObserver(IObserver obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(IObserver obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (IObserver obs : observers) {
            obs.update();
        }
    }

    public void setNotification(INotification notification) {
        this.currentNotification = notification;
        notifyObservers();
    }

    public INotification getNotification() {
        return currentNotification;
    }

    public String getNotificationContent() {
        return currentNotification.getContent();
    }
}
