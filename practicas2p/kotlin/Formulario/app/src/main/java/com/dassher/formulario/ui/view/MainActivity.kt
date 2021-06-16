package com.dassher.formulario.ui.view

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatTextView
import com.dassher.formulario.R
import com.dassher.formulario.data.db.DaoUser
import com.dassher.formulario.databinding.ActivityMainBinding
import com.dassher.formulario.ui.viewmodel.User
import com.google.android.material.button.MaterialButton
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var edit: MaterialButton
    private lateinit var delete: MaterialButton
    private lateinit var show: MaterialButton
    private lateinit var exit: MaterialButton
    private lateinit var welcome: AppCompatTextView
    private lateinit var user: User
    private lateinit var daoUser: DaoUser
    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        edit = findViewById<MaterialButton>(R.id.mbEdit)
        delete = findViewById<MaterialButton>(R.id.mbDelete)
        show = findViewById<MaterialButton>(R.id.mbShow)
        exit = findViewById<MaterialButton>(R.id.mbExit)
        welcome = findViewById<AppCompatTextView>(R.id.atvWelcome)

        edit.setOnClickListener(this)
        delete.setOnClickListener(this)
        show.setOnClickListener(this)
        exit.setOnClickListener(this)

        val bundle: Bundle? = intent.extras
        id = bundle!!.getInt("Id")
        daoUser = DaoUser(this)
        user = daoUser.getUserById(id)!!

        welcome.text = user.name + " " + user.surname
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.mbEdit -> {
                startActivity(Intent(this@MainActivity, EditAccountsActivity::class.java).putExtra("Id", id))
                finish()
            }
            R.id.mbDelete -> {

                delete.setOnClickListener {
                    val builder = AlertDialog.Builder(this@MainActivity)
                    builder.setTitle("Eliminar Usuario")
                    builder.setMessage("¿Seguro quiere eliminar el usuario")
                    builder.setIcon(R.mipmap.ic_launcher)
                    builder.setPositiveButton("Sí") { dialog, id ->
                        if(daoUser.deleteUser(this.id)) {
                            Toast.makeText(this@MainActivity, "usuario eliminado", Toast.LENGTH_LONG).show()
                            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                            finish()
                        }
                    }
                    builder.setNegativeButton("No") { dialog, id ->
                        dialog.dismiss()
                        Toast.makeText(this@MainActivity, "cancelado", Toast.LENGTH_LONG).show()
                    }
                    builder.show()
                }
            }
            R.id.mbShow -> {
                startActivity(Intent(this@MainActivity, ShowAccountsActivity::class.java))
                finish()
            }
            R.id.mbExit -> {
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                finish()
            }
        }
    }
}