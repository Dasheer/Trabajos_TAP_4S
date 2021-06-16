package com.dassher.formulario.ui.viewmodel

class User {
    var id: Int = 0

    var name: String = ""

    var surname: String = ""

    var user: String = ""

    var password: String = ""

    constructor() {}
    constructor(name: String, surname: String, user: String, password: String) {
        this.name = name
        this.surname = surname
        this.user = user
        this.password = password
    }

    fun isNull(): Boolean {
        return !(name == "" && surname == "" && user == "" && password == "")
    }

    override fun toString(): String {
        return "User(id=$id, name='$name', surname='$surname', user='$user', password='$password')"
    }


}