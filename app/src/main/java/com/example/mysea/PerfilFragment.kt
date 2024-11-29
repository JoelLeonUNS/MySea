package com.example.mysea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mysea.databinding.FragmentPerfilBinding

class PerfilFragment : Fragment() {

    private lateinit var binding: FragmentPerfilBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPerfilBinding.inflate(inflater, container, false)
        val view = binding.root



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar RecyclerView con el Binding
        binding.rvReports.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ReportsAdapter(getExampleReports())
        }

        // Configuración de ejemplo para nombre y correo
        binding.tvUserName.text = "Juan Pérez"
        binding.tvUserEmail.text = "juan.perez@example.com"

        // Acción del botón Editar Perfil
        binding.btnEditProfile.setOnClickListener {
            // Aquí puedes agregar navegación o lógica al editar el perfil
        }
    }

    private fun getExampleReports(): List<Report> {
        return listOf(
            Report("29/11/2024", "Reporte sobre el análisis financiero."),
            Report("28/11/2024", "Reporte de incidentes del sistema."),
            Report("27/11/2024", "Reporte de métricas de rendimiento.")
        )
    }

}