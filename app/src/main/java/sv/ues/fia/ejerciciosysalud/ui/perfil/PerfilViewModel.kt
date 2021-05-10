package sv.ues.fia.ejerciciosysalud.ui.perfil

import android.view.View
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sv.ues.fia.ejerciciosysalud.db.EjercicioSaludRepository
import sv.ues.fia.ejerciciosysalud.db.EstadoSaludEntity
import sv.ues.fia.ejerciciosysalud.db.PlanEntity
import sv.ues.fia.ejerciciosysalud.db.UsuarioEntity
import sv.ues.fia.ejerciciosysalud.ui.plan.PlanViewModel
import kotlin.math.pow

class PerfilViewModel(private val repository: EjercicioSaludRepository) : ViewModel() {
    private val estadoFisico =
        arrayOf(
            "NoValido",
            "Delgadez severa",
            "Peso bajo",
            "Peso saludable",
            "Sobrepeso",
            "Obesidad moderada",
            "Obesidad severa",
            "Obesidad muy severa"
        )
    private val estadoColor = arrayOf("#ffffffff",
            "#203bd2",
            "#117eff",
            "#08cadf",
            "#ffcb08",
            "#ff940a",
            "#ff0434",
            "#ff0434",
        )
    private val escalas = arrayOf(
        6.20,
        16.00,
        18.50,
        25.00,
        30.00,
        35.00,
        40.00,
        250.00
    )


    private val planDificultad = arrayOf("Principiante", "Intermedio", "Avanzado")
    val grupoMusuculares = arrayOf("Abdominales", "Piernas", "Brazos")
    val usuario: LiveData<List<UsuarioEntity>> = repository.usuario
    val estado: LiveData<List<EstadoSaludEntity>> = repository.estadosalud
    val plan: LiveData<List<PlanEntity>> = repository.plan

    fun insert(usuario: UsuarioEntity) = viewModelScope.launch {
        repository.insert(usuario)
    }
    fun insertEstado(estado: EstadoSaludEntity) = viewModelScope.launch {
        repository.insert(estado)
    }

    fun calcularImc(altura: Double, peso: Double): Double {
        val alturaPow = (altura / 100.00).pow(2)
        val imc = peso / alturaPow.toFloat()
        return imc
    }

    fun obtenerImcCategoria(imc: Double): String {
        for (i in 0..7) {
            if (imc < escalas[i]) {
                return estadoFisico[i]
            }
        }
        return "NoValido"
    }
    fun obtenerImcCategColor(imc: Double): String {
        for (i in 0..7) {
            if (imc < escalas[i]) {
                return estadoColor[i]
            }
        }
        return "#ffffffff"
    }

    fun update(usuario: UsuarioEntity) = viewModelScope.launch {
        repository.update(usuario)
    }

    fun delete(usuario: UsuarioEntity) = viewModelScope.launch {
        repository.delete(usuario)
    }

}


class PerfilViewModelFactory(private val repository: EjercicioSaludRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PerfilViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PerfilViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}