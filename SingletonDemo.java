class AppSettings {
    private static AppSettings instance = new AppSettings();
    private AppSettings() {
        System.out.println("AppSettings object created.");
    }
    public static AppSettings getInstance() {
        return instance;
    }
    public void displayMessage() {
        System.out.println("Using the same application settings object.");
    }
}
class SingletonDemo {

    public static void main(String[] args) {

        AppSettings first = AppSettings.getInstance();
        AppSettings second = AppSettings.getInstance();

        first.displayMessage();
        if (first == second) {
            System.out.println("Success! Only one Singleton object exists.");
        } else {
            System.out.println("Different objects were created.");
        }
    }
}