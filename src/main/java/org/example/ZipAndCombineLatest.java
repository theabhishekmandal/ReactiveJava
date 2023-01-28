package org.example;

import io.reactivex.rxjava3.core.Observable;
import org.example.dto.Util;

import java.util.concurrent.TimeUnit;

public class ZipAndCombineLatest {
    public static void main(String[] args) {
        zip();
        combineLatest();
    }

    private static void zip() {
        Observable<Long> src1 = Observable.interval(200, TimeUnit.MILLISECONDS);
        Observable<Long> src2 = Observable.interval(1, TimeUnit.SECONDS);

        Observable.zip(src1, src2, (e1, e2) -> "Source 1: " + e1 + " Source 2: " + e2)
                .subscribe(System.out::println);

        Util.sleep(20);
    }

    private static void combineLatest() {
        Observable<Long> src1 = Observable.interval(200, TimeUnit.MILLISECONDS);
        Observable<Long> src2 = Observable.interval(1, TimeUnit.SECONDS);

        Observable.combineLatest(src1, src2, (e1, e2) -> "Source 1: " + e1 + " Source 2: " + e2)
                .subscribe(System.out::println);

        Util.sleep(20);
    }
}
