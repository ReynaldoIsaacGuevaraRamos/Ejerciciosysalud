package sv.ues.fia.ejerciciosysalud.ui.informe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sv.ues.fia.ejerciciosysalud.R
import sv.ues.fia.ejerciciosysalud.db.EstadoSaludEntity



class InformeListAdapter(onInformeClickListener: OnInformeClickListener) :
    ListAdapter<EstadoSaludEntity, InformeListAdapter.InformeViewHolder>(EstadoSaludComparator()) {
    private val mOnEstadoSaludClickListener = onInformeClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformeViewHolder {
        return InformeViewHolder.create(parent, mOnEstadoSaludClickListener)
    }

    override fun onBindViewHolder(holder: InformeViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class InformeViewHolder(itemView: View, onInformeClickListener: OnInformeClickListener) :
        RecyclerView.ViewHolder(itemView) {
        private val onInformeClickListener = onInformeClickListener
        private val  total_Dias: TextView = itemView.findViewById(R.id.view_totalDias)
        private val altura: TextView = itemView.findViewById(R.id.view_altura)
        private val peso: TextView = itemView.findViewById(R.id.view_peso)
        private val imc: TextView = itemView.findViewById(R.id.view_IMC)
        fun bind(estado: EstadoSaludEntity) {
            total_Dias.text = estado.TotalDias.toString()
            altura.text = estado.Altura.toString()
            peso.text = estado.Peso.toString()
            imc.text = estado.IMC.toString()
        }

        companion object {
            fun create(parent: ViewGroup, onInformeClickListener: OnInformeClickListener):
                    InformeViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item_informe, parent, false)
                return InformeViewHolder(view, onInformeClickListener)
            }
        }
    }

    class EstadoSaludComparator : DiffUtil.ItemCallback<EstadoSaludEntity>() {
        override fun areItemsTheSame(oldItem: EstadoSaludEntity, newItem: EstadoSaludEntity): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem:EstadoSaludEntity, newItem:EstadoSaludEntity):
                Boolean {
            return oldItem.IDEstado == newItem.IDEstado
        }
    }

    interface OnInformeClickListener {
    }
}