class Animal(
    val numeroFicha: String,
    val nombre: String,
    val especie: String,
    val edadMeses: Int,
    var estado: String // ("Listo", "Adoptado")
) {
    private val historialMedico = mutableListOf<AtencionMedica>()

    var adoptante: Adoptante? = null
        private set

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