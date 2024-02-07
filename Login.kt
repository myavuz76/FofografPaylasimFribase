package com.example.resimpaylasmafirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.resimpaylasmafirebase.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth= FirebaseAuth.getInstance()

        val kullanici = auth.currentUser

      //Hali hazirda kayitli kullanici var ise anasayfaya git

        if (kullanici !=null){
            val intent= Intent(this,anasayfa::class.java)
            startActivity(intent)
            finish()
        }


    }

    fun girisYap(view: View){

            val mail = binding.editTextEmailLogin.text.toString()
            val sifre = binding.editTextSifreLogin.text.toString()

            if (mail.isEmpty() && sifre.isEmpty()) {
                Toast.makeText(this, "Email ve Sifre Girmelisiniz", Toast.LENGTH_SHORT).show()

            } else {

                auth.signInWithEmailAndPassword(mail, sifre).addOnCompleteListener {
                    if (it.isSuccessful) {

                        val guncelKullanici = auth.currentUser?.email.toString()
                        Toast.makeText(this,"Hosgeldin ${guncelKullanici}",Toast.LENGTH_SHORT).show()

                        var intent = Intent(this, anasayfa::class.java)
                        startActivity(intent)
                        finish()
                    }
                }.addOnFailureListener {
                    Toast.makeText(this, it.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }

    fun buttonLoginKayit(view: View){

        var intent= Intent(this,kayit::class.java)
        startActivity(intent)
        finish()
    }
}
