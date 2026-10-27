# Sistema Integral de Gestión para Refugio de Animales

Este proyecto es una aplicación de consola desarrollada en **Kotlin** que permite gestionar de manera eficiente la información de un refugio de rescate de animales. El sistema digitaliza el control de ingresos, el historial médico de cada mascota y el proceso de adopción, reemplazando los registros manuales en papel.

## Descripción del Proyecto

El objetivo principal es brindar a los voluntarios del refugio una herramienta rápida para:

- Saber qué animales están disponibles para buscar una familia.
- Llevar un registro de los tratamientos veterinarios.
- Administrar los datos de las familias adoptantes.
- Evitar que un animal que se encuentra "En tratamiento" sea dado en adopción por error.

## Estructura de Clases (Modelo de Datos)

El sistema está diseñado utilizando Programación Orientada a Objetos (POO) y se compone de cuatro clases principales:

1. **`Adoptante`**: Representa a la persona o familia que adopta. Contiene datos de contacto (DNI, Nombre Completo y Teléfono).
2. **`AtencionMedica`**: Representa el registro de una visita al veterinario (Fecha, Descripción y Veterinario a cargo).
3. **`Animal`**: Es la entidad central. Almacena los datos básicos (Ficha, Nombre, Especie, Edad, Estado) y se relaciona con las otras clases, conteniendo una lista de sus atenciones médicas y un posible `Adoptante` asignado.
4. **`GestorRefugio`**: Es el administrador del sistema. Contiene las colecciones principales de animales y adoptantes, y expone las funciones para operar sobre ellos de manera global.

## Funcionalidades Principales

El sistema actualizado permite realizar las siguientes acciones:

- **Alta de Animales:** Registro de nuevas mascotas rescatadas con estados iniciales (ej. "Ingresado", "En tratamiento").
- **Gestión Clínica:** Registro de nuevas atenciones médicas y consulta detallada del historial médico asociado a un animal específico.
- **Actualización de Estados:** Capacidad de modificar manualmente el estado clínico o de adopción de un animal (ej. pasarlo de "En tratamiento" a "Listo").
- **Proceso de Adopción:** Asignación de un `Adoptante` a un `Animal`. Incluye validación de reglas de negocio (solo se pueden adoptar animales con estado *"Listo"*) y registro global del adoptante en el sistema.
- **Búsqueda Detallada:** Consulta de la ficha de un animal por su código identificador.
- **Listados Dinámicos por Estado:** Generación de reportes automáticos filtrando a los animales según su estado actual (ej. listado de "Listos", "Adoptados", "En tratamiento").

## Conceptos de POO Aplicados

- **Encapsulamiento:** Los atributos sensibles y las listas internas están declarados como `private` o `private set` para evitar modificaciones externas no controladas.
- **Composición:** El `GestorRefugio` contiene y administra la lista principal de objetos `Animal`.
- **Agregación:** Un `Animal` posee un historial compuesto por múltiples objetos `AtencionMedica`.
- **Asociación:** Un `Animal` puede estar vinculado a un objeto `Adoptante` de manera opcional (representado mediante *null safety* en Kotlin con `Adoptante?`).

## Datos de Prueba

El sistema incluye un set de datos de prueba precargados en la función `main()` para demostrar su funcionamiento en tiempo real:

- Ingreso de animales con estados clínicos iniciales ("En tratamiento", "Ingresado").
- Carga y consulta por consola de múltiples registros en el historial médico de un animal.
- Actualización manual de estado habilitando a los animales para adopción.
- Pruebas de adopción exitosa vinculando una familia adoptante.
- Impresión de listados dinámicos agrupados por su estado final ("Listo", "Adoptado").

## Ejecución

Para ejecutar el programa:

1. Clonar este repositorio o descargar los archivos `.kt`.
2. Abrir el proyecto en un entorno de desarrollo compatible con Kotlin (como IntelliJ IDEA o tu IDE configurado).
3. Ejecutar la función `main()`. Los resultados de las pruebas, historiales y listados se imprimirán en la consola estándar.

---
*Proyecto desarrollado para la materia de Programación Orientada a Objetos.*