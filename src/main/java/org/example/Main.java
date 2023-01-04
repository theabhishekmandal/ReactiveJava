package org.example;

import io.reactivex.rxjava3.core.Observable;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        Observable<String> observable = Observable.create(emitter -> {
            emitter.onNext("hello");
            emitter.onNext("test");
        });

        observable.subscribe(x -> System.out.println("subscriber 1 " + x));
        observable.subscribe(x -> System.out.println("subscriber 2 " + x));
    }
}
