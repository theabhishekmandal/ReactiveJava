package org.example.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.example.dto.Util;

public class FlatMapWithConcurrency {
    public static void main(String[] args) {
        Observable<String> src = Observable.just("Pasta", "Pizza", "Paneer", "Taco");

        // for each element we are creating Observable which is then processed on different threads.
        Observable<String> observable = src.flatMap(
                e -> Observable.just(e).subscribeOn(Schedulers.computation())
        );

        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));

        Util.sleep(10);
    }

    private static void compute(String e) {
        System.out.println("Executed by : " + Thread.currentThread().getName() + " with value: " + e);
        Util.sleep(1);
    }
}
