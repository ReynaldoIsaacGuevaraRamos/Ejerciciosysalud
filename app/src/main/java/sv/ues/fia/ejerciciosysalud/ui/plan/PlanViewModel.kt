package sv.ues.fia.ejerciciosysalud.ui.plan

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import sv.ues.fia.ejerciciosysalud.db.EjercicioSaludRepository
import sv.ues.fia.ejerciciosysalud.db.PlanEntity

class PlanViewModel(private val repository: EjercicioSaludRepository) : ViewModel() {

    val planes: LiveData<List<PlanEntity>> = repository.plan
    var planActual: PlanEntity? = null
    fun insert(plan: PlanEntity) = viewModelScope.launch {
        repository.insert(plan)
    }

    fun update(plan: PlanEntity) = viewModelScope.launch {
        repository.update(plan)
    }

    fun delete(plan: PlanEntity) = viewModelScope.launch {
        repository.delete(plan)
    }
}

class PlanViewModelFactory(private val repository: EjercicioSaludRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlanViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PlanViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}
