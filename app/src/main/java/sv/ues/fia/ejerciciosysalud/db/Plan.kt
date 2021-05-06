package sv.ues.fia.ejerciciosysalud.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Plan")
data class PlanEntity(
        @PrimaryKey
        var ID_Plan: String,
        var Dificultad: String,
        var Tiempo_Apro: String,
        var T_Kcal: Float,
)