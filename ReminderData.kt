package com.example.recordatorioscontextuales

import androidx.compose.ui.graphics.Color
import java.time.LocalDateTime

object ReminderData {

    // LIST: conserva los recordatorios de prueba en un orden definido
    val recordatorios: List<Recordatorio> = listOf(
        Recordatorio(
            id = 1,
            titulo = "Entregar informe",
            descripcion = "Finalizar y enviar el informe semanal",
            categoria = Categoria.Trabajo,
            prioridad = Prioridad.Alta,
            estado = EstadoRecordatorio.Pendiente,
            fechaVencimiento = LocalDateTime.now().plusDays(1),
            sincronizado = false
        ),
        Recordatorio(
            id = 2,
            titulo = "Ir al gimnasio",
            descripcion = "Realizar la rutina de entrenamiento",
            categoria = Categoria.Personal,
            prioridad = Prioridad.Media,
            estado = EstadoRecordatorio.EnCurso
        ),
        Recordatorio(
            id = 3,
            titulo = "Solicitar turno médico",
            descripcion = "Consultar disponibilidad de turnos",
            categoria = Categoria.Salud,
            prioridad = Prioridad.Alta,
            estado = EstadoRecordatorio.Pendiente,
            ubicacion = Ubicacion(
                latitud = -34.6037,
                longitud = -58.3816,
                descripcion = "Centro médico"
            ),
            aviso = LocalDateTime.now().plusDays(2)
        ),
        Recordatorio(
            id = 4,
            titulo = "Estudiar Kotlin",
            descripcion = "Repasar data classes y colecciones",
            categoria = Categoria.Estudio,
            prioridad = Prioridad.Baja,
            estado = EstadoRecordatorio.Completado,
            sincronizado = true
        ),
        Recordatorio(
            id = 5,
            titulo = "Reunión de equipo",
            descripcion = "Revisar el avance del proyecto",
            categoria = Categoria.Trabajo,
            prioridad = Prioridad.Media,
            estado = EstadoRecordatorio.Pendiente,
            fechaVencimiento = LocalDateTime.now().plusDays(3)
        )
    )

    // SET: evita categorías duplicadas
    val categorias: Set<Categoria> = recordatorios.map { it.categoria }.toSet()

    // MAP: asocia cada categoría con una etiqueta y un color
    val estiloCategorias: Map<Categoria, Pair<String, Color>> = mapOf(
        Categoria.Personal to ("Personal" to Color(0xFF2E7D32)),
        Categoria.Trabajo to ("Trabajo" to Color(0xFF6A1B9A)),
        Categoria.Salud to ("Salud" to Color(0xFF00838F)),
        Categoria.Estudio to ("Estudio" to Color(0xFFEF6C00))
    )

    // Filtra por estado
    fun porEstado(estado: EstadoRecordatorio): List<Recordatorio> {
        return recordatorios.filter { it.estado == estado }
    }

    // Filtra por prioridad
    fun porPrioridad(prioridad: Prioridad): List<Recordatorio> {
        return recordatorios.filter { it.prioridad == prioridad }
    }

    // Devuelve únicamente los recordatorios pendientes
    fun pendientes(): List<Recordatorio> {
        return porEstado(EstadoRecordatorio.Pendiente)
    }
}