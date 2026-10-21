# Sistema Integral de Gestión para Refugio de Animales

Este proyecto es una aplicación de consola desarrollada en **Kotlin** que permite gestionar de manera eficiente la
información de un refugio de rescate de animales. El sistema digitaliza el control de ingresos, el historial médico de
cada mascota y el proceso de adopción, reemplazando los registros manuales en papel.

## Descripción del Proyecto

El objetivo principal es brindar a los voluntarios del refugio una herramienta rápida para:

- Saber qué animales están disponibles para buscar una familia.
- Llevar un registro de los tratamientos veterinarios.
- Administrar los datos de las familias adoptantes.
- Evitar que un animal que se encuentra "En tratamiento" sea dado en adopción por error.

## Estructura de Clases (Modelo de Datos)

El sistema está diseñado utilizando Programación Orientada a Objetos (POO) y se compone de cuatro clases principales:

1. **`Adoptante`**: Representa a la persona o familia que adopta. Contiene datos de contacto (DNI, Nombre Completo y
   Teléfono).
2. **`AtencionMedica`**: Representa el registro de una visita al veterinario (Fecha, Descripción y Veterinario a cargo).
3. **`Animal`**: Es la entidad central. Almacena los datos básicos (Ficha, Nombre, Especie, Edad, Estado) y se relaciona
   con las otras clases, conteniendo una lista de sus atenciones médicas y un posible `Adoptante` asignado.
4. **`GestorRefugio`**: Es el administrador del sistema. Contiene la colección principal de animales y expone las
   funciones para operar sobre ellos.

## Funcionalidades Principales

El `GestorRefugio` permite realizar las siguientes acciones:

- **Alta de Animales:** Registro de nuevas mascotas rescatadas.
- **Historial Clínico:** Registro de nuevas atenciones médicas asociadas a un animal específico.
- **Proceso de Adopción:** Asignación de un `Adoptante` a un `Animal`. Incluye validación de reglas de negocio (solo se
  pueden adoptar animales con estado *"Listo para adopción"*).
- **Búsqueda Detallada:** Consulta de la ficha completa de un animal por su código identificador, incluyendo su
  historial médico y datos de adopción.
- **Filtro de Adopciones:** Generación de un reporte automático con los animales que están esperando una familia.
- **Listado General:** Visualización del inventario completo del refugio.

## Conceptos de POO Aplicados

- **Encapsulamiento:** Los atributos sensibles y las listas internas están declarados como `private` o `private set`
  para evitar modificaciones externas no controladas.
- **Composición:** El `GestorRefugio` contiene y administra la lista principal de objetos `Animal`.
- **Agregación:** Un `Animal` posee un historial compuesto por múltiples objetos `AtencionMedica`.
- **Asociación:** Un `Animal` puede estar vinculado a un objeto `Adoptante` de manera opcional (representado mediante
  *null safety* en Kotlin con `Adoptante?`).

## Datos de Prueba

El sistema incluye un set de datos de prueba precargados en la función `main()` para demostrar su funcionamiento:

- 5 animales con diferentes especies y edades.
- Ejemplos de animales "Listos para adopción" y "En tratamiento".
- Pruebas de validación: Intento de adopción exitosa y rechazo de adopción por estado clínico.
- Carga de historiales médicos.

## Ejecución

Para ejecutar el programa:

1. Clonar este repositorio o descargar el archivo `.kt`.
2. Abrir el proyecto en un entorno de desarrollo compatible con Kotlin (como IntelliJ IDEA o tu IDE configurado).
3. Ejecutar la función `main()`. Los resultados de las pruebas y listados se imprimirán en la consola estándar.

---
*Proyecto desarrollado para la materia de Programación Orientada a Objetos.*