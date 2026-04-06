package lld.notificationsystem;

import lld.notificationsystem.Notification.INotification;
import lld.notificationsystem.Notification.SignatureDecorator;
import lld.notificationsystem.Notification.SimpleNotification;
import lld.notificationsystem.Notification.TimestampDecorator;
import lld.notificationsystem.Observers.Logger;
import lld.notificationsystem.Observers.NotificationEngine;
import lld.notificationsystem.Service.NotificationService;
import lld.notificationsystem.strategy.EmailStrategy;
import lld.notificationsystem.strategy.PopUpStrategy;
import lld.notificationsystem.strategy.SMSStrategy;

public class NotificationMain {
    public static void main(String[] args) {

        NotificationService notificationService = NotificationService.getInstance();

        Logger logger = new Logger();

        NotificationEngine notificationEngine = new NotificationEngine();
        notificationEngine.addNotificationStrategy(new EmailStrategy("random.person@gmail.com"));
        notificationEngine.addNotificationStrategy(new SMSStrategy("+91 9876543210"));
        notificationEngine.addNotificationStrategy(new PopUpStrategy());

        INotification notification = new SimpleNotification("Your order has been shipped!");
        notification = new TimestampDecorator(notification);
        notification = new SignatureDecorator(notification, "Customer Care");

        notificationService.sendNotification(notification);
    }
}