# Proyecto Metodo de Pago

**Proyecto solo para uso demostrativo**
**La API está siendo validada mediante pruebas manuales con Postman**

API REST para gestión de métodos de pagos que **reduce errores y riesgos en el manejo de tarjetas mediante 
validaciones de reglas de negocio en el dominio**, arquitectura en capas e integración de API externa para obtener los 
atributos de la tarjeta a través del BIN (bank identification number). **Desarrollado con Java y Spring Boot**. 🪪🪪🪪

---

## Estado del proyecto
🚧 En desarrollo

---

## Funcionalidades
- Crear métodos de pago
- Actualizar métodos de pago
- Eliminar métodos de pago
- Obtener métodos de pago

---

## Tecnologías y herramientas
- Java
- Spring Boot
- API REST
- Arquitectura en capas
- API externa (BinList)
- Postman

---

## Mejoras por realizar (Roadmap)
- Manejo explícito de errores y códigos HTTP.
- Gestión del error HTTP 429 (Too Many Requests) cuando la API externa alcanza su límite de solicitudes.
- Tokenización del número de tarjeta o integración con un gateway de pagos que devuelva un token.
- Aplicación de principios del estándar PCI DSS para el manejo del CVC.
- Implementación de persistencia con base de datos.
- Versionado de la API.
- Desarrollo de un frontend simple para mejorar la interacción cliente–servidor.

---

## Créditos
- **Autor:** Anthony Viveros  
- **GitHub:** https://github.com/ToniniTech  
- **Herramientas utilizadas:** Java, Spring Boot, BinList API, Postman
