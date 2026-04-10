package lld.customersupport;

import lld.customersupport.service.SupportService;

public class SupportMain {
    public static void main(String[] args) throws InterruptedException {

        SupportService service = SupportService.getInstance();

        // Add agents (each runs its own thread)
        service.addAgent("A1");
        service.addAgent("A2");

        // Create tickets
        service.createTicket("Payment issue");
        service.createTicket("Login failure");
        service.createTicket("Refund request");
        service.createTicket("Account blocked");
        System.out.println("done with execution ");
        Thread.sleep(10000); // let system process

        service.shutdown();
    }
}
