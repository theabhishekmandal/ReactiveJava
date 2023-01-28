package org.example;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class MergeAndConcat {
    public static void main(String[] args) {
        mergeExample();
        concatExample();
    }

    private static void mergeExample() {
        Observable<String> src1 = Observable.just("hello", "world");
        Observable<String> src2 = Observable.just("test", "string");

        /*
            Merge operation does not considers ordering. whichever emission comes first
            it provides it to the subscriber.

            But, since below is a sequential operation that is why one Observable result
            is coming after the other.

            For concurrent observers the result will be different.
         */
        Observable.merge(src1, src2)
                .subscribe(e -> System.out.println("received " + e));


        // concurrent merge example
        Observable<String> srcConcurrent1 = Observable.interval(1, TimeUnit.SECONDS)
                .take(5).map(e -> "src 1" + e);

        Observable<String> srcConcurrent2 = Observable.interval(1, TimeUnit.SECONDS)
                .take(5).map(e -> "src 2" + e);

        Observable.merge(srcConcurrent1, srcConcurrent2)
                .subscribe(e -> System.out.println("received " + e));

        sleep(5);
    }

    private static void concatExample() {

        Observable<String> src1 = Observable.just("hello", "world");
        Observable<String> src2 = Observable.just("test", "string");

        /*
            Concat operation considers ordering. First it emits the first Observable and then the other.
            For both sequential and concurrent observables result will be the same i.e one observable result
            after another.
         */
        Observable.concat(src1, src2)
                .subscribe(e -> System.out.println("received " + e));


        // concurrent concat example
        Observable<String> srcConcurrent1 = Observable.interval(1, TimeUnit.SECONDS)
                .take(10).map(e -> "src 1" + e);

        Observable<String> srcConcurrent2 = Observable.interval(1, TimeUnit.SECONDS)
                .take(10).map(e -> "src 2" + e);

        Observable.concat(srcConcurrent1, srcConcurrent2)
                .subscribe(e -> System.out.println("received " + e));


        sleep(5);
    }

    static void sleep(long secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
