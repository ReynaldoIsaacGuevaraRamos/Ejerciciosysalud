package sv.ues.fia.ejerciciosysalud.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Dieta")
data class DietaEntity(
        @PrimaryKey(autoGenerate = true)
        var IDieta: Int,
        var Porciones: MutableList<String>,
        var Tiempo: Double,
        var Alimentos: MutableList<String>,
)