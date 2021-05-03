package sv.ues.fia.ejerciciosysalud.db

import androidx.lifecycle.LiveData
import androidx.room.*
@Dao
interface EjercicioDao {
    @Query("SELECT * FROM Ejercicio")
    fun getAll(): LiveData<List<EjercicioEntity>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(ejercicio: EjercicioEntity)
    @Update
    fun update(ejercicio: EjercicioEntity)
    @Delete
    fun delete(ejercicio: EjercicioEntity)
    @Query("DELETE FROM Ejercicio")
    suspend fun deleteAll()
}