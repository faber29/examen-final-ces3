package com.example.examen.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String subject;

    @NotNull
    private Double salary;

    @Email
    @Column(unique = true)
    private String email;

    public Teacher() {}

    public Teacher(String name, String lastName, String subject, Double salary, String email) {
        this.name = name;
        this.lastName = lastName;
        this.subject = subject;
        this.salary = salary;
        this.email = email;
    }

    public Double calcularSalarioAnual() {
        return this.salary * 12;
    }

    // Getters, Setters y toString()
    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getSubject() { return subject; }

    public void setSubject(String subject) { this.subject = subject; }

    public Double getSalary() { return salary; }

    public void setSalary(Double salary) { this.salary = salary; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return name + " " + lastName + " enseña " + subject + " con salario mensual $" + salary;
    }
}
