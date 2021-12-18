package com.example.coupangeatsclone.ui.main.home

import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class PopularRvItemDecoration : RecyclerView.ItemDecoration() {

    private var size20 = 0
    private var size10 = 0

    fun setSize(context: Context) {
        size20 = dpToPx(context, 20)
        size10 = dpToPx(context, 10)
    }

    // dp -> pixel 단위로 변경
    private fun dpToPx(context: Context, dp: Int): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics).toInt()
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val itemCount = state.itemCount

        if (position == 0){
            outRect.left = size20
            outRect.top = size10
            outRect.bottom = size10
        } else if (position == itemCount){
            outRect.right = size20
            outRect.left = size10
            outRect.top = size10
            outRect.bottom = size10
        } else {
            outRect.left = size10
            outRect.top = size10
            outRect.bottom = size10
        }
    }
}