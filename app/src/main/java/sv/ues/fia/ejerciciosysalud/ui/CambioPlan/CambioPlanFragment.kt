package sv.ues.fia.ejerciciosysalud.ui.CambioPlan

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sv.ues.fia.ejerciciosysalud.R

class CambioPlanFragment : Fragment() {

    companion object {
        fun newInstance() = CambioPlanFragment()
    }

    private lateinit var viewModel: CambioPlanViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cambio_plan_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CambioPlanViewModel::class.java)
        // TODO: Use the ViewModel
    }

}