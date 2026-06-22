interface Notification {
    void send();
}
class EmailNotification implements Notification {
    public void send() {
        System.out.println("Email notification sent successfully.");
    }
}
class SMSNotification implements Notification {
    public void send() {
        System.out.println("SMS notification sent successfully.");
    }
}
class PushNotification implements Notification {
    public void send() {
        System.out.println("Push notification sent successfully.");
    }
}
class NotificationFactory {

    public static Notification createNotification(String type) {

        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else if (type.equalsIgnoreCase("PUSH")) {
            return new PushNotification();
        } else {
            return null;
        }
    }
}
class FactoryMethodDemo {

    public static void main(String[] args) {

        Notification notification1 =
                NotificationFactory.createNotification("EMAIL");

        Notification notification2 =
                NotificationFactory.createNotification("SMS");

        Notification notification3 =
                NotificationFactory.createNotification("PUSH");

        notification1.send();
        notification2.send();
        notification3.send();
    }
}