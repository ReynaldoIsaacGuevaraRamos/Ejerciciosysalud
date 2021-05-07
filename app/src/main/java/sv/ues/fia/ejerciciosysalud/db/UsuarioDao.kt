package sv.ues.fia.ejerciciosysalud.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UsuarioDao {
    @Query("SELECT * FROM Usuario")
    fun getAll(): LiveData<List<UsuarioEntity>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(usuario: UsuarioEntity)
    @Update
    fun update(usuario: UsuarioEntity)
    @Delete
    fun delete(usuario: UsuarioEntity)
    @Query("DELETE FROM Usuario")
    suspend fun deleteAll()
}