package sv.ues.fia.ejerciciosysalud.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "EstadoSalud")
data class EstadoSaludEntity(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "IDEstado")
        var ID_Estado: Int,
        @ColumnInfo(name = "Total_Dias", defaultValue = "0")
        var TotalDias: Int,
        var Peso: Float,
        var Altura: Float,
        var IMC: Float
        )

