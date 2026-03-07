package lld.pubsub.model;

import lld.pubsub.service.PubSubService;

public class Publisher {

    public void publish(String topicName, Content content){
        PubSubService.getInstance().publish(topicName, content);
    }

}
