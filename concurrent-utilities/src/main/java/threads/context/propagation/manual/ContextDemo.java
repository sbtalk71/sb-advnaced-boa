package threads.context.propagation.manual;
public class ContextDemo {

    public static void main(String[] args) {

        RequestContext context =
            new RequestContext("John", "REQ-101");

        Thread t = new Thread(() -> {

            System.out.println(
                "User = " + context.getUser()
            );

            System.out.println(
                "Request ID = " + context.getRequestId()
            );
        });

        t.start();
    }
}