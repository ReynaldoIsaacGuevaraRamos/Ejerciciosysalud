package sv.ues.fia.ejerciciosysalud.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Dieta")
data class DietaEntity(
        @PrimaryKey
        @ColumnInfo(name = "IDieta")
        var IDieta: String,
        var Tiempo: String,
        var Alimentos: String
)