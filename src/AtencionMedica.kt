class AtencionMedica(
    val fecha: String,
    val descripcion: String,
    val veterinario: String
) {
    override fun toString(): String {
        return "[$fecha] $descripcion (Vet: $veterinario)"
    }
}