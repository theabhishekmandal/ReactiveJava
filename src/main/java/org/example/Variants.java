package org.example;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Variants {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("Alex", "Justin", "Jack");

        // firstElement returns the first element
        source.firstElement()
                .subscribe(System.out::println);


        // An observable which denotes that there will be a single value.
        Single.just("A")
                .subscribe(System.out::println);

        // An observable which denotes that there may be a value or no value
        Maybe.just("hello")
                .subscribe(System.out::println);

        // Another maybe observable which emits no value.
        Observable<Object> emptySource = Observable.empty();
        emptySource.
                firstElement()
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed"));


        // An observable just to denote completion or exception.
        Completable complete = Completable.complete();
        complete.subscribe(() -> System.out.println("Completed"));

        // Another Completable example
        Completable.fromRunnable(() -> System.out.println("Some Process Running"))
                .subscribe(() -> System.out.println("The process executed successfully"), Throwable::printStackTrace);

    }
}
