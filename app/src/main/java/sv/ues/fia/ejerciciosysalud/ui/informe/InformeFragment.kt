package sv.ues.fia.ejerciciosysalud.ui.informe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import sv.ues.fia.ejerciciosysalud.R

class InformeFragment : Fragment() {

    private lateinit var informeViewModel: InformeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        informeViewModel =
                ViewModelProvider(this).get(InformeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_informe, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        informeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}