# Examen de Código Java

Este repositorio contiene los ejercicios de la Kata para la aplicación de la vacante en **Investigación y Desarrollo**, para el puesto de *Ing. de Software Jr.*

Adicional, se propuso una API REST para exponer y consumir los ejercicios básicos de lógica desarrollados en Java, usando Spring Boot. Esto permite acceder a las funcionalidades mediante peticiones HTTP.

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


# Documentación de Endpoints

## POST `/api/vocales/contar`
Cuenta las vocales de un texto.

### Request:
```json
{
  "texto": "Hola mundo"
}
```

### Response:
```json
{
  "mensaje": "La cadena 'Hola mundo' tiene 4 vocales."
}
```

#### Ejemplo
```bash
curl --location 'http://localhost:8080/api/vocales/contar' \
--header 'Content-Type: application/json' \
--data '{"texto": "Hola Mundo"}'
```

## POST `/api/numeros/mayor`
Devuelve el número mayor de un arreglo.

### Request:
```json
{
  "numeros": [10, 5, 20, 8]
}
```

### Response:
```json
{
  "mensaje": "El número mayor del arreglo [10, 5, 20, 8] es: 20"
}
```

#### Ejemplo
```bash
curl --location 'http://localhost:8080/api/numeros/mayor' \
--header 'Content-Type: application/json' \
--data '{"numeros": [10, 5, 20, 8]}'
```


## POST `/api/numeros/pares`
Devuelve la lista de números pares de la lista enviada.


```json
{
  "numeros": [1, 2, 3, 4, 5]
}
```

### Response:
```json
{
  "mensaje": "Los números pares encontrados son: [2, 4]"
}
```

#### Ejemplo
```bash
curl --location 'http://localhost:8080/api/numeros/pares' \
--header 'Content-Type: application/json' \
--data '{"numeros": [1, 2, 3, 4, 5]}'
```


## Cómo ejecutar el proyecto

1. Clona el repositorio:
    ```bash
    git clone https://github.com/josuegonzalezh/testID.git
    cd testID
    ```

2. Ejecuta la aplicación:
    ```bash
    ./mvnw spring-boot:run
    ```

    > Al ejecutar `./mvnw spring-boot:run` por primera vez, Maven descargará todas las dependencias necesarias. Esto puede tardar algunos minutos dependiendo de la conexión a internet. Este paso solo se realiza una vez.



## Autor

**Josué González Hernández.**  
*Ing. de Mesa de Servicio 1er Nivel*
