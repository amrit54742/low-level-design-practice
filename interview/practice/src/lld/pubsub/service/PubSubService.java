package lld.pubsub.service;

import lld.pubsub.model.Content;
import lld.pubsub.model.Topic;
import lld.pubsub.subscriber.Subscriber;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class PubSubService {
    private static PubSubService instance;
    private Map <String, Topic> stringTopicMap= new HashMap<>();


    public static PubSubService getInstance(){
        System.out.println("Current instance: " + instance);
        if (instance == null){
            instance= new PubSubService();
            return instance;
        } else {
            return instance;
        }
    }


    public void addTopic(String topicName){
        stringTopicMap.putIfAbsent(topicName, new Topic(topicName));
    }

    public void subscribe(String topicName, Subscriber subscriber) {

        Topic topic = stringTopicMap.get(topicName);
        if (topic != null) {
            topic.addSubscriber(subscriber);
        }
    }

    public void publish(String topicName, Content content) {

        Topic topic = stringTopicMap.get(topicName);
        if (topic != null) {
            topic.publish(content);
        }
    }





}
