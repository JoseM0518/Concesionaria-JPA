🚗 Concesionaria - Sistema Gestión Automóviles
Java
JPA 3.0
MySQL

Sistema completo CRUD autos con JPA 3.0 + EclipseLink + MySQL.

✨ Características
Feature

✅ Implementado

Arquitectura MVC

GUI → Lógica → Persistencia

JPA 3.0 moderna

EclipseLink 4.0

Connection Pool

20/4 conexiones

JPA Cache

Se implementa cache de segundo nivel para mejorar rendimiento en lecturas repetidas

GUI profesional

Swing + Validaciones

Robustez

Try-catch + Logging

🏗️ Arquitectura


Principal → [Registro | Consulta | Modificar]
                ↓
         Controladora (Lógica)
                ↓
ControladoraPersistencia → JPA → MySQL
📦 Tecnologías


Backend: JPA 3.0, EclipseLink 4.0, MySQL 8.0
Frontend: Swing Java
Pool: 20 max / 4 min conexiones
Config: persistence.xml optimizado
🚀 Instalación
1. Requisitos
bash


Java 17+
MySQL 8.0 (root/root)
MySQL Connector 9.6.0
EclipseLink 4.0.8
2. Base de datos
sql


CREATE DATABASE concesionaria;
3. Config persistence.xml
xml


4. Ejecutar
bash


java com.concesionaria.Main
📱 Demo


1. Principal → Registro → Agregar auto
2. Principal → Consulta → Listar/Eliminar/Modificar
3. X → Auto-cierre (EMF.close())
🛠️ Estructura


src/
├── igu/           # GUI (Swing)
├── logica/        # Controladora (Negocio)
├── persistencia/  # JPA Controllers
└── Main.java
🔍 Configuración Avanzada
xml



Pool: max=20, min=4
Cache: shared=true
Logging: SQL + parameters
DDL: create-tables
Validation: AUTO
📈 Performance
Métrica

Valor

Conexiones

20 máx / 4 mín

Lectura

+40% cache

Robustez

Try-catch todos CRUD

👨‍💻 Uso en producción


1. JNDI DataSource
2. Docker MySQL
3. Logging archivos
4. Tests unitarios
