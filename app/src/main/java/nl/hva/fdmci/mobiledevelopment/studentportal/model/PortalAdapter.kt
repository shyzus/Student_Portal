package nl.hva.fdmci.mobiledevelopment.studentportal.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.component_portal.view.*
import nl.hva.fdmci.mobiledevelopment.studentportal.R
import java.util.ArrayList

class PortalAdapter(private val portals: ArrayList<Portal>) :
    RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.component_portal, parent, false)
        )
    }
    override fun getItemCount(): Int {
        return portals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(portals[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(portal : Portal) {
            itemView.portalBtn.text = portal.title.plus("\n").plus(portal.url)
        }
    }
}