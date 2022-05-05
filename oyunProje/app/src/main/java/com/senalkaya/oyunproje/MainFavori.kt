package com.senalkaya.oyunproje

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.senalkaya.oyunproje.databinding.ActivityMainFavoriBinding
import kotlinx.android.synthetic.main.activity_main_favori.*

class MainFavori : AppCompatActivity() {
    lateinit var binding: ActivityMainFavoriBinding
    lateinit var favList:ArrayList<FavGames>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainFavoriBinding.inflate(layoutInflater)
        setContentView(binding.root)
        favList=ArrayList()



        binding.btnCikis2.setOnClickListener{
            intent= Intent(applicationContext,Cikis::class.java)

            startActivity(intent)
        }
        binding.button3.setOnClickListener {
            intent= Intent(applicationContext,MainAnaSayfa::class.java)
            startActivity(intent)
        }

        val gelenMesaj=intent.getStringExtra("mesaj")
        val gelenMesaji=intent.getStringExtra("mesajiki")

        addFav(gelenMesaj.toString(),gelenMesaji.toString())
        favRecycler.layoutManager=LinearLayoutManager(this)
        favRecycler.addItemDecoration(DividerItemDecoration(this,1))
        favRecycler.adapter=FavAdapter(favList)

    }

    fun addFav(string: String,stringi: String){
      favList.add(FavGames("${string}","${stringi}"))
    }



}
