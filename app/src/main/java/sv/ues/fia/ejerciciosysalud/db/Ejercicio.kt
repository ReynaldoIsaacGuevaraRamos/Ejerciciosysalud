package sv.ues.fia.ejerciciosysalud.db
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*
@Entity(tableName = "Ejercicio")

data class EjercicioEntity(
        @PrimaryKey
        var IDejer: String,
        var NombreEjer: String,
        var Indicaciones: String
)