class Adoptante(
    val dni: String,
    val nombreCompleto: String,
    val telefono: String
) {
    override fun toString(): String {
        return "$nombreCompleto (Tel: $telefono)"
    }
}