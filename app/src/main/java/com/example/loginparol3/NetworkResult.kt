package com.example.loginparol3

sealed class NetworkResult<T>(
    val data:T?=null,
val meesage:String?=null
){
    class Success<T>(data: T?):NetworkResult<T>(data)
    class Error <T>(message:String?,data: T?=null):NetworkResult<T>(data,message)
    class Loading<T>():NetworkResult<T>()


}
