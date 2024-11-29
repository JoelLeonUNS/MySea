package com.example.mysea

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReportsAdapter(private val reports: List<Report>) :
    RecyclerView.Adapter<ReportsAdapter.ReportViewHolder>() {

    // ViewHolder para el RecyclerView
    class ReportViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dateTextView: TextView = view.findViewById(R.id.tv_report_date)
        val descriptionTextView: TextView = view.findViewById(R.id.tv_report_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_report_card, parent, false)
        return ReportViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        val report = reports[position]
        holder.dateTextView.text = report.date
        holder.descriptionTextView.text = report.description
    }

    override fun getItemCount(): Int = reports.size
}