package sv.ues.fia.ejerciciosysalud

import android.app.Application

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import sv.ues.fia.ejerciciosysalud.db.EjercicioSaludDB
import sv.ues.fia.ejerciciosysalud.db.EjercicioSaludRepository


class EjercicioSaludApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { EjercicioSaludDB.getDatabase(this, applicationScope) }
    val repository by lazy { EjercicioSaludRepository(database) }
}
