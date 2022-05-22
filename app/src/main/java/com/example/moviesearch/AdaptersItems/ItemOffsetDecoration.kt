package com.example.moviesearch.AdaptersItems

import android.content.Context
import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.R

class ItemOffsetDecoration(private val context: Context) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        val aSide = context.resources.getDimension(R.dimen.dp10).toInt()
        outRect.set(aSide,aSide,aSide,aSide)
    }
}