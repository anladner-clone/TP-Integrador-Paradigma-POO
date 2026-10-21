class GestorRefugio {
    private val listaAnimales = arrayListOf<Animal>()

    fun agregarAnimal(animal: Animal) {
        listaAnimales.add(animal)
    }

    fun buscarPorFicha(ficha: String): Animal? {
        for (animal in listaAnimales) {
            if (animal.numeroFicha == ficha) return animal
        }
        return null
    }

    fun procesarAdopcion(ficha: String, adoptante: Adoptante) {
        val animal = buscarPorFicha(ficha)
        if (animal != null) {
            if (animal.estado == "Listo") {
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
        val filtrados = arrayListOf<Animal>()
        for (animal in listaAnimales) {
            if (animal.estado == "Listo") filtrados.add(animal)
        }
        for (animal in filtrados) {
            println(animal)
        }
    }
}