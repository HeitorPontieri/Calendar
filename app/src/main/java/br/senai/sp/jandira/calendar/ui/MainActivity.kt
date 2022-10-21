package br.senai.sp.jandira.calendar.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.senai.sp.jandira.calendar.adapter.ContactAdapter
import br.senai.sp.jandira.calendar.databinding.ActivityMainBinding
import br.senai.sp.jandira.calendar.repository.ContactRepository


class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    lateinit var  adapter: ContactAdapter
    lateinit var  repository: ContactRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fbNewContact.setOnClickListener{
            val abrirCadastro = Intent (this, NewContactActivty ::  class.java)

                startActivity(abrirCadastro)
        }

    }
    private fun carregarRecyclerView(){
        repository = ContactRepository(this)
        val contacts = repository.getAll()
        adapter = ContactAdapter(contacts, this)
        binding.rvContacts.adapter = adapter

        binding.rvContacts.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    override fun onResume() {
        super.onResume()

        carregarRecyclerView()
    }
}