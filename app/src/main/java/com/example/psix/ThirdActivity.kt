package com.example.psix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import com.example.psix.adapters.ContactAdapter

import com.example.psix.databinding.ActivityThirdBinding
import com.example.psix.databinding.ItemContactBinding
import com.example.psix.databinding.MyDialogBinding
import com.example.psix.db.MyDbHelper
import com.example.psix.models.Contact
import kotlinx.android.synthetic.main.activity_third.*
import kotlin.system.exitProcess


class ThirdActivity : AppCompatActivity() {
    lateinit var contactAdapter: ContactAdapter
    lateinit var myDbHelper: MyDbHelper
    lateinit var list: ArrayList<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setTitle(0)


        myDbHelper = MyDbHelper(this)

        list = myDbHelper.getAllContacts()
        contactAdapter = ContactAdapter(list, object:ContactAdapter.OnItemClickListener{
            override fun onItemContactClick(contact: Contact) {
                val intent = Intent(this@ThirdActivity,FourthActivity::class.java)
                val bundle = Bundle()

                bundle.putParcelable("key1", contact)
                intent.putExtra("Bundle", bundle)
                startActivity(intent)

            }

            override fun onItemClick(contact: Contact, position: Int, button: Button) {
                Toast.makeText(this@ThirdActivity,"Edit bosildi",Toast.LENGTH_SHORT).show()

                val intent = Intent(this@ThirdActivity,EditActivity::class.java)

                val bundle = Bundle()

                bundle.putParcelable("key2", contact)
                intent.putExtra("Bundle", bundle)
                startActivity(intent)


            }

            override fun onItemDelete(contact: Contact, position: Int, button: Button) {
                Toast.makeText(this@ThirdActivity,"Delete bosildi",Toast.LENGTH_SHORT).show()
                myDbHelper.deleteContact(contact)
                list.remove(contact)
                contactAdapter.notifyItemRemoved(list.size)
                contactAdapter.notifyItemRangeChanged(position, list.size)
            }

        })
        binding.rv.adapter = contactAdapter

        val bundle = intent.getBundleExtra("Bundle")
        val obje = bundle?.getParcelable<Contact>("key")

        val imya = obje?.name
        val mobil = obje?.phoneNumber
        val malum = obje?.descripter
        val dated = obje?.sana
        val contact = Contact(imya,mobil,malum,dated)

        myDbHelper.addContact(contact)
        list.add(contact)
        contactAdapter.notifyItemInserted(list.size)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId

        if (itemId == R.id.add){
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)

        }
        return false

    }

    override fun onBackPressed() {

        finishAffinity()
    }
}