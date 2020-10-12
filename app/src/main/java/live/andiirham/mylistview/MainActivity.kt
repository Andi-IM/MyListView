package live.andiirham.mylistview

import android.content.res.TypedArray
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var adapter : HeroAdapter
    private lateinit var dataName : Array<String>
    private lateinit var dataDescprition : Array<String>
    private lateinit var dataPhoto : TypedArray
    private var heroes = arrayListOf<Hero>()
//    private val dataName = arrayOf("Cut Nyak Dien", "Ki Hajar Dewantara", "Moh Yamin", "Patimura", "R A Kartini", "Sukarno")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView : ListView = findViewById(R.id.lv_list)
//        val adapter = ArrayAdapter<String>(this,
//        android.R.layout.simple_list_item_1, android.R.id.text1, dataName)
        adapter = HeroAdapter(this)
        listView.adapter = adapter
        prepare()
        addItem()
    }

    private fun prepare(){
        dataName = resources.getStringArray(R.array.data_name)
        dataDescprition = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        for (position in dataName.indices){
            val hero = Hero(
                    dataPhoto.getResourceId(position, -1),
                    dataName[position],
                    dataDescprition[position]
            )
            heroes.add(hero)
        }
        adapter.heroes = heroes
    }
}