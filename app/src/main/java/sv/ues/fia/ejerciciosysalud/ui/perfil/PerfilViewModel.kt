package sv.ues.fia.ejerciciosysalud.ui.perfil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PerfilViewModel : ViewModel() {
    val estadoFisico = arrayOf("Delgadez severa", "Peso bajo", "Peso saludable", "Sobrepeso", "Obesidad moderada", "Obesidad severa")
    val planDificultad = arrayOf("Principiante", "Intermedio", "Avanzado")
    val grupoMusuculares = arrayOf("Abdominales", "Piernas", "Brazos")
    private val _text = MutableLiveData<String>().apply {
        value = "@string/perfil_estatura"
    }
    val text: LiveData<String> = _text
}