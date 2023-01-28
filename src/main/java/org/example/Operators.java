package org.example;

import io.reactivex.rxjava3.core.Observable;
import org.example.dto.Employee;

import java.util.List;

/**
 * Types of operators
 * -    Suppressing operators
 *      -   suppresses the emissions which fails to meet some specific criteria.
 *      -   eg: filter, take, skip, distinct, elementAt
 *
 * -    Transforming operators
 *      -   transforms the emissions. Type of returned observable may not be the same.
 *      -   eg: map, cast, delay, delaySubscription, scan, sorted, repeat
 *
 * -    Reducing operators
 *      -   Take series of emissions and reduce them into single emission.
 *      -   Works with finite observables.
 *      -   eg: count, reduce, contains
 *
 * -    Collection operators
 *      -   combine all the emissions from upstream to some collection.
 *      -   reduce emissions to a single collection.
 *      -   eg: toList, toSortedList, toMap, collect
 *
 * -    Error-recovery operators
 *      -   Used to handle errors and to recover from them.
 *      -   eg: onErrorReturnItem, onErrorReturn, onErrorResumeNext, retry,
 *
 * -    Action operators
 *      -   used to debugging in the observable chains
 *      -   eg: doOnNext, doOnError, doOnSubscribe, doOnComplete.
 */
public class Operators {
    public static void main(String[] args) {
//        sampleOperators();
//        sampleOperators2();
        sampleOperators3();
    }

    private static void sampleOperators() {
        Observable.just(1, 2, 3, 4, 5)
                .filter(x -> x % 2 == 0)
                .sorted()
                .subscribe(e -> System.out.println("Even number : " + e));
    }

    private static void sampleOperators3() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Observable.fromIterable(integers)
                .reduce(Integer::sum)
                .subscribe(System.out::println);

    }

    private static void sampleOperators2() {
        Observable<Employee> obs = Observable.just(
                new Employee(101, "Alexa", 6000, 4.4),
                new Employee(102, "Jim", 7000, 4.4),
                new Employee(103, "Bob", 8000, 3.8),
                new Employee(104, "jason", 9000, 4.5),
                new Employee(105, "ellen", 7500, 4.3),
                new Employee(106, "christian", 6000, 4.1)
        );

        /*
            Get the name of top 4 rated employees
         */
        obs.filter(e -> e.getRating() > 4.0)
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .map(Employee::getName)
                .take(4)
//                .toList()
                .subscribe(System.out::println);
    }
}
