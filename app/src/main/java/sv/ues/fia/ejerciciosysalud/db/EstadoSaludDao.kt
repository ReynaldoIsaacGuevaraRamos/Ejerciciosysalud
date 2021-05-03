package sv.ues.fia.ejerciciosysalud.db
import androidx.lifecycle.LiveData
import androidx.room.*
@Dao
interface EstadoSaludDao {
    @Query("SELECT * FROM EstadoSalud")
    fun getAll():LiveData<List<EstadoSaludEntity>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(estadoSalud: EstadoSaludEntity)
    @Update
    fun update(estadoSalud: EstadoSaludEntity)
    @Delete
    fun delete(estadoSalud: EstadoSaludEntity)
    @Query("DELETE FROM EstadoSalud")
    suspend fun deleteAll()
}