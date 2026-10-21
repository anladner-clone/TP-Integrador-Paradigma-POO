class GestorRefugio {
    private val listaAnimales = mutableListOf<Animal>()

    fun agregarAnimal(animal: Animal) {
        listaAnimales.add(animal)
    }

    fun buscarPorFicha(ficha: String): Animal? {
        return listaAnimales.find { it.numeroFicha == ficha }
    }

    // Nueva función para gestionar el proceso de adopción
    fun procesarAdopcion(ficha: String, adoptante: Adoptante) {
        val animal = buscarPorFicha(ficha)
        if (animal != null) {
            if (animal.estado == "Listo para adopción") {
                animal.asignarAdoptante(adoptante)
                println("¡Éxito! ${animal.nombre} ha sido adoptado por ${adoptante.nombreCompleto}.")
            } else {
                println("El animal ${animal.nombre} no está listo para adopción. Estado actual: ${animal.estado}")
            }
        } else {
            println("No se encontró la ficha $ficha.")
        }
    }

    fun mostrarListosParaAdopcion() {
        println("--- ANIMALES LISTOS PARA ADOPCIÓN ---")
        val filtrados = listaAnimales.filter { it.estado == "Listo para adopción" }
        filtrados.forEach { println(it) }
    }
}