package com.senalkaya.oyunproje
import android.content.Intent
import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.senalkaya.oyunproje.Adapter.MyViewPagerAdapter
import com.senalkaya.oyunproje.R.layout.activity_main_ana_sayfa
import com.senalkaya.oyunproje.R.layout.layout_item_view
import com.senalkaya.oyunproje.databinding.ActivityMainAnaSayfaBinding
import com.senalkaya.oyunproje.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main_favori.*
import kotlinx.android.synthetic.main.activity_main_ana_sayfa.*
import java.util.*
import kotlin.collections.ArrayList


class MainAnaSayfa : AppCompatActivity(),OnGameItemClickListener {
    lateinit var binding: ActivityMainAnaSayfaBinding
    lateinit var gameList:ArrayList<Games>
    lateinit var displayList: ArrayList<Games>
    lateinit var heading:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding =ActivityMainAnaSayfaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user= arrayOf("Lords Of The Fallen","Dark Souls","Vindictus")
        var userAdapter:ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,user)

        super.onCreate(savedInstanceState)

        binding= DataBindingUtil.setContentView(this, activity_main_ana_sayfa)
        gameList=ArrayList()
        addGames()

        gameRecycler.layoutManager= LinearLayoutManager(this)
        gameRecycler.addItemDecoration(DividerItemDecoration(this,1))
        gameRecycler.adapter=GameAdapter(gameList,this)

       binding.btnCikis.setOnClickListener {
           intent= Intent(applicationContext,Cikis::class.java)
           startActivity(intent)
       }

       init()





     gameList= arrayListOf<Games>()
     displayList= arrayListOf<Games>()
        displayList.addAll(gameList)
    }


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_anasayfa_menu,menu)
        val item=menu?.findItem(R.id.search_action)
        val searchView =item?.actionView as SearchView
        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                displayList.clear()
                val searchText= newText!!.toString().lowercase(Locale.getDefault())
                if(searchText.isNotEmpty()){

                    gameList.forEach(){
                        if(it.toString().lowercase(Locale.getDefault()).contains(searchText)){
                            displayList.add(it)
                        }

                    }
                    gameRecycler.adapter?.notifyDataSetChanged()
                }else{
                    displayList.clear()
                    displayList.addAll(gameList)
                    gameRecycler.adapter!!.notifyDataSetChanged()
                }




                return false
            }

        })
        return super.onCreateOptionsMenu(menu)
    }


    fun addGames(){
        gameList.add(Games("Lords Of The Fallen","Lords of the Fallen is an action RPG, which is set in the fictional world abandoned by Gods and occupied by supernatural hostile power.",R.drawable.p11))
        gameList.add(Games("Dark Souls","Bone-rattling because of its complexity adventure in the Lordran, land of the ancient lords and endless mysteries. We are playing for a tacit prisoner, whose goal is to become human again.",R.drawable.p2))
        gameList.add(Games("Vindictus","Take control of a mighty mercenary and leap into the heart of one of the most action-packed MMORPG experiences available. ",R.drawable.p3))
        gameList.add(Games("Startfield","Starfield is the first new universe in 25 years from Bethesda Game Studios, the award-winning creators of The Elder Scrolls V: Skyrim and Fallout 4.",R.drawable.p4))
        gameList.add(Games("God of war","Unleash the power of the Gods and embark on a merciless quest as Kratos, an ex-Spartan warrior driven to destroy Ares, the God of War.",R.drawable.p5))
        gameList.add(Games("forspoken","Project Athia is the culmination of Luminous Productions’ philosophy to create a completely new and fresh gaming experiences that fuses together the latest technologies with art.",R.drawable.p6))
        gameList.add(Games("Aperature Desk Job","Aperture Desk Job reimagines the been-there-done-that genre of walking simulators and puts them in the lightning-spanked, endorphin-gorged world of sitting still behind things.",R.drawable.p7))
        gameList.add(Games("A Plague","A Plague Tale: Innocence, on PlayStation 4, Xbox One and PC, tells the grim story of two siblings fighting together for survival in the darkest hours of History. ",R.drawable.p8))
        gameList.add(Games("Somerville","A sci-fi action adventure that chronicles the lives of key individuals in the wake of a global catastrophe.",R.drawable.p9))
        gameList.add(Games("Replaced","REPLACED is a cinematic retro-futuristic action-thriller set in a dystopian alternative version the of the 80s' USA. You are R.E.A.C.H. - an AI trapped in mortal human body against it's will.",R.drawable.p10))



    }



    override fun onItemClick(item: Games, position: Int) {
       // Toast.makeText(this,item.name, Toast.LENGTH_SHORT).show()
        val intent = Intent(this,GameDetailsActivity::class.java)
        intent.putExtra("GAMENAME",item.name)
        intent.putExtra("GAMEDESC",item.descriptor)
        intent.putExtra("GAMELOGO",item.logo.toString())
        startActivity(intent)

    }

    private fun init(){
        view_pager.adapter= MyViewPagerAdapter(this@MainAnaSayfa)
        TabLayoutMediator(tabDots,view_pager, TabLayoutMediator.TabConfigurationStrategy({tab,position ->

        })).attach()
        view_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                //!BURAYA GERİ DÖN(NOT:parent_view ile ilgili)
                //Snackbar.make(parent_view,"you are selected"+(position+1),Snackbar.LENGTH_SHORT).show()

            }
        })

    }







}