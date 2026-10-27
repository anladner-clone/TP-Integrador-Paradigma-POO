class Animal(
    val numeroFicha: String,
    val nombre: String,
    val especie: String,
    val edadMeses: Int,
    var estado: String // Ej: "Ingresado", "En tratamiento", "Listo", "Adoptado"
) {
    private val historialMedico = mutableListOf<AtencionMedica>()

    var adoptante: Adoptante? = null
        private set

    fun registrarAtencion(atencion: AtencionMedica) {
        historialMedico.add(atencion)
    }

    fun mostrarHistorialMedico() {
        println("--- Historial Médico de $nombre (Ficha: $numeroFicha) ---")
        if (historialMedico.size == 0) {
            println("No hay atenciones registradas.")
        } else {
            for (historia in historialMedico) {
                println(historia)
            }
        }
    }

    fun cambiarEstado(nuevoEstado: String) {
        this.estado = nuevoEstado
    }

    fun asignarAdoptante(nuevoAdoptante: Adoptante) {
        this.adoptante = nuevoAdoptante
        this.estado = "Adoptado"
    }

    override fun toString(): String {
        var texto = "Ficha: $numeroFicha | $nombre ($especie) | Edad: $edadMeses meses | Estado: $estado"
        if (adoptante != null) {
            texto += "\n   -> Adoptado por: ${adoptante.toString()}"
        }
        return texto
    }
}