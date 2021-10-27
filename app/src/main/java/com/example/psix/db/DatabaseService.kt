package com.example.psix.db

import com.example.psix.models.Contact

interface DatabaseService {

    fun addContact(contact: Contact)

    fun deleteContact(contact: Contact)

    fun updateContact(contact: Contact):Int

    fun getContactById(id:Int): Contact

    fun getAllContacts(): List<Contact>
}