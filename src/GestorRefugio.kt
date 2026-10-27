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
        for (animal in listaAnimales) {
            if (animal.numeroFicha == ficha) {
                return animal
            }
        }
        return null
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

                var yaExiste = false
                for (a in listaAdoptantes) {
                    if (a == adoptante) {
                        yaExiste = true
                        break
                    }
                }
                if (!yaExiste) {
                    registrarAdoptante(adoptante)
                }

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
        val filtrados = arrayListOf<Animal>()
        for (animal in listaAnimales) {
            if (animal.estado.lowercase() == estado.lowercase()) {
                filtrados.add(animal)
            }
        }

        if (filtrados.size == 0) {
            println("No hay animales en este estado.")
        } else {
            for (animalFiltrado in filtrados) {
                println(animalFiltrado)
            }
        }
    }
}