package org.example;

import io.reactivex.rxjava3.core.Observable;
import org.example.dto.Employee;

public class Grouping {
    public static void main(String[] args) {
        Observable<Employee> obs = Observable.just(
                new Employee(101, "Alexa", 60000, 4.0),
                new Employee(123, "Tom", 65000, 5.0),
                new Employee(145, "Jenny", 70000, 4.0),
                new Employee(156, "Brad", 75000, 5.1),
                new Employee(167, "Bob", 92000, 5.1)
        );

         obs.groupBy(Employee::getRating)
                .flatMapSingle(e -> e.toMultimap(Employee::getRating, Employee::getName))
                .subscribe(System.out::println);


        obs.groupBy(Employee::getRating)
                .flatMapSingle(Observable::toList)
                .subscribe(System.out::println);
    }
}
