package com.example.psix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.psix.adapters.ContactAdapter
import com.example.psix.databinding.ActivityMainBinding
import com.example.psix.databinding.ActivitySecondBinding
import com.example.psix.db.MyDbHelper
import com.example.psix.models.Contact
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {
//    lateinit var contactAdapter: ContactAdapter
//    lateinit var myDbHelper: MyDbHelper
//    lateinit var list: ArrayList<Contact>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        myDbHelper = MyDbHelper(this)
//
//        list = myDbHelper.getAllContacts()


        binding.save.setOnClickListener {
            val name = binding.ism.text.toString().trim()
            val phone = binding.telRaqam.text.toString().trim()
            val descripter = binding.about.text.toString().trim()
            val sanamjon = binding.date.text.toString().trim()
            val contact = Contact(name,phone,descripter,sanamjon)

            if (name.isEmpty()){
                binding.ism.error = "Kinoning nomi kiritilmadi"
                binding.ism.requestFocus()
                return@setOnClickListener
            }

            if (phone.isEmpty()){
                binding.telRaqam.error = "Aktyorlarning nomi kiritilmadi"
                binding.telRaqam.requestFocus()
                return@setOnClickListener
            }

            if (descripter.isEmpty()){
                binding.about.error = "Kino haqida malumot kiritilmadi"
                binding.about.requestFocus()
                return@setOnClickListener
            }

            if (sanamjon.isEmpty()){
                binding.date.error = "Sana ma'lumotlari kiritilmadi"
                binding.date.requestFocus()
                return@setOnClickListener
            }


//            myDbHelper.addContact(contact)
//            list.add(contact)
//            contactAdapter.notifyItemInserted(list.size)

                val intent = Intent(this, ThirdActivity::class.java)
                val bundle = Bundle()

                bundle.putParcelable("key", contact)
                intent.putExtra("Bundle", bundle)
                startActivity(intent)
                finish()



        }

    }
//    override fun onBackPressed() {
//        val intent = Intent(this,ThirdActivity::class.java)
//        startActivity(intent)
//        finish()
//    }
}
