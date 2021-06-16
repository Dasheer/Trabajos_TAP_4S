package com.dassher.formulario.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dassher.formulario.R
import com.dassher.formulario.data.db.DaoUser
import com.dassher.formulario.databinding.ActivityEditAccountsBinding
import com.dassher.formulario.ui.viewmodel.User
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class EditAccountsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityEditAccountsBinding

    private lateinit var user: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var name: TextInputEditText
    private lateinit var surname: TextInputEditText

    private lateinit var save: MaterialButton
    private lateinit var cancel: MaterialButton

    private lateinit var dao: DaoUser
    private lateinit var us: User
    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditAccountsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = findViewById<TextInputEditText>(R.id.tietEmail)
        password = findViewById<TextInputEditText>(R.id.tietPassword)
        name = findViewById<TextInputEditText>(R.id.tietName)
        surname =  findViewById<TextInputEditText>(R.id.tietSurname)

        save = findViewById<MaterialButton>(R.id.mbSave)
        cancel = findViewById<MaterialButton>(R.id.mbCancel);

        save.setOnClickListener(this)
        cancel.setOnClickListener(this)

        val bundle: Bundle? = intent.extras
        id = bundle!!.getInt("Id")

        dao = DaoUser(this)
        us = dao.getUserById(id)!!

        name.setText(us.name)
        surname.setText(us.surname)
        user.setText(us.user)
        password.setText(us.password)
    }

    override fun onClick(v: View) {
        when(v.id){

            R.id.mbSave -> {
                us.user = user.text.toString()
                us.password = password.text.toString()
                us.name = name.text.toString()
                us.surname = surname.text.toString()

                if(!us.isNull()) {
                    Toast.makeText(this, "Error: Campos vacíos", Toast.LENGTH_LONG).show()
                }else if (dao.updateUser(us)){
                    Toast.makeText(this, "Actualización Exitosa", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@EditAccountsActivity, MainActivity::class.java).putExtra("Id", id))
                }else{
                    Toast.makeText(this,"Error al actualizar los datos", Toast.LENGTH_LONG).show()
                }
            }

            R.id.mbCancel -> {
                startActivity(Intent(this@EditAccountsActivity, MainActivity::class.java).putExtra("Id", id))
                finish()
            }
        }
    }
}