package org.example.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.example.dto.Util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SchedulerExample {
    public static void main(String[] args) {

        // Run them separately otherwise all will run at same time.
//        computationScheduler();
//        ioScheduler();
//        newThreadScheduler();
//        singleScheduler();
        customScheduler();
        Util.sleep(50);
    }

    private static Observable<String> createObservable() {
        return Observable.just("Pasta", "Pizza", "Paneer", "Taco");
    }

    private static void compute(String e) {
        System.out.println("Executed by : " + Thread.currentThread().getName() + " with value: " + e);
        Util.sleep(1);
    }

    private static void computationScheduler() {
        Observable<String> observable = createObservable().subscribeOn(Schedulers.computation());

        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
    }

    private static void ioScheduler() {
        Observable<String> observable = createObservable().subscribeOn(Schedulers.io());

        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
    }

    private static void newThreadScheduler() {
        Observable<String> observable = createObservable().subscribeOn(Schedulers.newThread());

        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
    }

    private static void singleScheduler() {
        Observable<String> observable = createObservable().subscribeOn(Schedulers.single());

        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
    }

    private static void customScheduler() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Observable<String> observable = createObservable().subscribeOn(Schedulers.from(executorService))
                        .doFinally(executorService::shutdown);

        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));
        observable.subscribe(e -> compute(e));

    }
}
