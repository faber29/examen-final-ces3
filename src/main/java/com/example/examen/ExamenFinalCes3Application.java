package com.example.examen;

import com.example.examen.model.Teacher;
import com.example.examen.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamenFinalCes3Application {

	public static void main(String[] args) {
		SpringApplication.run(ExamenFinalCes3Application.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(TeacherRepository repository) {
		return args -> {
			repository.save(new Teacher("Ana", "Ramírez", "Matemáticas", 3000.0, "ana@correo.com"));
			repository.save(new Teacher("Luis", "Pérez", "Física", 3200.0, "luis@correo.com"));

			repository.findAll().forEach(teacher -> {
				System.out.println(teacher.getName() + " " + teacher.getLastName() +
						" - Salario anual: $" + teacher.calcularSalarioAnual());
			});
			System.out.println("Profesores registrados():");
			repository.findAll().forEach(System.out::println);  // <-- uso toString();

		};
	}
}
