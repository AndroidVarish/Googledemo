package com.example.myfirebase

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myfirebase.databinding.ActivityHome2Binding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class HomeActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityHome2Binding
    private lateinit var firebaseAuth: FirebaseAuth
//    @SuppressLint("SuspiciousIndentation")
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHome2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth= FirebaseAuth.getInstance()
        val email=intent.getStringExtra("email")
        val names=intent.getStringExtra("name")


        val emails = intent.getStringExtra("email")
        val displayName = intent.getStringExtra("name")
        binding.apply {
         textView3.text= emails+"\n"+displayName
            button.setOnClickListener{
                val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build()

                val googlesigninclient = GoogleSignIn.getClient(this@HomeActivity2,gso)
                googlesigninclient.signOut()
                startActivity(Intent(this@HomeActivity2,MainActivity::class.java))
            }
        }

    }
}