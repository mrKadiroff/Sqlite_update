package com.example.psix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.psix.databinding.ActivityMainBinding
import com.example.psix.databinding.ActivitySecondBinding
import com.example.psix.models.Contact


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.save.setOnClickListener {
            val name = binding.ism.text.toString()
            val phone = binding.telRaqam.text.toString()
            val descripter = binding.about.text.toString()
            val sanamjon = binding.date.text.toString()
            val contact = Contact(name,phone,descripter,sanamjon)

            if (name.isEmpty() || phone.isEmpty()){
                Toast.makeText(this,"Malumotni to'liq kiriting okajon",Toast.LENGTH_SHORT).show()
            }else {
                val intent = Intent(this, ThirdActivity::class.java)
                val bundle = Bundle()

                bundle.putParcelable("key", contact)
                intent.putExtra("Bundle", bundle)
                startActivity(intent)
                finish()
            }


        }

    }
}
