package org.example;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

/**
 * <a href=https://stackoverflow.com/questions/2521277/what-are-the-hot-and-cold-observables>Hot and Cold Observables</a>
 */
public class HotAndColdObserver {
    public static void main(String[] args) {
        coldObservable();
        hotObservable();

    }

    private static void hotObservable() {
        /*
           Hot observable produces data even if there are no observers. It produces data
           regardless
         */

        ConnectableObservable<Long> connectableObservable = Observable.interval(1, TimeUnit.SECONDS).publish();

        connectableObservable.connect();
        sleep(2);
        connectableObservable.subscribe(System.out::println);
        sleep(10);


        connectableObservable.subscribe(System.out::println);
        sleep(5);
    }

    private static void coldObservable() {
        /*
            Cold observable produces data for each observer. It only produces the data
            when an observer is subscribed to the observable.
         */
        Observable<Long> integerObservable = Observable.interval(1, TimeUnit.SECONDS);

        integerObservable.subscribe(System.out::println);
        System.out.println();

        sleep(1);

        integerObservable.subscribe(System.out::println);
        sleep(5);
    }


    private static void sleep(long secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
