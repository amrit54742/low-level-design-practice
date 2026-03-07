package lld.pubsub.subscriber;

import lld.pubsub.model.Content;

public class Subscriber implements ISubscriber{

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void consume(Content content) {
        System.out.println("Hey "+ name + ", we have received message " + content.getMessage());
    }
}
