package sv.ues.fia.ejerciciosysalud.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlanDao {
    @Query("SELECT * FROM 'Plan'")
    fun getAll(): LiveData<List<PlanEntity>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(plan: PlanEntity)
    @Update
    fun update(plan: PlanEntity)
    @Delete
    fun delete(plan: PlanEntity)
    @Query("DELETE FROM 'Plan'")
    suspend fun deleteAll()
}