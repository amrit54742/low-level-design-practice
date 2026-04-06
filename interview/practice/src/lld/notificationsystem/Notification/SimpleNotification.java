package lld.notificationsystem.Notification;

public class SimpleNotification implements INotification {
    private String text;

    public SimpleNotification(String msg) {
        this.text = msg;
    }
    @Override
    public String getContent() {
        return text;
    }
}