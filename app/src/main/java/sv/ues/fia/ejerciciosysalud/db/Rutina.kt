package sv.ues.fia.ejerciciosysalud.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
        tableName = "Rutina",
        primaryKeys = ["IDejer", "ID_Plan"],
        foreignKeys = [
            ForeignKey(
                    entity = EjercicioEntity::class,
                    parentColumns = ["IDejer"],
                    childColumns = ["IDejer"],
                    onDelete = ForeignKey.CASCADE
            ),
            ForeignKey(
                    entity = PlanEntity::class,
                    parentColumns = ["ID_Plan"],
                    childColumns = ["ID_Plan"],
                    onDelete = ForeignKey.CASCADE
            )
        ]
)
data class RutinaEntity(
        @ColumnInfo(name = "IDejer")
        val IDejer: Int,
        @ColumnInfo(name = "ID_plan")
        val ID_Plan: Int,
)