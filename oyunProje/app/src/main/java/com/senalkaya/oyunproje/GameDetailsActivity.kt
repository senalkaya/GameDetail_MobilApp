package com.senalkaya.oyunproje

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.senalkaya.oyunproje.databinding.ActivityGameDetailsBinding
import kotlinx.android.synthetic.main.activity_game_details.*

class GameDetailsActivity : AppCompatActivity() {
    lateinit var binding:ActivityGameDetailsBinding
    lateinit var detailsList:ArrayList<String>
   lateinit var detailsList2:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= DataBindingUtil.setContentView(this,R.layout.activity_game_details)

        detailsList=ArrayList()
       detailsList2=ArrayList()

        game_name.text = getIntent().getStringExtra("GAMENAME")
        game_description.text = getIntent().getStringExtra("GAMEDESC")

        getIntent().getStringExtra("GAMELOGO")?.let { image_game.setImageResource(it.toInt()) }

        detailsList= arrayListOf<String>()
        detailsList2= arrayListOf<String>()
        var inde:Int=0
        binding.button.setOnClickListener{

            intent= Intent(applicationContext,MainFavori::class.java)
            val name=game_name.text.toString()
            val details=game_description.text.toString()

            detailsList.add(inde,""+name)
            detailsList2.add(inde,""+details)
            //println(name)
            //println(details)
            println(detailsList[(detailsList.size)-1])
            println(detailsList2[(detailsList2.size)-1])


            println(detailsList.size)
            println(detailsList2.size)

            intent.putExtra("mesaj",name)
            intent.putExtra("mesajiki",details)


             inde++
            startActivity(intent)
        }

    }
}