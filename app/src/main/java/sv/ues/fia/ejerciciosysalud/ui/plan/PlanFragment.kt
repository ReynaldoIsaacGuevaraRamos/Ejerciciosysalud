package sv.ues.fia.ejerciciosysalud.ui.plan

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
import sv.ues.fia.ejerciciosysalud.db.EjercicioEntity


class PlanFragment : Fragment(), PlanListAdapter.OnPlanClickListener  {

    companion object {
        fun newInstance() = PlanFragment()
    }
    private lateinit var viewModel: PlanViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = activity?.application as EjercicioSaludApplication
        viewModel = ViewModelProvider(requireActivity(),
            PlanViewModelFactory(application.repository)).get(PlanViewModel::class.java)
        return inflater.inflate(R.layout.fragment_plan, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerviewPlan)
        val adapter = PlanListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.ejercicios.observe(viewLifecycleOwner, Observer { plan ->
            plan?.let { adapter.submitList(it) }
        })

    }
    override fun onEditPlanClicked(plan: EjercicioEntity) {
        viewModel.ejercicioActual = plan
        findNavController().navigate(R.id.action_nav_plan_to_nav_guardar_plan)
    }
    override fun onDeletePlanClicked(plan: EjercicioEntity) {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage("Estas seguro que deseas borrar el alumno con carnet: ${plan.IDejer}")
            .setCancelable(false)
            .setPositiveButton("Si") { dialog, id ->
                viewModel.delete(plan)
            }
            .setNegativeButton("No") { dialog, id ->
                dialog.dismiss()
            }
        val alert = builder.create()
        alert.show()
    }
}