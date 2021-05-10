package sv.ues.fia.ejerciciosysalud.ui.perfil

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_perfil.*
import kotlinx.android.synthetic.main.recyclerview_item_informe.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sv.ues.fia.ejerciciosysalud.EjercicioSaludApplication
import sv.ues.fia.ejerciciosysalud.databinding.FragmentPerfilBinding
import sv.ues.fia.ejerciciosysalud.db.EstadoSaludEntity
import java.math.RoundingMode
import java.util.*


class PerfilFragment : Fragment(){

    companion object {
        fun newInstance() = PerfilFragment()

    }


    private lateinit var viewModel: PerfilViewModel
    private var _binding:  FragmentPerfilBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = activity?.application as EjercicioSaludApplication
        viewModel = ViewModelProvider(
            requireActivity(),
            PerfilViewModelFactory(application.repository)
        ).get(PerfilViewModel::class.java)

        _binding =  FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val altura : EditText = binding.editTextAltura
        val peso : EditText = binding.editTextPeso
        val buttonImc : Button = binding.buttonPerfilGuardarImc
        val buttonHora: Button = binding.buttonPerfilEstablecerHora

        //establecer IMC
        buttonImc.setOnClickListener{
            if (altura.text.isNullOrEmpty() ||
                peso.text.isNullOrEmpty()
            ){
                Toast.makeText(
                    context, "Todos los campos son requeridos",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }else {
                val imc = viewModel.calcularImc(
                    altura.text.toString().toDouble(),
                    peso.text.toString().toDouble()
                )
                val estado = viewModel.obtenerImcCategoria(imc)
                val estadoColor = viewModel.obtenerImcCategColor(imc)
                if (estado =="NoValido"){
                    binding.radioButtonShowEstadoFisico.setBackgroundColor(Color.parseColor("#ffffffff"))
                    Toast.makeText(
                        context,
                        "Los valores de los campos altura o peso no son validos, verifique las unidades de medida",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }else {
                    binding.radioButtonShowEstadoFisico.setText(estado)
                    binding.labelImc.setText(
                        imc.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toString()
                    )
                    binding.radioButtonShowEstadoFisico.setBackgroundColor(Color.parseColor(estadoColor)
                    )
                }
            }
            findNavController()
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}