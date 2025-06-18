# Examen Final - Construcción de Elementos de Software 3

Este proyecto corresponde al examen final del curso **Construcción de Elementos de Software 3** del programa **Tecnología en Sistematización de Datos** del **Politécnico Colombiano Jaime Isaza Cadavid**.

## Profesor
Oscar Mesa  
📅 Fecha de entrega: 18-06-2025  
📂 Rama: `examen-final`

---

##  Objetivo del Proyecto

Desarrollar una aplicación Spring Boot que permita gestionar profesores mediante una API REST. Incluye el uso de Spring Data JPA, validaciones, consultas personalizadas y operaciones básicas de CRUD.

---

## Tecnologías utilizadas

- Java 21
- Spring Boot 3.5.0
- Spring Data JPA
- H2 Database 
- Bean Validation 
- Maven
- Spring Web

---

## Funcionalidades implementadas

### 1.  Entidad `Teacher`
- Atributos: `id`, `name`, `lastName`, `subject`, `salary`, `email`
- Anotaciones: `@Entity`, `@Id`, `@GeneratedValue`, `@NotNull`, `@Email`
- Método `calcularSalarioAnual()`
- Método `toString()` para salida legible en consola

### 2.  Repositorio `TeacherRepository`
- Extiende `JpaRepository<Teacher, Long>`
- Consultas personalizadas con `@Query`:
    - Buscar por materia (`subject`)
    - Buscar por salario mayor a un valor
    - Buscar por nombre parcial

### 3. Controlador REST `TeacherController`
- `POST /api/teachers` – Crear profesor
- `GET /api/teachers` – Listar todos
- `GET /api/teachers/salarios-anuales` – Listar salarios anuales
- `GET /api/teachers/{id}/salario-anual` – Salario anual por ID
- Manejo básico de errores con `try-catch`

### 4. Datos de prueba
- En la clase principal (`CommandLineRunner`)
- Inserta varios profesores y muestra sus salarios anuales en consola
- Uso de métodos personalizados del repositorio

---


##  Ejemplos de uso en Postman

###  1. Crear un profesor

- **Método**: POST
- **URL**: `http://localhost:8080/api/teachers`
- **Body (raw JSON)**:

```json
{
  "name": "Laura",
  "lastName": "Jiménez",
  "subject": "Química",
  "salary": 4100,
  "email": "laura@correo.com"
}
```

---

###  2. Obtener todos los profesores

- **Método**: GET
- **URL**: `http://localhost:8080/api/teachers`

---

###  3. Obtener salarios anuales de todos los profesores

- **Método**: GET
- **URL**: `http://localhost:8080/api/teachers/salarios-anuales`

---

###  4. Obtener salario anual de un profesor por ID

- **Método**: GET
- **URL**: `http://localhost:8080/api/teachers/1/salario-anual`

> Cambia el número al ID del profesor que desees consultar.

---
## Autor
### **John Faber Estrada Rave**
Estudiante de Tecnología en Sistematización de Datos  
 Politécnico Colombiano Jaime Isaza Cadavid
