package com.example.adamregasz_rethy.parralaxviewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.Guideline
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = RVAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val manager = recyclerView!!.layoutManager as LinearLayoutManager
                val position = manager.findFirstVisibleItemPosition()
                val lastPosition = manager.findLastVisibleItemPosition()
                val offsetX = recyclerView.computeHorizontalScrollOffset()
                val width = recyclerView.width
                for (i in 0..lastPosition - position) {
                    val layout = manager.findViewByPosition(position + i) as? CardView ?: continue
                    val guideline = layout.findViewById<Guideline>(R.id.imageguideline)
                    val params = guideline.layoutParams as ConstraintLayout.LayoutParams
                    val delta = offsetX - ((position + i) * width)
                    var percent = delta / width.toFloat()
                    percent /= 2

                    params.guidePercent = 0.5f + percent
                    guideline.layoutParams = params
                }
            }
        })
    }
}
