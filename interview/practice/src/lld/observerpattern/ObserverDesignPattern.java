package lld.observerpattern;

import lld.observerpattern.observable.Channel;
import lld.observerpattern.observer.Subscriber;

public class ObserverDesignPattern {

    public static void main(String[] args) {

        Channel channel = new Channel("CoderArmy");

        Subscriber subs1 = new Subscriber("Varun", channel);
        Subscriber subs2 = new Subscriber("Tarun", channel);

        channel.subscribe(subs1);
        channel.subscribe(subs2);

        channel.uploadVideo("Observer Pattern Tutorial");

        channel.unsubscribe(subs1);

        channel.uploadVideo("Decorator Pattern Tutorial");
    }
}
