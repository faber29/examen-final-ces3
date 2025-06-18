package com.example.examen.repository;

import com.example.examen.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    // 1. Buscar por materia
    @Query("SELECT t FROM Teacher t WHERE t.subject = ?1")
    List<Teacher> findBySubject(String subject);

    // 2. Buscar profesores con salario mayor a un valor
    @Query("SELECT t FROM Teacher t WHERE t.salary > ?1")
    List<Teacher> findBySalaryGreaterThan(Double salary);

    // 3. Buscar por nombre que contenga una cadena (LIKE)
    @Query("SELECT t FROM Teacher t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Teacher> findByNameContaining(String namePart);
}
