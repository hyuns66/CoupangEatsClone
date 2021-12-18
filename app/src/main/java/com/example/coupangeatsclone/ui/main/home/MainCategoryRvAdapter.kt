package com.example.coupangeatsclone.ui.main.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coupangeatsclone.R
import com.example.coupangeatsclone.data.remote.restaurant.Category
import com.example.coupangeatsclone.databinding.ItemHomeMainCategoryRvBinding

class MainCategoryRvAdapter(private val context : Context, private val categoryList : ArrayList<Category>) : RecyclerView.Adapter<MainCategoryRvAdapter.ViewHolder>() {
    inner class ViewHolder (val binding : ItemHomeMainCategoryRvBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(category : Category){
            binding.itemHomeCategoryTv.text = category.categoryName
            if(category.iconImgUrl == ""){
                Glide.with(context).load(R.drawable.popular_restaurant).into(binding.itemHomeCategoryIv)
            } else {
                Glide.with(context).load(category.iconImgUrl).into(binding.itemHomeCategoryIv)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeMainCategoryRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}

//class LockerSavedAlbumRvAdapter(private val albumDatas : ArrayList<Album>) : RecyclerView.Adapter<LockerSavedAlbumRvAdapter.ViewHolder>() {
//
//    inner class ViewHolder(val binding: ItemLockerSavedAlbumRvBinding) : RecyclerView.ViewHolder(binding.root){
//        fun bind(albumData : Album){
//            binding.lockerSavedAlbumIv.setImageResource(albumData.coverImg!!)
//            binding.lockerSavedAlbumTitleTv.text = albumData.title
//            binding.lockersavedAlbumArtistTv.text = albumData.artist
//            binding.lockerSavedAlbumPublishInfoTv.text = albumData.albumInfo
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val binding = ItemLockerSavedAlbumRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(albumDatas[position])
//    }
//
//    override fun getItemCount(): Int {
//        return albumDatas.size
//    }
//}