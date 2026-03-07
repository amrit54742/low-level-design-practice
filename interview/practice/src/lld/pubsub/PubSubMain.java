package lld.pubsub;

import lld.pubsub.model.Content;
import lld.pubsub.model.Publisher;
import lld.pubsub.service.PubSubService;
import lld.pubsub.subscriber.Subscriber;

public class PubSubMain {

    public static void main(String[] args) {

        PubSubService service = PubSubService.getInstance();

        service.addTopic("orders");

        Subscriber sub1 = new Subscriber("AnalyticsService");
        Subscriber sub2 = new Subscriber("NotificationService");

        service.subscribe("orders", sub1);
        service.subscribe("orders", sub2);

        Publisher publisher = new Publisher();

        publisher.publish("orders", new Content("Order Created"));
    }


}
