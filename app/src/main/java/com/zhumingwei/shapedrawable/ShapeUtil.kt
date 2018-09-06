package com.zhumingwei.shapedrawable

import android.graphics.RectF
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.view.View


/**
 * @author zhumingwei
 * @date 2018/9/6 上午11:11
 * @email zdf312192599@163.com
 */

fun View.setShape(radio: Float, color: Int, strokeWidth: Float = 0f) {

    val shape = if (strokeWidth == 0f) {
        RoundRectShape(floatArrayOf(radio, radio, radio, radio, radio, radio, radio, radio),
                null,
                null
        )
    } else {
        val ir = if (radio > strokeWidth) {
            radio - strokeWidth
        } else 0f
        RoundRectShape(floatArrayOf(radio, radio, radio, radio, radio, radio, radio, radio),
                RectF(strokeWidth, strokeWidth, strokeWidth, strokeWidth),
                floatArrayOf(ir, ir, ir, ir, ir, ir, ir, ir)
        )
    }
    val shapeDrawable = ShapeDrawable(shape)
    shapeDrawable.paint.color = color

    background = shapeDrawable
}