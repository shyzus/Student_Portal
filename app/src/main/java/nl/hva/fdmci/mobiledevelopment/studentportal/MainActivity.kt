package nl.hva.fdmci.mobiledevelopment.studentportal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import nl.hva.fdmci.mobiledevelopment.studentportal.model.Portal
import nl.hva.fdmci.mobiledevelopment.studentportal.model.PortalAdapter
import java.util.ArrayList

const val PORTAL_NEW = "PORTAL_NEW"
const val PORTAL_OLD = "PORTAL_OLD"

class MainActivity : AppCompatActivity() {

    var portals: ArrayList<Portal> = ArrayList()
    lateinit var portalAdapter: PortalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            val createPortalIntent = Intent(this,
                CreatePortalActivity::class.java)
            createPortalIntent.putExtra(PORTAL_OLD, portals)
            startActivity(createPortalIntent)
        }

        initViews()
    }

    private fun initViews() {
        val portals = intent.getParcelableArrayListExtra<Portal>(PORTAL_OLD)
        val portal = intent.getParcelableExtra<Portal>(PORTAL_NEW)

        if (portals != null) {
            this.portals = portals
            if (portal != null) {
                this.portals.add(portal)
                println(portal.title)
                println(portals.size)
            }
        }

        portalAdapter = PortalAdapter(this.portals)

        portalRV.adapter = portalAdapter
        portalRV.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)

        println(portalAdapter.itemCount)

        portalAdapter.notifyDataSetChanged()
    }
}
