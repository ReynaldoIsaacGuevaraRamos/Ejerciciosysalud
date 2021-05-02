package sv.ues.fia.ejerciciosysalud.ui.perfil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PerfilViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "@string/perfil_estatura"
    }
    val text: LiveData<String> = _text
}