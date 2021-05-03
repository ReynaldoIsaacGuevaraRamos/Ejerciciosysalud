package sv.ues.fia.ejerciciosysalud.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
@Database(
        entities = [
            DietaEntity::class,
            EjercicioEntity::class,
            EstadoSaludEntity::class,
            PlanEntity::class,
            RutinaEntity:: class,
            UsuarioEntity:: class,

        ],
        version = 1,
        exportSchema = false
)
abstract class EjercicioSaludDB : RoomDatabase() {
    abstract fun DietaDao(): DietaDao
    abstract fun EjercicioDao(): EjercicioDao
    abstract fun EstadoSaludDao(): EstadoSaludDao
    abstract fun PlanDao(): PlanDao
    abstract fun RutinaDao(): RutinaDao
    abstract fun UsuarioDao(): UsuarioDao

    }


