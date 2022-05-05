package com.senalkaya.oyunproje

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.senalkaya.oyunproje.databinding.ActivityMainKayitOlBinding

class MainKayitOl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainKayitOlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKaydet.setOnClickListener {
            var kullaniciBilgisi=binding.kayitKullaniciAdi.text.toString()
            var kullaniciParola=binding.kayitParola.text.toString()
            var SharedPreferences=this.getSharedPreferences("bilgiler", MODE_PRIVATE)
            var editor=SharedPreferences.edit()
            //veri ekleme
            editor.putString("kullanici","${kullaniciBilgisi}").apply()
            editor.putString("parola","${kullaniciParola}").apply()
            Toast.makeText(applicationContext,"Kayıt Başarılı",Toast.LENGTH_LONG).show()
            binding.kayitKullaniciAdi.text.clear()
            binding.kayitParola.text.clear()

        }




        binding.btnGiriseDon.setOnClickListener {
            intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }




}