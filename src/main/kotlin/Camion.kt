import kotlin.random.Random

class Camion(nombre: String,
             marca: String,
             modelo:String,
             capacidadCombustible: Float,
             kilometrosActuales: Float,
             combustibleActual: Float,
             val esHibrido: Boolean
):Automovil(nombre, marca,modelo, capacidadCombustible, kilometrosActuales, combustibleActual, esHibrido) {
    val Peso = Random.nextInt(1000,10000)
    companion object{
        var KM_POR_LITRO_Camion = 6.25f
    }
    override fun calcularAutonomia() =
        if (esHibrido)
            (combustibleActual * (KM_POR_LITRO_Camion + AHORRO_ELECTRICO)-(Peso/1000)*0.2).toFloat().redondear(2)
        else
            ((combustibleActual * (KM_POR_LITRO_Camion-(Peso/1000)*0.2))).toFloat().redondear(2)
}