package com.example.loginparol3

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.example.loginparol3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofit=RetrofitHelper.getRetrofit().create(NetworkApi::class.java)
        val factory=MainViewModelFactory(application,retrofit)
        val mainViewModel=ViewModelProvider(this,factory)[MainViewModel::class.java]

        binding.btnLogin.setOnClickListener {
            val login =binding.edLogin.text.toString()
            val password=binding.edParol.text.toString()
            mainViewModel.doLogin(login,password)
        }
mainViewModel.loginLiveData.observe(this){
    when (it){
        is NetworkResult.Error->{

        }
        is NetworkResult.Loading->{

        }
        is NetworkResult.Success->{
            Toast.makeText(this, it.data!!.data[0].toString(), Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,MainActivity2::class.java))
        }
    }
}




    }
}