package sv.ues.fia.ejerciciosysalud.ui.plan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ListView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pl.droidsonroids.gif.GifImageView
import pl.droidsonroids.gif.InputSource
import sv.ues.fia.ejerciciosysalud.R
import sv.ues.fia.ejerciciosysalud.db.EjercicioEntity


class PlanListAdapter(onPlanClickListener: OnPlanClickListener) :
    ListAdapter<EjercicioEntity, PlanListAdapter.PlanViewHolder>(PlanComparator()) {
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
        private val nombre: CheckBox = itemView.findViewById(R.id.checkBox_item_dia)
        private val imageView: GifImageView = itemView.findViewById(R.id.item_Gif)




        fun bind(plan: EjercicioEntity) {
            nombre.text = plan.NombreEjer
            if(plan.IDejer=="ac1") imageView.setImageResource(R.drawable.ac1)
            if(plan.IDejer=="ac2") imageView.setImageResource(R.drawable.ac2)
            if(plan.IDejer=="ac3") imageView.setImageResource(R.drawable.ac3)
            if(plan.IDejer=="ac4") imageView.setImageResource(R.drawable.ac4)
            if(plan.IDejer=="ac5") imageView.setImageResource(R.drawable.ac5)
            if(plan.IDejer=="ac6") imageView.setImageResource(R.drawable.ac6)
            if(plan.IDejer=="ac7") imageView.setImageResource(R.drawable.ac7)
            if(plan.IDejer=="ac8") imageView.setImageResource(R.drawable.ac8)
            if(plan.IDejer=="ac9") imageView.setImageResource(R.drawable.ac9)
            if(plan.IDejer=="ac10") imageView.setImageResource(R.drawable.ac10)
            if(plan.IDejer=="ac11") imageView.setImageResource(R.drawable.ac11)
            if(plan.IDejer=="ac12") imageView.setImageResource(R.drawable.ac12)
            if(plan.IDejer=="ac13") imageView.setImageResource(R.drawable.ac13)
            if(plan.IDejer=="ac14") imageView.setImageResource(R.drawable.ac14)
            if(plan.IDejer=="ac15") imageView.setImageResource(R.drawable.ac15)
            if(plan.IDejer=="ac16") imageView.setImageResource(R.drawable.ac16)
            if(plan.IDejer=="ac17") imageView.setImageResource(R.drawable.ac17)
            if(plan.IDejer=="ac18") imageView.setImageResource(R.drawable.ac18)
            if(plan.IDejer=="ac19") imageView.setImageResource(R.drawable.ac19)
            if(plan.IDejer=="ac20") imageView.setImageResource(R.drawable.ac20)
            if(plan.IDejer=="ac21") imageView.setImageResource(R.drawable.ac21)
            if(plan.IDejer=="ac22") imageView.setImageResource(R.drawable.ac22)

            imageView.setOnClickListener {
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

    class PlanComparator : DiffUtil.ItemCallback<EjercicioEntity>() {
        override fun areItemsTheSame(oldItem: EjercicioEntity, newItem: EjercicioEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: EjercicioEntity, newItem: EjercicioEntity):
                Boolean {
            return oldItem.IDejer == newItem.IDejer
        }
    }

    interface OnPlanClickListener {
        fun onEditPlanClicked(plan: EjercicioEntity)
        fun onDeletePlanClicked(plan: EjercicioEntity)
    }

}