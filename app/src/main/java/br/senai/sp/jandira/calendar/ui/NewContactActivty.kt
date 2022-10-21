package br.senai.sp.jandira.calendar.ui

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import br.senai.sp.jandira.calendar.databinding.NewcontactActivityBinding
import br.senai.sp.jandira.calendar.model.Contact
import br.senai.sp.jandira.calendar.repository.ContactRepository
import java.time.LocalDate

class NewContactActivty : AppCompatActivity() {


    lateinit var binding: NewcontactActivityBinding
    lateinit var contactRepository: ContactRepository
    private var id = 0
    lateinit var contato : Contact

    override fun onCreate(savedInstanceState: Bundle ?) {
        super.onCreate(savedInstanceState)

        binding = NewcontactActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contato = Contact()

        binding.buttonSave.setOnClickListener(){
            save()
        }
        binding.buttonDelete.setOnClickListener {
            excluir()
        }

        id = intent.getIntExtra("id", 0)

        if(id> 0){
            binding.buttonDelete.visibility = View.VISIBLE
            binding.buttonSave.text = "Atualizar"
            carregarContato()

        }
    }
    private fun carregarContato(){
        val contato = contactRepository.getContactByID(id)

        binding.editTextTextEmailAddress.setText(contato.email)
        binding.editTextTextPersonName.setText(contato.nome)
        binding.editTextPhone.setText(contato.telefone)

    }

    private fun save(){

        contato.dataNascimento = binding.editTextDate.text.toString()
        contato.email = binding.editTextTextEmailAddress.text.toString()
        contato.nome = binding.editTextTextPersonName.text.toString()
        contato.telefone = binding.editTextPhone.text.toString()

        var ContactRepository = ContactRepository(this)

        if(id > 0){
            contato.id = id
            contactRepository.update(contato)
        }
        else{
            val id = ContactRepository.save(contato)
        }

        Toast.makeText(this, "ID : $id", Toast.LENGTH_LONG).show()

        finish()
    }
    private fun excluir (){

        val confirmacao =  AlertDialog.Builder(this)
        confirmacao.setTitle("Exclusão")
        confirmacao.setMessage("Tem certeza que quer excluir o contato de(a) ${contato.nome}")

        confirmacao.setPositiveButton ("Sim"){_,_ ->

            contactRepository.delete(contato)
            finish()
        }
        confirmacao.setNegativeButton("Não"){_,_ ->

        }
        confirmacao.show()
    }




}