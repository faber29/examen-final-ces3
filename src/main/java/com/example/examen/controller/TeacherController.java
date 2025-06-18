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
    public Map<String, Object> crear(@RequestBody Teacher teacher) {
        Map<String, Object> response = new HashMap<>();
        try {
            Teacher saved = teacherRepository.save(teacher);
            response.put("mensaje", "Profesor creado exitosamente");
            response.put("profesor", saved);

            // Imprimir en consola
            System.out.println(" Profesor creado: " + saved);
        } catch (Exception e) {
            response.put("error", "No se pudo crear el profesor: " + e.getMessage());

            // Imprimir error en consola
            System.out.println(" Error al crear profesor: " + e.getMessage());
        }
        return response;
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
        Map<String, Object> response = new HashMap<>();
        try {
            Teacher teacher = teacherRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Profesor no encontrado con ID: " + id));

            response.put("nombre", teacher.getName() + " " + teacher.getLastName());
            response.put("salarioAnual", teacher.calcularSalarioAnual());
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        return response;
    }

}
