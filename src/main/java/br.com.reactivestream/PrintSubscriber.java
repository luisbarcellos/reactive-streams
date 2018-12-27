package br.com.reactivestream;

import java.util.Random;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.*;

public class PrintSubscriber implements Subscriber<Integer> {
    public Flow.Subscription subscription;

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
        try {
            Thread.sleep(new Random().nextInt(10) * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        subscription.request(1);
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