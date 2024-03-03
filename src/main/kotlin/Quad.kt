import kotlin.random.Random

class Quad(
    nombre: String,
    val TipoQuad: String = listOf("Cuadriciclos ligeros", "Cuadriciclos no ligeros" , "Vehículos especiales")[Random.nextInt(0,3)]
):Motocicleta(nombre ,capacidadCombustible =  Random.nextInt(20, 40).toFloat()) {
    override fun calcularAutonomia(): Float {
        return (super.calcularAutonomia()/2)
    }


    override fun toString(): String {
        return "Motocicleta(nombre=$nombre, marca=$marca, modelo=$modelo, capacidadCombustible=$capacidadCombustible, combustibleActual=$combustibleActual, kilometrosActuales=$kilometrosActuales, cilindrada=$cilindrada , Tipo = $TipoQuad)"
    }

}