package edu.parinya.softarchdesign.behavioral;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;

public class NewsPublisher implements Publisher<News> {
	// You need to implement this class
	private HashSet<Subscriber<? super News>> subscribers = new HashSet<>();

    @Override
    public void subscribe(Subscriber<? super News> subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber<? super News> subscriber) {
        subscribers.remove(subscriber);
    }

    public void publish(News news) {
        for (Subscriber<? super News> subscriber : subscribers) {
            subscriber.onNext(news);
        }
    }
}
