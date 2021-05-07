package sv.ues.fia.ejerciciosysalud.ui.plan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sv.ues.fia.ejerciciosysalud.R
import sv.ues.fia.ejerciciosysalud.db.PlanEntity


class PlanListAdapter(onPlanClickListener: OnPlanClickListener) :
    ListAdapter<PlanEntity, PlanListAdapter.PlanViewHolder>(PlanComparator()) {
    private val mOnPlanClickListener = onPlanClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        return PlanViewHolder.create(parent, mOnPlanClickListener)
    }

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class PlanViewHolder(itemView: View, onPlanClickListener: OnPlanClickListener) :
        RecyclerView.ViewHolder(itemView) {
        private val onPlanClickListener = onPlanClickListener
        private val id_plan: TextView = itemView.findViewById(R.id.item_id)
        private val dificultad: TextView = itemView.findViewById(R.id.item_difi)
        private val iniciar: ImageButton = itemView.findViewById(R.id.iniciar_button)
        fun bind(plan: PlanEntity) {
            id_plan.text = plan.ID_Plan
            dificultad.text = plan.Dificultad
            iniciar.setOnClickListener {
                onPlanClickListener.onEditPlanClicked(plan)
            }

        }

        companion object {
            fun create(parent: ViewGroup, onPlanClickListener: OnPlanClickListener):
                    PlanViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item_plan_dia, parent, false)
                return PlanViewHolder(view, onPlanClickListener)
            }
        }
    }

    class PlanComparator : DiffUtil.ItemCallback<PlanEntity>() {
        override fun areItemsTheSame(oldItem:PlanEntity, newItem: PlanEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PlanEntity, newItem:PlanEntity):
                Boolean {
            return oldItem.ID_Plan == newItem.ID_Plan
        }
    }

    interface OnPlanClickListener {
        fun onEditPlanClicked(plan: PlanEntity)
        fun onDeleteAlumnoClicked(plan: PlanEntity)
    }
}