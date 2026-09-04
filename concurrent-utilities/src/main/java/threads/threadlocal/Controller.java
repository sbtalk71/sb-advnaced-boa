package threads.threadlocal;
public class Controller {

    public void processRequest() {

        UserContext.setUser("John");

        service();
    }

    private void service() {

        System.out.println(
            "Current user: " + UserContext.getUser()
        );
    }
}