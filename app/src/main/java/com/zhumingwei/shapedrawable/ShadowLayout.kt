package com.zhumingwei.shapedrawable

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

/**
 * @author zhumingwei
 * @date 2018/9/30 下午2:49
 * @email zdf312192599@163.com
 */
class ShadowLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE,null)
        this.setWillNotDraw(false)
    }

    val dp_5:Float by lazy {
        UIUtil.dip2px(context, 5F).toFloat()
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var p: Paint = Paint()
        p.color = Color.WHITE
        p.setFilterBitmap(true);
        p.setDither(true);
        p.setAntiAlias(true)
        p.style = Paint.Style.FILL
        p.setShadowLayer(dp_5.toFloat(), 0f, dp_5.toFloat(), 0x77000000)
        canvas.drawRect(0f,0f, width.toFloat()-dp_5, (height ).toFloat()-dp_5, p)
    }
}
