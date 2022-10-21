package br.senai.sp.jandira.calendar.repository

import android.content.Context
import br.senai.sp.jandira.calendar.dao.ContactDb
import br.senai.sp.jandira.calendar.model.Contact

class ContactRepository(context: Context) {

        private val db = ContactDb.ContactDb.getDataBase(context).contactDAO()


        fun save(contact: Contact): Long {
            return  db.save(contact)
        }
        fun update(contact: Contact) : Int
        {
            return db.update(contact)
        }
        fun delete(contact: Contact) : Int{
            return  db.delete(contact)
        }
        fun getAll() : List<Contact>{
            return db.getAll()
        }
        fun getContactByID(Id:Int): Contact{
            return db.getContactByID(Id)
        }

}