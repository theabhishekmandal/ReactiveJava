package org.example;

import io.reactivex.rxjava3.core.Observable;

public class CreatingObserver {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("red", "orange", "green");

        // Creating Observer and subscribing to Observable at the same time.
        source.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed"));

        System.out.println();

        // Creating Observer with empty onComplete Action.
        source.subscribe(System.out::println, Throwable::printStackTrace);
    }
}
