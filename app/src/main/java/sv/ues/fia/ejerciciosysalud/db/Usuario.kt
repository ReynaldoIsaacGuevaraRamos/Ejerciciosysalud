package sv.ues.fia.ejerciciosysalud.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
@Entity(
        tableName = "Usuario",
        primaryKeys = ["IDieta", "ID_Plan", "IDEstado"],
        foreignKeys = [
            ForeignKey(
                    entity = DietaEntity::class,
                    parentColumns = ["IDieta"],
                    childColumns = ["IDieta"],
                    onDelete = CASCADE
            ),
            ForeignKey(
                    entity = PlanEntity::class,
                    parentColumns = ["ID_Plan"],
                    childColumns = ["ID_Plan"],
                    onDelete = CASCADE
            ),
            ForeignKey(
                    entity = EstadoSaludEntity::class,
                    parentColumns = ["IDEstado"],
                    childColumns = ["IDEstado"],
                    onDelete = CASCADE
        )
        ]
)
data class UsuarioEntity(
        @ColumnInfo(name = "IDieta")
        val IDieta:  Int,
        @ColumnInfo(name = "ID_Plan")
        val ID_Plan: Int,
        @ColumnInfo(name = "IDEstado")
        val IDEstado: Int,
)