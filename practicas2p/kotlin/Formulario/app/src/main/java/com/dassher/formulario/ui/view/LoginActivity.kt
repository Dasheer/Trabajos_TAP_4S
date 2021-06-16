package com.dassher.formulario.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dassher.formulario.R
import com.dassher.formulario.data.db.DaoUser
import com.dassher.formulario.databinding.ActivityLoginBinding
import com.dassher.formulario.ui.viewmodel.User
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class LoginActivity : AppCompatActivity(), View.OnClickListener  {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var user: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var login: MaterialButton
    private lateinit var newuser: MaterialTextView
    private lateinit var dao: DaoUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = findViewById<TextInputEditText>(R.id.titEmailLogin)
        password = findViewById<TextInputEditText>(R.id.titPasswordLogin)
        login = findViewById<MaterialButton>(R.id.mbLogin)
        newuser = findViewById<MaterialTextView>(R.id.tvNewUser)
        login.setOnClickListener(this)
        newuser.setOnClickListener(this)
        dao = DaoUser(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mbLogin -> {
                val u: String = user.text.toString()
                val p: String = password.text.toString()

                if(u == "" && p == "") {
                    Toast.makeText(this, "Error: Campos vacíos", Toast.LENGTH_LONG).show()
                }else if (dao.login(u,p)==1){
                    val ux: User = dao.getUser(u,p)!!
                    Toast.makeText(this, "Datos correctos", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java).putExtra("Id", ux.id))
                    finish()
                }else{
                    Toast.makeText(this,"Correo y/o contreaseña incorrecta", Toast.LENGTH_LONG).show()
                }
            }
            R.id.tvNewUser -> {
                startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
                finish()
            }
        }
    }

}