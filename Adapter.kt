package com.example.resimpaylasmafirebase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resimpaylasmafirebase.R
import com.example.resimpaylasmafirebase.model.post

class anasayfaRecyleViewAdapter(val postList : ArrayList<post>) : RecyclerView.Adapter<anasayfaRecyleViewAdapter.PostHolder>() {
    class PostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =inflater.inflate(R.layout.recycle_row,parent,false)
        return PostHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
       val kullaniciMail= holder.itemView.findViewById<TextView>(R.id.textViewKullaniciMailRecycleView)
        kullaniciMail.text= postList[position].kullaniciMail
        val kullaniciYorum = holder.itemView.findViewById<TextView>(R.id.textViewYorumRecycleView)
        kullaniciYorum.text= postList[position].kullaniciYorum

      val gorsel = holder.itemView.findViewById<ImageView>(R.id.imageViewRecycleView)

      //veritabanindaki resimleri görüntülemek icin bazi kütüphaneler var
        // 1. cisi picasso Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(imageView)
        //https://github.com/square/picasso sayfasindan gredle eklentisini ekliyoruz
        // implementation ("com.squareup.picasso:picasso:2.8")

        Picasso.get().load(postList[position].gorselUrl).into(gorsel)




    }
}




