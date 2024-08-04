package com.example.androidaletdialog

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidaletdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Toast.makeText(applicationContext, "Hoşgeldiniz", Toast.LENGTH_LONG).show()

        /*binding.button.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                println("butona tıklandı.")
            }

        })*/

    }

    fun kaydet(view: View) {
        val alert = AlertDialog.Builder(this@MainActivity)
        alert.setTitle("Kaydet")
        alert.setMessage("Kaydetmek istediğinize emin misiniz?")

        alert.setPositiveButton("Evet"){dialog, which ->
            Toast.makeText(this@MainActivity, "Kaydedildi!", Toast.LENGTH_LONG).show()
        }

        alert.setNegativeButton("Hayır", object: DialogInterface.OnClickListener{
            override fun onClick(p0: DialogInterface?, p1: Int) {
                Toast.makeText(this@MainActivity, "Kayıt iptal edildi!", Toast.LENGTH_LONG).show()
            }

        })

        alert.show()
    }

}