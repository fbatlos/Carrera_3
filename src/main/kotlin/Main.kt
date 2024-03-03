
import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * Extiende la clase [Float] para permitir el redondeo del número a un número específico de posiciones decimales.
 *
 * @param posiciones El número de posiciones decimales a las que se redondeará el valor.
 * @return Un [Float] redondeado al número de posiciones decimales especificadas.
 */
fun Float.redondear(posiciones: Int): Float {
    val factor = 10.0.pow(posiciones.toDouble()).toFloat()
    return (this * factor).roundToInt() / factor
}

/**
 * Punto de entrada del programa. Crea una lista de vehículos y una carrera, e inicia la carrera mostrando
 * los resultados al finalizar.
 */
fun main() {
    try {
        val carrera = Carrera("Gran Carrera de Filigranas", 1000f)

        println("\n*** ${carrera.nombreCarrera} ***\n")
        carrera.iniciarCarrera()

        val resultados = carrera.obtenerResultados()

        println("* Clasificación:\n")
        resultados.forEach { println("${it.posicion} -> ${it.vehiculo.nombre} (${it.vehiculo.kilometrosActuales} kms)") }

        println("\n" + resultados.joinToString("\n") { it.toString() })

        println("\n* Historial Detallado:\n")
        resultados.forEach { println("${it.posicion} -> ${it.vehiculo.nombre}\n${it.historialAcciones.joinToString("\n")}\n") }

    }catch (_:NumberFormatException){
        println("**ERROR** Numero no valido.")
    }
    catch (_:IllegalStateException){
        println("**ERROR** Nombre en blanco.")
    }
    catch (_:IllegalArgumentException){
        println("**ERROR** Datos invalidos introducidos.")
    }
}


fun String.normalizar(): String {
    val frase = this
    val fraseSinEspacio = frase.trim()
    val cadaPalabra = fraseSinEspacio.split(" ").filter { it.isNotEmpty() }
    val palabrasCapitalizadas = cadaPalabra.map { it.replaceFirstChar { it.uppercase() } }
    return palabrasCapitalizadas.joinToString(" ")
}
