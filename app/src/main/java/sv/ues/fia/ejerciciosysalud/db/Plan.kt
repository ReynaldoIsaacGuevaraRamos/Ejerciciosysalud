package sv.ues.fia.ejerciciosysalud.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Plan")
data class PlanEntity(
        @PrimaryKey
        @ColumnInfo(name = "ID_Plan")
        var ID_Plan: String,
        var Dificultad: String,
        var Tiempo_Apro: String,
        var T_Kcal: Float
)