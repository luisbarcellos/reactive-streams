package br.com.reactivestream;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.*;

public class PrintSubscriber implements Subscriber<Integer> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(2);
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("Processando onNext");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Received item: " + item);
        subscription.request(2);
    }

    @Override
    public void onError(Throwable error) {
        System.out.println("Error occurred: " + error.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("PrintSubscriber is complete");
    }
}