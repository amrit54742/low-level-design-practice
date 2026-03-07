package lld.pubsub.subscriber;

import lld.pubsub.model.Content;

public interface ISubscriber {
    public void consume(Content content);

}
