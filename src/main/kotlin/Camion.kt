import kotlin.random.Random

class Camion(nombre: String,
):Automovil(nombre, esHibrido = Random.nextBoolean() ,capacidadCombustible = Random.nextInt(90,150).toFloat()) {
    val Peso = Random.nextInt(1000,10000)
    companion object{
        var KM_POR_LITRO_Camion = 6.25f
    }
    override fun calcularAutonomia() =
        if (esHibrido)
            (combustibleActual * (KM_POR_LITRO_Camion + AHORRO_ELECTRICO)-(Peso/1000)*0.2).toFloat().redondear(2)
        else
            ((combustibleActual * (KM_POR_LITRO_Camion-(Peso/1000)*0.2))).toFloat().redondear(2)

    override fun obtenerInformacion(): String {
        return "$nombre Camión(km = ${kilometrosActuales.redondear(2)} , cobustible = ${combustibleActual.redondear(2)})"
    }

    override fun toString(): String {
        return "Camión(nombre=$nombre, marca=$marca, modelo=$modelo, capacidadCombustible=$capacidadCombustible, combustibleActual=$combustibleActual, kilometrosActuales=$kilometrosActuales, Peso=$Peso)"
    }

}