class Animal(
    val numeroFicha: String,
    val nombre: String,
    val especie: String,
    val edadMeses: Int,
    var estado: String // var porque el estado puede cambiar (ej: de "Listo" a "Adoptado")
) {
    // Lista interna para el historial médico
    private val historialMedico = mutableListOf<AtencionMedica>()

    // Puede tener un adoptante o ser null (?) si sigue en el refugio
    var adoptante: Adoptante? = null
        private set // Solo se puede modificar desde las funciones de esta clase

    fun registrarAtencion(atencion: AtencionMedica) {
        historialMedico.add(atencion)
    }

    fun asignarAdoptante(nuevoAdoptante: Adoptante) {
        this.adoptante = nuevoAdoptante
        this.estado = "Adoptado"
    }

    override fun toString(): String {
        var texto = "Ficha: $numeroFicha | $nombre ($especie) | Estado: $estado"
        if (adoptante != null) {
            texto += "\n   -> Adoptado por: ${adoptante.toString()}"
        }
        return texto
    }
}