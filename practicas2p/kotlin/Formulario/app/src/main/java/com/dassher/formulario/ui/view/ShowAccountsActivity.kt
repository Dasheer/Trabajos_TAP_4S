package com.dassher.formulario.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.dassher.formulario.R
import com.dassher.formulario.data.db.DaoUser
import com.dassher.formulario.databinding.ActivityShowAccountsBinding
import com.dassher.formulario.ui.viewmodel.User

class ShowAccountsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowAccountsBinding

    private lateinit var list: ListView
    private lateinit var daoUser: DaoUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowAccountsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = findViewById<ListView>(R.id.lvUsers)
        daoUser = DaoUser(this)

        val l: java.util.ArrayList<User> = daoUser.selectUsers()
        
        val lists: java.util.ArrayList<String> = java.util.ArrayList<String>()
        for (us in l) {
            lists.add(us.name + " " + us.surname)
        }

        val ada = ArrayAdapter<String> (this, android.R.layout.simple_expandable_list_item_1, lists)
        list.adapter = ada
    }
}