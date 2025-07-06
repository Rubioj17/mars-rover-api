# 🚀 Mars Rover API

API REST en Java con Spring Boot siguiendo principios SOLID, que simula el movimiento de un rover en la superficie de Marte. 
El sistema posiciona un rover en un mapa, permite registrar obstáculos, y enviarle comandos para desplazarse o rotar.

---

## 🛠️ Tecnologías

- Java 21
- Spring Boot 3.5.0
- Maven 3.9.9
- JUnit 5 / Mockito
- Lombok
- MySQL
- Validaciones personalizadas con anotaciones

---

## 📁 Estructura del proyecto
El proyecto está organizado utilizando una **estructura por características (feature-based structure)**.  
Cada módulo principal del sistema como `rover` y `obstacle` contiene internamente sus propias capas (controladores, servicios, modelos, DTOs, validaciones, etc.), lo cual facilita la escalabilidad y el mantenimiento.

Esta estructura permite:
-   Separar claramente las responsabilidades por dominio.
-   Mejorar la legibilidad del código.
-   Aplicar principios como **Single Responsibility**.
-   Evolucionar fácilmente hacia una **arquitectura limpia** o basada en **Domain-Driven Design (DDD)**.
```
obstacle/
├── controllers/
├── dto/
├── mappers/ 
├── models/
├── repositories/ 
├── services/
└── validations/

rover/
├── controllers/
├── dto/
│   ├── request/
│   └── response/
├── initializer/   
├── mappers/
├── models/
├── repositories/
├── services/
│      └── components/
│          ├── commands/
│          ├── executor/
│          ├── movement/
│          └── rotation/
├── utilities/
└── validations/

shared/
├── exceptions/
└── utilities/
```
---
## ⚙️ Instalación

1. Clona el repositorio:
```bash
git clone https://github.com/Rubioj17/mars-rover-api.git
```
2. Ingresa al proyecto:
```bash
cd mars-rover-api
```
3. Ejecuta la app (con Maven Wrapper):
```bash
#En Linux
./mvnw spring-boot:run
#En Windows
./mvnw.cmd spring-boot:run
```
> ⚠️ Para evitar errores con Lombok al compilar o abrir el proyecto:
> - Si usas IntelliJ IDEA, asegúrate de tener el plugin Lombok instalado y habilitado.
> - Activa la opción `Enable annotation processing` en:  
  `File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors`.
> - Tambien fijarse en el `application.properties` para la configuracion de la Base de Datos.

---
## 🧪 Pruebas

Para correr los tests unitarios:
```bash
./mvnw test
```
---
## 📌 Principales Endpoints
 
-   `POST /rover/command` – Envía una secuencia de comandos (`L`, `R`, `M`) al rover
    
-   `GET /rover` – Devuelve la posición y dirección actual del rover
    
-   `GET /obstacle` – Retorna la posición del los obstáculos

-   `POST /obstacle/create` – Envía la posición donde se va a crear un obstáculo

-   `DELETE /obstacle/delete` – Hace un borrado de todos los obstáculos
---

## 🧪 Ejemplos de uso
A continuación se muestran ejemplos de cómo utilizar la API con peticiones en Postman.
### 📍 Obtener estado actual del Rover

**GET** `/rover`
```json
{
    "posX": 1,
    "posY": 0,
    "direction": "NORTH"
}
```
### 📡 Enviar comandos al Rover

**POST** `/rover/command`
```json
{
	"commandList":["R", "M", "M", "R", "M", "L", "M"]
}
```
### 🧱 Crear un obstáculo

**POST** `/obstacle/create`
```json
{
	"posX":1,
	"posY":3
}
```
### 📜 Listar obstáculos

**GET** `/obstacle`
```json
[
    {
        "posX": 2,
        "posY": 2
    },
    {
        "posX": 1,
        "posY": 3
    }
]
```
### ❌ Eliminar todos los obstáculos

**DELETE** `/obstacle/delete`
```json
	"Deleted Successfully"
```

---
## 📋 Validaciones

-   No se permite colocar obstáculos fuera del mapa ni en una posición ya ocupada.
    
-   El rover no puede avanzar si hay un obstáculo en la posición siguiente.

-   El rover ignora comandos inválidos.
    
-   El rover no puede salirse del mapa.
    
-   Se usan validaciones personalizadas en los DTOs.
---

## 🧠 Notas de implementación

-   Se usa una estructura de **estrategia** para mover el rover según su dirección.
    
-   Los comandos del rover (`L`, `R`, `M`) se resuelven mediante el patrón **Command**.
---

## 🙋 Autor

-   Jesús Rubio
    
-   Proyecto desarrollado como parte del bootcamp ATL Academy
---

## 📄 Licencia

Este proyecto está bajo la licencia MIT.
