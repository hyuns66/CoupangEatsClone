package com.example.coupangeatsclone.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeatsclone.databinding.ItemHomeMainCategoryRvBinding

class MainCategoryRvAdapter : RecyclerView.Adapter<MainCategoryRvAdapter.ViewHolder>() {
    inner class ViewHolder (val binding : ItemHomeMainCategoryRvBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeMainCategoryRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 6
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