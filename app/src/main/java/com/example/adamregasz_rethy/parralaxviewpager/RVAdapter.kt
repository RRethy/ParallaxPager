package com.example.adamregasz_rethy.parralaxviewpager

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RVAdapter : RecyclerView.Adapter<RVAdapter.ImageVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageVH {
        return ImageVH(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_rv, parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ImageVH, position: Int) {
    }

    class ImageVH(val v: View) : RecyclerView.ViewHolder(v) {

    }
}