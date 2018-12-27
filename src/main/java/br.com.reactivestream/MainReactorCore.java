package br.com.reactivestream;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class MainReactorCore {
    public static void main(String[]args) throws InterruptedException{

        System.out.println("Submitting items...");
        Flux.range(0,100)
            .publishOn(Schedulers.parallel())
            .subscribe(i -> {
                System.out.println("Thread - " + Thread.currentThread().getName());
                System.out.println(i);
            });

        System.out.println("Thread - " + Thread.currentThread().getName());
        Thread.sleep(10000);
    }
}
