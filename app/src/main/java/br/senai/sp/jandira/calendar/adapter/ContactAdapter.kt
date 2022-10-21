package br.senai.sp.jandira.calendar.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.calendar.R
import br.senai.sp.jandira.calendar.model.Contact
import br.senai.sp.jandira.calendar.ui.NewContactActivty

class ContactAdapter(var contactList: List<Contact>, var context: Context): RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    fun updateContactList (newContactList: List<Contact>){
        this.contactList = newContactList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.contact_layout,parent,false)
        return  ContactHolder((view))
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val contact = contactList[position]

        holder.textViewNome.text = contact.nome
        holder.textViewEmail.text = contact.email
        holder.textViewTelefone.text = contact.telefone
        holder.textViewInicial.text = contact.nome.substring(0,1)

        holder.cardViewContact.setOnClickListener{
            val intent = Intent(context,NewContactActivty ::class.java)
            intent.putExtra("id", contact.id)

            context.startActivity((intent))
        }
    }

    override fun getItemCount(): Int {
       return contactList.size
    }


    class ContactHolder(view:View): RecyclerView.ViewHolder(view){

        val textViewNome : TextView = view.findViewById(R.id.contact_name)
        val textViewEmail : TextView = view.findViewById(R.id.email_contact)
        val textViewTelefone : TextView = view.findViewById(R.id.telephone_contact)
        val textViewInicial : TextView = view.findViewById(R.id.letter_contact)
        val cardViewContact : TextView = view.findViewById(R.id.card_view_contato)


    }


}
