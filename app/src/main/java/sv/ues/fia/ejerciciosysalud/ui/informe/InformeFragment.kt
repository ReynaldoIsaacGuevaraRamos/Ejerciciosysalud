package sv.ues.fia.ejerciciosysalud.ui.informe



import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sv.ues.fia.ejerciciosysalud.EjercicioSaludApplication
import sv.ues.fia.ejerciciosysalud.R
import sv.ues.fia.ejerciciosysalud.db.EstadoSaludEntity
import sv.ues.fia.ejerciciosysalud.ui.plan.PlanViewModelFactory

class InformeFragment : Fragment(), InformeListAdapter.OnInformeClickListener  {

    companion object {
        fun newInstance() = InformeFragment()
    }
    private lateinit var viewModel: InformeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = activity?.application as EjercicioSaludApplication
        viewModel = ViewModelProvider(requireActivity(),
            InformeViewModelFactory(application.repository)
        ).get(InformeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_informe, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview_informe)
        val adapter = InformeListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.estadosSalud.observe(viewLifecycleOwner, Observer { estado ->
            estado?.let { adapter.submitList(it) }
        })

    }


}