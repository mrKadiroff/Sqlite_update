package com.example.psix

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import com.example.psix.adapters.ContactAdapter
import com.example.psix.databinding.ActivityMainBinding
import com.example.psix.databinding.MyDialogBinding
import com.example.psix.db.MyDbHelper
import com.example.psix.models.Contact

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




//        binding.next.setOnClickListener {
//            val intent = Intent(this@MainActivity, SecondActivity::class.java)
//            startActivity(intent)
//
//        }
//
//        binding.royhat.setOnClickListener {
//            val intent = Intent(this, ThirdActivity::class.java)
//            startActivity(intent)
//
//        }











    }


     }
