fun main() {
    val gestorRefugio = GestorRefugio()

    val animal1 = Animal("213", "Rodolfo", "Perro", 12, "En tratamiento")
    val animal2 = Animal("123", "Angel", "Gato", 8, "Ingresado")

    gestorRefugio.agregarAnimal(animal1)
    gestorRefugio.agregarAnimal(animal2)

    val atencion1 = AtencionMedica("27/10", "Vacunación antirrábica y desparasitación", "Dr. Nicolás")
    animal1.registrarAtencion(atencion1)

    val atencion2 = AtencionMedica("28/10", "Control general. Alta médica.", "Dr. Nicolás")
    animal1.registrarAtencion(atencion2)

    println("\nConsultando historiales médicos:")
    animal1.mostrarHistorialMedico()
    animal2.mostrarHistorialMedico()

    gestorRefugio.actualizarEstadoAnimal("213", "Listo")
    gestorRefugio.actualizarEstadoAnimal("123", "Listo")

    val familiaAdoptante = Adoptante("12345678", "Ariel Ladner", "+543564999999")
    println("\nProcesando adopciones:")
    gestorRefugio.procesarAdopcion("213", familiaAdoptante)

    gestorRefugio.mostrarPorEstado("Listo")
    gestorRefugio.mostrarPorEstado("Adoptado")
}