package threads.context.propagation.manual;
public class RequestContext {

    private String user;
    private String requestId;

    public RequestContext(String user, String requestId) {
        this.user = user;
        this.requestId = requestId;
    }

    public String getUser() {
        return user;
    }

    public String getRequestId() {
        return requestId;
    }
}