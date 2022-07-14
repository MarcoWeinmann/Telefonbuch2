package de.syntax_institut.telefonbuch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import de.syntax_institut.telefonbuch.adapter.ItemAdapter
import de.syntax_institut.telefonbuch.data.Datasource
import de.syntax_institut.telefonbuch.data.model.Contact
import de.syntax_institut.telefonbuch.databinding.ActivityMainBinding
import de.syntax_institut.telefonbuch.databinding.FragmentFrag1Binding

class Frag1 : Fragment() {
    private lateinit var binding: FragmentFrag1Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_frag1, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


            // hole die Liste mit den Kontakten
            val contacts = Datasource().loadContacts()

            // die RecyclerView bekommt den Adapter
            val itemAdapter = ItemAdapter(contacts)
            binding.recyclerView.adapter = itemAdapter

            // Button fügt einen Listeneintrag hinzu
            binding.btnAdd.setOnClickListener {

                // Hole den Inhalt aus den Textfeldern
                val name = binding.inName.text.toString()
                val number = binding.inPhoneNumber.text.toString()

                // Falls in beiden Textfeldern etwas steht
                if (name != "" && number != "") {
                    val position =
                        contacts.size // kann auch ein anderer Index <= contacts.size sein
                    contacts.add(position, Contact(name, number))
                    itemAdapter.notifyItemInserted(position)
                    binding.inName.setText("")
                    binding.inPhoneNumber.setText("")
                }
            }
        }
    }

