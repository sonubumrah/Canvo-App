package com.sonu.convo

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class HomeRecyclerAdapter(val context: Context,val itemList: ArrayList<Temp>):RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {
        class HomeViewHolder(view:View):RecyclerView.ViewHolder(view){
            var txtName:TextView=view.findViewById(R.id.Name)
            val linearayout:LinearLayout=view.findViewById(R.id.LinearLayout)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_item,parent,false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val temp:Temp=itemList[position]
        val id=temp.name
        holder.txtName.text= (temp.name)
        holder.txtName.setOnClickListener {
            when{
                holder.txtName.text=="C-->K"->{
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction().replace(R.id.FrameLayout,CK()).commit()

                }
                holder.txtName.text=="K-->C"->{
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction().replace(R.id.FrameLayout,KC()).commit()
                }
                holder.txtName.text=="C-->F"->{
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction().replace(R.id.FrameLayout,CF()).commit()
                }
                holder.txtName.text=="F-->C"->{
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction().replace(R.id.FrameLayout,FC()).commit()
                }
                holder.txtName.text=="K-->F"->{
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction().replace(R.id.FrameLayout,KF()).commit()
                }
                holder.txtName.text=="F-->K"->{
                    (context as AppCompatActivity).supportFragmentManager.beginTransaction().replace(R.id.FrameLayout,FK()).commit()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}