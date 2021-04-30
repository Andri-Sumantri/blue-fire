package com.example.blue_fire

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar!!.setTitle("Register Now")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val etFirstName      = findViewById<EditText>(R.id.firstName)
        val etLastName       = findViewById<EditText>(R.id.lastName)
        val etEmail          = findViewById<EditText>(R.id.Email)
        val etpassword       = findViewById<EditText>(R.id.password)
        val etComfirmPasword = findViewById<EditText>(R.id.comfirmPassword)
        val btnSignUp        = findViewById<Button>(R.id.signup)

        // handle button click
        btnSignUp.setOnClickListener {
            if (etFirstName.text.toString() == "") {
                Toast.makeText(this, "First name tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                etFirstName.setSelection(0)
                true
            }
            else if (etLastName.text.toString() == "") {
                Toast.makeText(this, "Last name tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                true
            }
            else if (etEmail.text.toString() == "") {
                Toast.makeText(this, "Email tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                true
            }
            else if (etpassword.text.toString() == "") {
                Toast.makeText(this, "Password name tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                true
            }
            else if (etpassword.text.toString() !=
            etComfirmPasword.text.toString()) {
                Toast.makeText(this, "Comfrim Password harus sama dengan password!", Toast.LENGTH_SHORT).show()
                true
            }
            else {
            // get text from edittexts
            val get_f_name      = etFirstName.text.toString()
            val get_l_name      = etLastName.text.toString()
            val getemail        = etEmail.text.toString()
            val getPassword     = etEmail.text.toString()
            val get_C_Password  = etComfirmPasword.text.toString()

            //intent to start activity
            val intent = Intent(applicationContext, Show_DataRegister::class.java)
            intent.putExtra("F_Name", get_f_name)
            intent.putExtra("L_Name", get_l_name)
            intent.putExtra("Email", getemail)
            intent.putExtra("Password", getPassword)
            intent.putExtra("C_Password", get_C_Password)
            startActivity(intent)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}