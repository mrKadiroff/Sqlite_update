package com.example.psix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import com.example.psix.adapters.ContactAdapter
import com.example.psix.databinding.ActivityEditBinding
import com.example.psix.databinding.ActivityFourthBinding
import com.example.psix.db.MyDbHelper
import com.example.psix.models.Contact


class EditActivity : AppCompatActivity() {
    lateinit var contactAdapter: ContactAdapter
    lateinit var myDbHelper: MyDbHelper
    lateinit var list: ArrayList<Contact>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDbHelper = MyDbHelper(this)
        list = myDbHelper.getAllContacts()




        val bundle = intent.getBundleExtra("Bundle")
        val objecccc = bundle?.getParcelable<Contact>("key2")


        binding.oti.setText(objecccc?.name)
        binding.teefi.setText(objecccc?.phoneNumber)
        binding.haqidasi.setText(objecccc?.descripter)
        binding.datasi.setText(objecccc?.sana)

        binding.tahrirla.setOnClickListener {
            objecccc?.name = binding.oti.text.toString()
            objecccc?.phoneNumber = binding.teefi.text.toString()
            objecccc?.descripter = binding.haqidasi.text.toString()
            objecccc?.sana = binding.datasi.text.toString()
            myDbHelper.updateContact(objecccc!!)



            fun itemVr(contact: Contact, position: Int) {
                list[position] = objecccc
                contactAdapter.notifyItemChanged(position)
            }

            val intent = Intent(this,ThirdActivity::class.java)
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

