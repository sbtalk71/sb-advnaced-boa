package threads.threadlocal;
public class UserContext {

    private static ThreadLocal<String> currentUser =
            new ThreadLocal<>();

    public static void setUser(String user) {
        currentUser.set(user);
    }

    public static String getUser() {
        return currentUser.get();
    }

    public static void clear() {
        currentUser.remove();
    }
}