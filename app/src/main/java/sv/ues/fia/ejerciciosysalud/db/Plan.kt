package sv.ues.fia.ejerciciosysalud.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Plan")
data class PlanEntity(
        @PrimaryKey(autoGenerate = true)
        var ID_Plan: Int,
        var Dificultad: String,
        var Estado: Boolean,
        var PlanesFinalizados: Int,
        var T_Kcal: Double,
        var Completado: Boolean,
)