package lld.customersupport2;


import lld.customersupport2.service.SupportService;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        SupportService service = SupportService.getInstance();

        service.addAgent("A1");
        service.addAgent("A2");

        service.start();

        service.createTicket("Payment issue");
        service.createTicket("Login issue");
        service.createTicket("Refund request");
        service.createTicket("Account locked");

        Thread.sleep(10000);

        service.shutdown();
    }
}