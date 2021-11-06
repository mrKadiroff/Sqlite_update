package com.example.psix

import android.content.Intent
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
        val uch = objec?.descripter
        val tort = objec?.sana
        binding.ismmm.text = "Movie name: ${birinchi}"
        binding.aktrisa.text = "Movie authors: ${ikkinchi}"
        binding.mol.text = "About movie: ${uch}"
        binding.son.text = "Date: ${tort}"
        binding.kinonomi.text = birinchi


        binding.clossew.setOnClickListener {
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