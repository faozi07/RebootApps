package com.example.rebootapps.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.rebootapps.R
import com.example.rebootapps.ui.IntroActivity

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_journal, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        val btnNext: TextView = root.findViewById(R.id.btnLetsGo)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = "Good Morning Ilham!\nHow do you feel right now?"
            btnNext.setOnClickListener {
            }
        })
        return root
    }
}