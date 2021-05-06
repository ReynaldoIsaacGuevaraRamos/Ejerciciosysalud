package sv.ues.fia.ejerciciosysalud.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "EstadoSalud")
data class EstadoSaludEntity(
        @PrimaryKey(autoGenerate = true)
        var IDEstado: Int,
        var TotalDias: Int,
        var Peso: Float,
        var Altura: Float,
        var IMC: Float,
        )

