package lld.observerpattern.observable;

import lld.observerpattern.observer.ISubscriber;

public interface IChannel {

    void subscribe(ISubscriber subscriber);

    void unsubscribe(ISubscriber subscriber);

    void notifySubscribers();
}