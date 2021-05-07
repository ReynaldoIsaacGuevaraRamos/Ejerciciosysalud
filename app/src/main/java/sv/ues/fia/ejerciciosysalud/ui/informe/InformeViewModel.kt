package sv.ues.fia.ejerciciosysalud.ui.informe

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import sv.ues.fia.ejerciciosysalud.db.EjercicioSaludRepository
import sv.ues.fia.ejerciciosysalud.db.EstadoSaludEntity


class InformeViewModel(private val repository: EjercicioSaludRepository) : ViewModel() {

    val estadosSalud: LiveData<List<EstadoSaludEntity>> = repository.estadosalud
    var estadoSaludActual: EstadoSaludEntity? = null
    fun insert(estado: EstadoSaludEntity) = viewModelScope.launch {
        repository.insert(estado)
    }

    fun update(estado: EstadoSaludEntity) = viewModelScope.launch {
        repository.update(estado)
    }

    fun delete(estado: EstadoSaludEntity) = viewModelScope.launch {
        repository.delete(estado)
    }
}

class InformeViewModelFactory(private val repository: EjercicioSaludRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InformeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InformeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}