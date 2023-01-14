package org.example;

import java.util.concurrent.TimeUnit;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class DisposableExample {
    public static void main(String[] args) throws InterruptedException {

        example1();
        example2();
    }

    private static void example1() throws InterruptedException {
    /*
        For an observable emitting data. If we externally want to stop the emissions
        then we must call the dispose method.

        In below example after emitting for 5 seconds we can call dispose to stop the emissions.
     */
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

        var disposable1 = source.subscribe(x -> System.out.println("Observer 1 " + x));
        var disposable2 = source.subscribe(x -> System.out.println("Observer 2 " + x));

        Thread.sleep(5000);

        disposable1.dispose();
        disposable2.dispose();
    }

    private static void example2() throws InterruptedException {
        /*
            Same example as above but using CompositeDisposable.
         */
        Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.addAll(
                source.subscribe(x -> System.out.println("Observer 1 " + x)),
                source.subscribe(x -> System.out.println("Observer 2 " + x)));

        Thread.sleep(5000);

        compositeDisposable.dispose();
    }
}
