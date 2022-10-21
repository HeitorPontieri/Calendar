package br.senai.sp.jandira.calendar.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.calendar.model.Contact

// Essa classe vai permitir que o DAO entre em contato com o db
@Database(entities = [Contact :: class] , version = 1)
abstract class ContactDb {

    abstract  class ContactDb : RoomDatabase(){

       abstract  fun contactDAO () : ContactDAO

       companion object {
           private lateinit var instance: ContactDb

           fun getDataBase(context:Context): ContactDb {
               if (!::instance.isInitialized) {
                   instance = Room.databaseBuilder(context, ContactDb::class.java, "db_agenda")
                       .allowMainThreadQueries().build()
               }
               return instance
           }
       }
    }
}