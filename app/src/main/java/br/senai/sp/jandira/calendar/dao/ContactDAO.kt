package br.senai.sp.jandira.calendar.dao


import androidx.room.*
import br.senai.sp.jandira.calendar.model.Contact
import kotlinx.coroutines.selects.select

// Quem vai cuidar desta interface vai ser o room
@Dao
interface ContactDAO{

  // Função para inserir algum registro
  @Insert  fun save(context: Contact) : Long

  // Função para apagar, deletear um ou vários registros
    // Esse int vai ser o retorno de quantos registros serão excluídos do db
  @Delete fun delete(context: Contact) : Int

 // Função para apagar, deletear um ou vários registros
 // Esse int vai ser o retorno de quantos registros serão alterados do db
  @Update fun update(contact: Contact) : Int

  // Retorna tudo o que tem dentro do db, ordenando pelo nome
  @Query("SELECT * FROM tbl_contact ORDER BY nome ASC")fun getAll() : List<Contact>

  // Retorna todos os cadastros pelo id
 @Query("SELECT * FROM tbl_contact WHERE id = :id ")fun getContactByID(id:Int) : Contact
}