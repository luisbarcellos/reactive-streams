package br.com.reactivestream;

import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;

public class Main{
    public static void main(String[]args) throws InterruptedException {
//        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

//        MultiThreads
//        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>(Executors.newFixedThreadPool(4), 1);
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

        PrintSubscriber subscriber = new PrintSubscriber();
        publisher.subscribe(subscriber);
        System.out.println("Submitting items...");

        java.util.stream.IntStream.range(0, 10)
            .forEach(i -> {
                System.out.println(i);
                publisher.submit(i);
            });

        System.out.println(Thread.currentThread().getName());
        Thread.sleep(10000);
        publisher.close();
    }
}