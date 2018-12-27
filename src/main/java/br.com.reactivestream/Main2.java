package br.com.reactivestream;

import java.util.concurrent.SubmissionPublisher;

public class Main2 {
    public static void main(String[]args) throws InterruptedException{
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        PlusTenProcessor processor = new PlusTenProcessor();
        PrintSubscriber subscriber = new PrintSubscriber();
        publisher.subscribe(processor);
        processor.subscribe(subscriber);

        System.out.println("Submitting items...");

        java.util.stream.IntStream.range(0, 10)
                .forEach(i -> {
                    System.out.println(i);
                    publisher.submit(i);
                });

        Thread.sleep(10000);
        publisher.close();
    }
}
