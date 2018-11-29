package br.com.reactivestream;

import java.util.concurrent.SubmissionPublisher;

public class Main{
    public static void main(String[]args) throws InterruptedException {
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        publisher.subscribe(new PrintSubscriber());
        System.out.println("Submitting items...");

        java.util.stream.IntStream.range(0, 10)
            .forEach(i -> publisher.submit(i));

        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000);
        publisher.close();
    }
}