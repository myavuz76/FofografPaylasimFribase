package com.example.resimpaylasmafirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.resimpaylasmafirebase.databinding.ActivityKayitBinding
import com.example.resimpaylasmafirebase.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class kayit : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;
    private lateinit var binding: ActivityKayitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKayitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
    }

    fun kayitOl(view: View) {

        val mail = binding.editTextKayitMail.text.toString()
        val sifre = binding.editTextKayitSifre.text.toString()

        if (mail.isEmpty() && sifre.isEmpty()) {
            Toast.makeText(this, "Email ve Sifre Girmelisiniz", Toast.LENGTH_SHORT).show()

        } else {

            auth.createUserWithEmailAndPassword(mail, sifre).addOnCompleteListener {
                if (it.isSuccessful) {
                    var intent = Intent(this, login::class.java)
                    startActivity(intent)
                    finish()
                }
            }.addOnFailureListener {
                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

}
