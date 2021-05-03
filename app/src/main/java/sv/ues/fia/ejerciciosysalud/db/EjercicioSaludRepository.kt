package sv.ues.fia.ejerciciosysalud.db

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class EjercicioSaludRepository(private val db: EjercicioSaludDB) {
    /***************************
     * Dieta repository
     ***************************/
    val dieta: LiveData<List<DietaEntity>> = db.DietaDao().getAll()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(dieta: DietaEntity) {
        db.DietaDao().insert(dieta)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(dieta: DietaEntity) {
        db.DietaDao().update(dieta)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(dieta: DietaEntity) {
        db.DietaDao().delete(dieta)
    }
    /***************************
     * Ejercicio repository
     ***************************/
    val ejercicio: LiveData<List<EjercicioEntity>> = db.EjercicioDao().getAll()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(ejercicio: EjercicioEntity) {
        db.EjercicioDao().insert(ejercicio)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(ejercicio: EjercicioEntity) {
        db.EjercicioDao().update(ejercicio)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(ejercicio: EjercicioEntity) {
        db.EjercicioDao().delete(ejercicio)
    }
    /***************************
     * EstadoSalud repository
     ***************************/
    val estadosalud: LiveData<List<EstadoSaludEntity>> = db.EstadoSaludDao().getAll()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(estadosalud: EstadoSaludEntity) {
        db.EstadoSaludDao().insert(estadosalud)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(estadosalud: EstadoSaludEntity) {
        db.EstadoSaludDao().update(estadosalud)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(estadosalud: EstadoSaludEntity) {
        db.EstadoSaludDao().delete(estadosalud)
    }
    /***************************
     * Plan repository
     ***************************/
    val plan: LiveData<List<PlanEntity>> = db.PlanDao().getAll()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(plan: PlanEntity) {
        db.PlanDao().insert(plan)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(plan: PlanEntity) {
        db.PlanDao().update(plan)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(plan: PlanEntity) {
        db.PlanDao().delete(plan)
    }
    /***************************
     * Rutina Salud repository
     ***************************/
    val rutina: LiveData<List<RutinaEntity>> = db.RutinaDao().getAll()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(rutina: RutinaEntity) {
        db.RutinaDao().insert(rutina)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(rutina: RutinaEntity) {
        db.RutinaDao().update(rutina)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(rutina: RutinaEntity) {
        db.RutinaDao().delete(rutina)
    }
    /***************************
     * Usuario repository
     ***************************/
    val usuario: LiveData<List<UsuarioEntity>> = db.UsuarioDao().getAll()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(usuario:UsuarioEntity) {
        db.UsuarioDao().insert(usuario)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(usuario: UsuarioEntity) {
        db.UsuarioDao().update(usuario)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(usuario: UsuarioEntity) {
        db.UsuarioDao().delete(usuario)
    }
}