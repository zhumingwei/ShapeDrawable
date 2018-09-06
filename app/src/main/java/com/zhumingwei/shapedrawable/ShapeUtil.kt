package com.zhumingwei.shapedrawable

import android.graphics.Paint
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.graphics.drawable.shapes.Shape
import android.view.View

import java.util.Arrays

/**
 * @author zhumingwei
 * @date 2018/9/6 上午11:11
 * @email zdf312192599@163.com
 */
fun getShapeDrawable(color: Int, style: Paint.Style, radio: Float, strokeWidth: Int): ShapeDrawable {
    val shape = RoundRectShape(floatArrayOf(radio, radio, radio, radio, radio, radio, radio, radio), null, null)
    val shapeDrawable = ShapeDrawable(shape)
    shapeDrawable.paint.color = color
    shapeDrawable.paint.style = style
    shapeDrawable.paint.strokeWidth = strokeWidth.toFloat()
    return shapeDrawable
}

fun View.setShape(radio: Float, color: Int, strokeWidth: Int = 0, style: Paint.Style = Paint.Style.FILL) {
    background = getShapeDrawable(color,style,radio,strokeWidth)
}