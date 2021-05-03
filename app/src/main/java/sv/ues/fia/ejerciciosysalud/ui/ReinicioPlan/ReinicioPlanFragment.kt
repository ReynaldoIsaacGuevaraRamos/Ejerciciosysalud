package sv.ues.fia.ejerciciosysalud.ui.ReinicioPlan

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sv.ues.fia.ejerciciosysalud.R

class ReinicioPlanFragment : Fragment() {

    companion object {
        fun newInstance() = ReinicioPlanFragment()
    }

    private lateinit var viewModel: ReinicioPlanViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.reinicio_plan_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ReinicioPlanViewModel::class.java)
        // TODO: Use the ViewModel
    }

}