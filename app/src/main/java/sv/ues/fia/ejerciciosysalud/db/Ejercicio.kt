package sv.ues.fia.ejerciciosysalud.db
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Ejercicio")
data class EjercicioEntity(
        @PrimaryKey(autoGenerate = true)
        var IDejer: Int,
        var NombreEjer: String,
        var Musculo: Int,
)