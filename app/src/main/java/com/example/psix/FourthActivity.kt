package com.example.psix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.psix.databinding.ActivityFourthBinding
import com.example.psix.db.MyDbHelper
import com.example.psix.models.Contact

class FourthActivity : AppCompatActivity() {
    lateinit var binding: ActivityFourthBinding
    lateinit var myDbHelper: MyDbHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDbHelper = MyDbHelper(this)

        val bundle = intent.getBundleExtra("Bundle")
        val objec = bundle?.getParcelable<Contact>("key1")

        val birinchi = objec?.name
        val ikkinchi = objec?.phoneNumber

        binding.ismmm.text = birinchi
        binding.aktrisa.text = ikkinchi





    }
}