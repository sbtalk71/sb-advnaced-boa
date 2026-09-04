package threads.threadlocal;
public class Application {

    public static void main(String[] args) {

        RequestContext.setRequestId("REQ-1001");

        OrderService service = new OrderService();

        service.createOrder();

        RequestContext.clear();
    }
}