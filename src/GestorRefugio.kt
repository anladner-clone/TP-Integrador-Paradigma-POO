class GestorRefugio {
    private val listaAnimales = arrayListOf<Animal>()
    private val listaAdoptantes = arrayListOf<Adoptante>()

    fun agregarAnimal(animal: Animal) {
        listaAnimales.add(animal)
    }

    fun registrarAdoptante(adoptante: Adoptante) {
        listaAdoptantes.add(adoptante)
    }

    fun buscarPorFicha(ficha: String): Animal? {
        return listaAnimales.find { it.numeroFicha == ficha }
    }

    fun actualizarEstadoAnimal(ficha: String, nuevoEstado: String) {
        val animal = buscarPorFicha(ficha)
        if (animal != null) {
            animal.cambiarEstado(nuevoEstado)
            println("El estado de ${animal.nombre} ha sido actualizado a: $nuevoEstado.")
        } else {
            println("No se encontró la ficha $ficha.")
        }
    }

    fun procesarAdopcion(ficha: String, adoptante: Adoptante) {
        val animal = buscarPorFicha(ficha)
        if (animal != null) {
            if (animal.estado == "Listo") {
                animal.asignarAdoptante(adoptante)
                if (!listaAdoptantes.contains(adoptante)) registrarAdoptante(adoptante)
                println("¡Éxito! ${animal.nombre} ha sido adoptado por ${adoptante.nombreCompleto}.")
            } else {
                println("El animal ${animal.nombre} no está listo para adopción. Estado actual: ${animal.estado}")
            }
        } else {
            println("No se encontró la ficha $ficha.")
        }
    }

    fun mostrarPorEstado(estado: String) {
        println("\n--- ANIMALES EN ESTADO: ${estado.uppercase()} ---")
        val filtrados = listaAnimales.filter { it.estado.equals(estado, ignoreCase = true) }
        if (filtrados.isEmpty()) {
            println("No hay animales en este estado.")
        } else {
            filtrados.forEach { println(it) }
        }
    }
}