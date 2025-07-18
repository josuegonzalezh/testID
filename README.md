# Examen de Código Java

Este repositorio contiene los ejercicios de la Kata para la aplicación de la vacante en **Investigación y Desarrollo**, para el puesto de *Ing. de Software Jr.*.

Adicional, se implementó una API REST como alternativa para exponer y consumir los ejercicios básicos de lógica desarrollados en Java, usando Spring Boot. Esto permite acceder a las funcionalidades mediante peticiones HTTP.

## Ejercicios Incluidos

- **Contar Vocales**: Devuelve el número de vocales de una cadena dada.
- **Encontrar el Número Mayor**: Devuelve el número más grande dentro de un arreglo.
- **Filtrar Números Pares**: Devuelve todos los números pares dentro de una lista.

## Tecnologías

- Java 17+
- Spring Boot
- Maven
- JUnit 5
- MockMvc para pruebas de integración

## Estructura del Proyecto
```
src/
├── main/
│   ├── java/
│   │   └── com/testoid/apiejercicios/
│   │       ├── controller/                    # Controladores REST
│   │       ├── dto/                           # Clases DTO
│   │       ├── service/                       # Lógica principal (funciones) de los ejercicios
│   │       └── ApiEjerciciosApplication.java
│   └── resources/
│       └── application.properties
├── test/
│   └── java/
│       └── com/testoid/apiejercicios/
│           ├── controller/                    # Pruebas unitarias de endpoints
│           └── service/                       # Pruebas unitarias de las funciones
```

## Autor

**Josué González Hernández.**  
*Ing. de Mesa de Servicio 1er Nivel*
