package org.example.dto;

public class Employee {
    private Integer id;
    private String name;
    private double salary;

    private double rating;

    public Employee(Integer id, String name, double salary, double rating) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public Employee setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public Employee setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public Employee setRating(double rating) {
        this.rating = rating;
        return this;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", rating=" + rating +
                '}';
    }
}
