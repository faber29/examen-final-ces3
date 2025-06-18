package com.example.examen.controller;

import com.example.examen.model.Teacher;
import com.example.examen.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping
    public Teacher crear(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @GetMapping
    public List<Teacher> listar() {
        return teacherRepository.findAll();
    }

    @GetMapping("/salarios-anuales")
    public List<Map<String, Object>> salariosAnuales() {
        List<Map<String, Object>> response = new ArrayList<>();
        for (Teacher t : teacherRepository.findAll()) {
            Map<String, Object> item = new HashMap<>();
            item.put("nombre", t.getName() + " " + t.getLastName());
            item.put("salarioAnual", t.calcularSalarioAnual());
            response.add(item);
        }
        return response;
    }

    @GetMapping("/{id}/salario-anual")
    public Map<String, Object> salarioPorId(@PathVariable Long id) {
        Optional<Teacher> t = teacherRepository.findById(id);
        if (t.isPresent()) {
            Map<String, Object> item = new HashMap<>();
            item.put("nombre", t.get().getName() + " " + t.get().getLastName());
            item.put("salarioAnual", t.get().calcularSalarioAnual());
            return item;
        } else {
            throw new RuntimeException("Profesor no encontrado");
        }
    }
}
