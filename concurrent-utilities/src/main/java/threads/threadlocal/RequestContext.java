package threads.threadlocal;
public class RequestContext {

    private static ThreadLocal<String> requestId =
            new ThreadLocal<>();

    public static void setRequestId(String id) {
        requestId.set(id);
    }

    public static String getRequestId() {
        return requestId.get();
    }

    public static void clear() {
        requestId.remove();
    }
}