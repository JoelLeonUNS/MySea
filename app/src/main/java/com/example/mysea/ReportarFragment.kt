package com.example.mysea

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mysea.databinding.FragmentHomeBinding

class ReportarFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_reportar, container, false)

        val btnTakePhoto = view.findViewById<Button>(R.id.btnfoto)
        btnTakePhoto.setOnClickListener{
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if(intent.resolveActivity(requireActivity().packageManager) != null){
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
            }
        }

        val btnLocation = view.findViewById<Button>(R.id.use_location)
        btnLocation.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, MapaFragment())
                .addToBackStack(null)
                .commit()
        }

        val btnReportSubmit = view.findViewById<Button>(R.id.submit_report)
        btnReportSubmit.setOnClickListener{
            val intent = Intent(requireContext(),HomeFragment::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        return view
    }


    companion object{
        private const val REQUEST_IMAGE_CAPTURE = 1
    }
}