package sv.ues.fia.ejerciciosysalud.db

import androidx.lifecycle.LiveData
import androidx.room.*

interface RutinaDao {
    @Query("SELECT * FROM Rutina")
    fun getAll(): LiveData<List<RutinaEntity>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(rutina: RutinaEntity)
    @Update
    fun update(rutina: RutinaEntity)
    @Delete
    fun delete(rutina: RutinaEntity)
    @Query("DELETE FROM rutina")
    suspend fun deleteAll()

}