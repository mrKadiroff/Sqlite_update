package com.example.psix.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.psix.models.Contact
import com.example.psix.utils.Constant

class MyDbHelper(context: Context) :
    SQLiteOpenHelper(context,Constant.DB_NAME, null, Constant.DB_VERSION), DatabaseService {
    override fun onCreate(db: SQLiteDatabase?) {
        val query =
            "create table ${Constant.TABLE_NAME} (${Constant.ID} integer not null primary key autoincrement unique, ${Constant.NAME} text not null, ${Constant.PHONE_NUMBER} text not null, ${Constant.DESCRIPTER} text not null, ${Constant.SANAM} text not null)"
        db?.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists ${Constant.TABLE_NAME}")
        onCreate(db)
    }

    override fun addContact(contact: Contact) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constant.NAME, contact.name)
        contentValues.put(Constant.PHONE_NUMBER, contact.phoneNumber)
        contentValues.put(Constant.DESCRIPTER, contact.descripter)
        contentValues.put(Constant.SANAM, contact.sana)
        database.insert(Constant.TABLE_NAME, null, contentValues)
        database.close()
    }

    override fun deleteContact(contact: Contact) {
        val database = this.writableDatabase
        database.delete(Constant.TABLE_NAME, "${Constant.ID} = ?", arrayOf("${contact.id}"))
        database.close()
    }

    override fun updateContact(contact: Contact): Int {
        val database = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(Constant.ID, contact.id)
        contentValues.put(Constant.NAME, contact.name)
        contentValues.put(Constant.PHONE_NUMBER, contact.phoneNumber)
        contentValues.put(Constant.DESCRIPTER, contact.descripter)
        contentValues.put(Constant.SANAM, contact.sana)
        return database.update(
            Constant.TABLE_NAME,
            contentValues,
            "${Constant.ID} = ?",
            arrayOf(contact.id.toString())
        )

    }

    override fun getContactById(id: Int): Contact {
        val database = this.readableDatabase
        val cursor = database.query(
            Constant.TABLE_NAME,
            arrayOf(Constant.ID, Constant.NAME, Constant.PHONE_NUMBER, Constant.DESCRIPTER, Constant.SANAM),
            "${Constant.ID} = ?",
            arrayOf("$id"),
            null, null, null
        )
        cursor?.moveToFirst()
        return Contact(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4))
    }

    override fun getAllContacts(): ArrayList<Contact> {
        val list = ArrayList<Contact>()
        val query = "select * from ${Constant.TABLE_NAME}"
        val database = this.readableDatabase
        val cursor = database.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val phone = cursor.getString(2)
                val descripter = cursor.getString(3)
                val sana = cursor.getString(4)
                val contact = Contact(id, name, phone, descripter,sana)
                list.add(contact)
            } while (cursor.moveToNext())
        }
        return list
    }
}