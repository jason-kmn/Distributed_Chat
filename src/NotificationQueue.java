import java.util.LinkedList;

public class NotificationQueue {

    LinkedList<String> notificationList;

    public NotificationQueue(){
        notificationList = new LinkedList<>();
    }

    public void addNotification(String notification){
        notificationList.add(notification);
    }
}
