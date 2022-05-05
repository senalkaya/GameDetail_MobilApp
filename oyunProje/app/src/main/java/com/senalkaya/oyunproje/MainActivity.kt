package com.senalkaya.oyunproje

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.senalkaya.oyunproje.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

     lateinit var binding:ActivityMainBinding
     lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)







        preferences=getSharedPreferences("bilgiler", MODE_PRIVATE)

        binding.btnGirisYap.setOnClickListener{
            //kaydedilen veriler ->
            var kayitlikullanici=preferences.getString("kullanici"," ")
            var kayitliParola =preferences.getString("parola","")
            //girilen veriler ->
            var girisKullanici =binding.girisKullaniciAdi.text.toString()
            var girisParola =binding.girisParola.text.toString()
            if((kayitlikullanici==girisKullanici) && (kayitliParola==girisParola)){
                intent= Intent(applicationContext,MainAnaSayfa::class.java)
                startActivity(intent)
            }
           else{
               Toast.makeText(applicationContext,"Kullanıcı adı ve ya parola hatalı!",Toast.LENGTH_LONG).show()

            }
        }


        binding.btnKayitOl.setOnClickListener{
            intent= Intent(applicationContext,MainKayitOl::class.java)

            startActivity(intent)
        }






    }














}