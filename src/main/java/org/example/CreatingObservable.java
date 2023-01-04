package org.example;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class CreatingObservable {
    public static void main(String[] args) {
        // using create
        Observable<Integer> source = Observable.create(e -> {
           e.onNext(1);
           e.onNext(2);
        });

        source.subscribe(System.out::println);

        // using just
        Observable<Integer> just = Observable.just(1, 2);
        just.subscribe(System.out::println);

        // from Iterable
        List<Integer> list = List.of(13, 4, 5);
        Observable<Integer> iterableObservable = Observable.fromIterable(list);
        iterableObservable.subscribe(System.out::println);
    }
}
