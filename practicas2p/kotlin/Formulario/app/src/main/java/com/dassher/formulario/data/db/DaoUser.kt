package com.dassher.formulario.data.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.dassher.formulario.ui.viewmodel.User

class DaoUser (context: Context) {
    var user: User
    var list: java.util.ArrayList<User>
    var sqlite: SQLiteDatabase
    var db: String = "DBUsers"
    var table: String = "create table if not exists users(id integer primary key autoincrement, name text, surname text, user text, password text)"

    fun insertUser(users: User): Boolean {
        return if (search(users.user) == 0) {
            val cv = ContentValues()
            cv.put("name", users.name)
            cv.put("surname", users.surname)
            cv.put("user", users.user)
            cv.put("password", users.password)
            sqlite.insert("users", null, cv) > 0
        } else {
            false
        }
    }

    private fun search(user: String): Int {
        var x = 0
        list = selectUsers()
        for (us in list) {
            if (us.user == user) {
                x++
            }
        }
        return x
    }

    fun selectUsers(): java.util.ArrayList<User> {
        list.clear()
        val list = java.util.ArrayList<User>()
        val cr:Cursor = sqlite.rawQuery("select * from users", null)
        if (cr != null && cr.moveToFirst()) {
            do {
                val u = User()
                u.id = cr.getInt(0)
                u.name = cr.getString(1)
                u.surname = cr.getString(2)
                u.user = cr.getString(3)
                u.password = cr.getString(4)
                list.add(u)
            } while (cr.moveToNext())
        }
        return list
    }

    fun login(u: String, p: String): Int {
        var a = 0
        val cr:Cursor = sqlite.rawQuery("select * from users", null)
        if (cr != null && cr.moveToFirst()) {
            do {
                if (cr.getString(3) == u && cr.getString(4) == p) {
                    a++
                }
            } while (cr.moveToNext())
        }
        return a
    }

    fun getUser(u: String, p: String): User? {
        list = selectUsers()
        for (us in list) {
            if (us.user == u && us.password == p) {
                return us
            }
        }
        return null
    }

    fun getUserById(id: Int): User? {
        list = selectUsers()
        for (us in list) {
            if (us.id == id) {
                return us
            }
        }
        return null
    }

    init {
        sqlite = context.openOrCreateDatabase(db, Context.MODE_PRIVATE, null)
        sqlite.execSQL(table)
        user = User()
        list = java.util.ArrayList<User>()
    }

    fun updateUser(user: User): Boolean {
        val cv = ContentValues()
        cv.put("name", user.name)
        cv.put("surname", user.surname)
        cv.put("user", user.user)
        cv.put("password", user.password)
        return sqlite.update("users", cv, "id=" + user.id, null) > 0
    }

    fun deleteUser(id: Int): Boolean {
        return sqlite.delete("users", "id=$id", null) > 0
    }
}