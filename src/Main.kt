/*

Enunciado:
Un refugio de rescate de animales necesita un sistema para gestionar no solo el ingreso de las mascotas, sino también su seguimiento médico y el proceso de adopción. Actualmente, la información clínica de los animales y los datos de las familias adoptantes se pierden entre distintos cuadernos de papel. Se requiere un programa que permita registrar a cada animal, documentar sus visitas al veterinario, gestionar la asignación de familias adoptantes y generar listados automáticos para saber qué animales ya están en condiciones de irse a un nuevo hogar.

*/

fun main() {
    val animal1 = Animal("213", "Rodolfo", "Delmo", 12, "Listo")
    val animal2 = Animal("123", "Angel", "Delmo", 12, "Listo")
    val adoptante = Adoptante("12345678","Ariel Ladner", "+543564999999")
    val atencionMedica = AtencionMedica("12/04", "Nada", "Nicolas")

    val gestorRefugio = GestorRefugio()

    gestorRefugio.agregarAnimal(animal1)
    gestorRefugio.agregarAnimal(animal2)
    gestorRefugio.mostrarListosParaAdopcion()
}