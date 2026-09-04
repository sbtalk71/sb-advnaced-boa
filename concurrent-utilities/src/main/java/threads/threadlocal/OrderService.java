package threads.threadlocal;
public class OrderService {

    public void createOrder() {

        System.out.println(
            "Request ID = "
            + RequestContext.getRequestId()
        );

        System.out.println("Creating order...");
    }
}