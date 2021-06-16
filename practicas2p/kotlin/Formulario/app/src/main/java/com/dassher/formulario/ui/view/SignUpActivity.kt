package com.dassher.formulario.ui.view

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dassher.formulario.R
import com.dassher.formulario.data.db.DaoUser
import com.dassher.formulario.databinding.ActivitySignUpBinding
import com.dassher.formulario.ui.viewmodel.User
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

class SignUpActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySignUpBinding

    private lateinit var name: TextInputEditText
    private lateinit var surname: TextInputEditText
    private lateinit var user: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var signup: MaterialButton
    private lateinit var haveaccount: MaterialTextView
    private lateinit var dao: DaoUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        name = findViewById<TextInputEditText>(R.id.titName)
        surname =  findViewById<TextInputEditText>(R.id.titSurname)
        user = findViewById<TextInputEditText>(R.id.titEmail)
        password = findViewById<TextInputEditText>(R.id.titPassword)

        signup = findViewById<MaterialButton>(R.id.mbSignUp)
        haveaccount = findViewById<MaterialTextView>(R.id.tvHaveAccount);

        signup.setOnClickListener(this)
        haveaccount.setOnClickListener(this)

        dao = DaoUser(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mbSignUp -> {
                val u = User()

                u.name = name.text.toString()
                u.surname = surname.text.toString()
                u.user = user.text.toString()
                u.password = password.text.toString()

                if(!u.isNull()) {
                    Toast.makeText(this, "Error: Campos vacíos", Toast.LENGTH_LONG).show()
                }else if (dao.insertUser(u)){
                    Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
                    finish()
                }else{
                    Toast.makeText(this,"El correo ya exite", Toast.LENGTH_LONG).show()
                }
            }
            R.id.tvHaveAccount -> {
                startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
                finish()
            }
        }
    }

}