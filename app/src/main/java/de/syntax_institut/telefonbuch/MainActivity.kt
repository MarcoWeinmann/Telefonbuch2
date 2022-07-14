package de.syntax_institut.telefonbuch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import de.syntax_institut.telefonbuch.adapter.ItemAdapter
import de.syntax_institut.telefonbuch.data.Datasource
import de.syntax_institut.telefonbuch.data.model.Contact
import de.syntax_institut.telefonbuch.databinding.ActivityMainBinding

/**
 * Die Main Activity
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

}
