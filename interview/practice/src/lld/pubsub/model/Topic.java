package lld.pubsub.model;

import lld.pubsub.subscriber.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private String name;
    private List<ISubscriber> subscriberList= new ArrayList<>();

    public Topic(String name) {
        this.name = name;
    }

    public void addSubscriber(ISubscriber subscriber){
        subscriberList.add(subscriber);
    }

    public void removeSubscriber(ISubscriber subscriber){
        subscriberList.remove(subscriber);
    }

    public void publish(Content content){

        for (ISubscriber subscriber: subscriberList){
            subscriber.consume(content);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
