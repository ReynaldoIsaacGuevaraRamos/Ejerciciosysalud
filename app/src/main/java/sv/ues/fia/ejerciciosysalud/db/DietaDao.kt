package sv.ues.fia.ejerciciosysalud.db

import androidx.lifecycle.LiveData
import androidx.room.*
@Dao
interface DietaDao {
    @Query("SELECT * FROM Dieta")
    fun getAll(): LiveData<List<DietaEntity>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dieta: DietaEntity)
    @Update
    suspend fun update(dieta: DietaEntity)
    @Delete
    suspend fun delete(dieta: DietaEntity)
    @Query("DELETE FROM Dieta")
    suspend fun deleteAll()
}