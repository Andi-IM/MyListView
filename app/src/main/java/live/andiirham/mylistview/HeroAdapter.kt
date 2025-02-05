    package live.andiirham.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import live.andiirham.mylistview.Hero
import live.andiirham.mylistview.R

class HeroAdapter internal constructor(private val context: Context) : BaseAdapter(){
    internal var heroes = arrayListOf<Hero>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false)
        }

        var viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }
    override fun getItem(position: Int): Any = heroes[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getCount(): Int = heroes.size

    private inner class ViewHolder internal constructor(view: View){
        private val txtName : TextView = view.findViewById(R.id.txt_name)
        private val txtDescription : TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto : CircleImageView = view.findViewById(R.id.img_photo)

        internal fun bind(hero: Hero){
            txtName.text = hero.name
            txtDescription.text = hero.description
            imgPhoto.setImageResource(hero.photo)
        }
    }
}