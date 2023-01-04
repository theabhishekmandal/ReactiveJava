package org.example;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class ObservableAndObserver {
    public static void main(String[] args) {
        // creating observable which will emit data
        Observable<Integer> source = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {

                try {
                    emitter.onNext(10);
                    emitter.onNext(11);
                    emitter.onComplete();
                } catch (Exception ex) {
                    emitter.onError(ex);
                }
            }
        });


        // creating observer which will listen to data events
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Subscribed");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("On Next: " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        };


        // Observable will emit data and will be sent to the subscribed observers
        source.subscribe(observer);
    }
}
