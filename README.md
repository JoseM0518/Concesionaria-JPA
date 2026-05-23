# 🚗 Concesionaria - Sistema Gestión Automóviles

Sistema completo CRUD autos con JPA 3.0 + EclipseLink + MySQL.

## ✨ Características

### ✅ Implementado
* **Arquitectura MVC:** GUI → Lógica → Persistencia.
* **Modelo Relacional:** Relación `@ManyToOne` estructurada entre las entidades `Automovil` y `Marca` mediante llaves foráneas automáticas.
* **Control de Duplicados Inteligente:** Filtro avanzado en la lógica intermedia mediante `.trim()` y `.equalsIgnoreCase()` que verifica si la marca ya existe en la base de datos antes de crearla, garantizando la consistencia y limpieza de los datos.
* **JPA 3.0:** implementación basada en Jakarta Persistence.
* **EclipseLink 4.0:** como proveedor de persistencia JPA.
* **Connection Pool:** 20/4 conexiones máximas y mínimas configuradas en la default pool.
* **JPA Cache:** Se implementa cache de segundo nivel (`shared=true`) para mejorar el rendimiento en lecturas repetidas desde la interfaz gráfica.
* **Aviso de Credenciales:** Las credenciales expuestas son de un entorno de desarrollo local (root/root).
* **Interfaz gráfica:** desarrollada en Java Swing con validación de datos y cuadros de diálogo interactivos.
* **Manejo de excepciones:** mediante bloques try-catch y logging SQL detallado.

---

## 🏗️ Arquitectura

Principal ──> [Registro | Consulta | Modificar] ──> Controladora (Lógica) ──> ControladoraPersistencia ──> JPA ──> MySQL

## 📦 Tecnologías

### Backend
- Java 17+ (Amazon Corretto)
- JPA 3.0
- EclipseLink 4.0
- MySQL 8.0

### Frontend
- Java Swing

### Configuración
- Connection Pool: 20 max / 4 min / 1 inicial
- Caché de segundo nivel
- `persistence.xml`

---

## 🚀 Instalación

### Requisitos
- Java 17+
- MySQL 8.0 (root/root)
- MySQL Connector 9.6.0
- EclipseLink 4.0.8

### 1. Base de datos

```sql
CREATE DATABASE automovil;
```

### 2. Ejecutar

```bash
java com.concesionaria.Main
```

## 📱 Demo
Principal → Registro → Agregar auto: Formulario que analiza el texto ingresado, remueve espacios y asocia el auto a la marca correcta (existente o nueva).

Principal → Consulta → Listar/Eliminar/Modificar: Tabla dinámica en Swing conectada de forma relacional para realizar mantenimiento completo al stock.

X → Auto-cierre: Invocación explícita a EMF.close() para liberar los recursos al cerrar la aplicación.

## 🛠️ Estructura

```plaintext
src/
└── com.concesionaria/
    ├── igu/           # GUI (Swing)
    ├── logica/        # Entidades y lógica de negocio
    ├── persistencia/  # JPA Controllers
    └── Main.java
```
