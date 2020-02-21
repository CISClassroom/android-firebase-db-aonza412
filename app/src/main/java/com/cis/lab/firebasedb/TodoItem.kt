package com.cis.lab.firebasedb

class TodoItem{

    companion object Factory{
        fun create():TodoItem=TodoItem()
    }

    var objID:String?=null
    var todoName:String?=null
    var status:Boolean?=null
}