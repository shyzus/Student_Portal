package nl.hva.fdmci.mobiledevelopment.studentportal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_create_portal.*
import nl.hva.fdmci.mobiledevelopment.studentportal.model.Portal


class CreatePortalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_portal)

        initViews()
    }

    override fun onSupportNavigateUp(): Boolean {
        startActivity(Intent(this,MainActivity::class.java))
        return true
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Create a Portal"
        addPortalBtn.setOnClickListener{onAddPortal()}
    }

    private fun onAddPortal() {
        val portal = Portal(titleIET.text.toString(), urlIET.text.toString())
        val portals = intent.getParcelableArrayListExtra<Portal>(PORTAL_OLD)

        val addedPortalActivityIntent = Intent(this,MainActivity::class.java)
        addedPortalActivityIntent.putExtra(PORTAL_NEW, portal)
        addedPortalActivityIntent.putExtra(PORTAL_OLD, portals)
        startActivity(addedPortalActivityIntent)
    }

}