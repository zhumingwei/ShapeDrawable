package com.zhumingwei.shapedrawable

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

/**
 * @author zhumingwei
 * @date 2018/9/10 下午8:46
 * @email zdf312192599@163.com
 */
class ShapeFrameLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var radius: Float = 0.0f
    var strokeWidth: Float = 0f
    var color: Int = 0
    var needshadow: Boolean = false
        set(value) {
            field = value
            invalidate()
        }
    var shadowLength: Float = UIUtil.dip2px(context, 2f).toFloat()
    var shadowRadio: Float = UIUtil.dip2px(context, 8f).toFloat()
    var shadowColor: Int = 0x22999999
    var sfl_paddingtop: Int = 0
    var sfl_paddingleft: Int = 0
    var sfl_paddingright: Int = 0
    var sfl_paddingbottom: Int = 0

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ShapeFrameLayout)
        radius = typedArray.getDimension(R.styleable.ShapeFrameLayout_sfl_radius, 0f)
        color = typedArray.getColor(R.styleable.ShapeFrameLayout_sfl_color, Color.parseColor("#00000000"))
        shadowColor = typedArray.getColor(R.styleable.ShapeFrameLayout_sfl_shadowColor, 0x22999999.toInt())
        strokeWidth = typedArray.getDimension(R.styleable.ShapeFrameLayout_sfl_strokeWidth, 0f)

        needshadow = typedArray.getBoolean(R.styleable.ShapeFrameLayout_sfl_shadow, false)
        shadowLength = typedArray.getDimension(R.styleable.ShapeFrameLayout_sfl_shadowLength, UIUtil.dip2px(context, 2f).toFloat())
        shadowRadio = typedArray.getDimension(R.styleable.ShapeFrameLayout_sfl_strokeWidth, UIUtil.dip2px(context, 8f).toFloat())
        sfl_paddingtop = typedArray.getDimension(R.styleable.ShapeFrameLayout_sfl_paddingtop, getDefaultOffset()).toInt()
        sfl_paddingleft = typedArray.getDimension(R.styleable.ShapeFrameLayout_sfl_paddingleft, getDefaultOffset()).toInt()
        sfl_paddingright = typedArray.getDimension(R.styleable.ShapeFrameLayout_sfl_paddingright, getDefaultOffset()).toInt()
        sfl_paddingbottom = typedArray.getDimension(R.styleable.ShapeFrameLayout_sfl_paddingbottom, getDefaultOffset()).toInt()

        typedArray.recycle()
        shape()

    }

    var bgD: Drawable? = null

    fun shape() {

        val shapeDrawable = getShapeDrawable(radius, color, strokeWidth)
        shapeDrawable.paint.color = color
        bgD = shapeDrawable
        if (needshadow) {
            setWillNotDraw(false)
            setLayerType(View.LAYER_TYPE_SOFTWARE, null)
            setPadding(sfl_paddingleft,sfl_paddingtop,  sfl_paddingright, sfl_paddingbottom)
        }
        invalidate()
    }

    private fun getDefaultOffset(): Float {
        return shadowLength + shadowRadio
    }


    override fun draw(canvas: Canvas) {

        var rect: RectF = RectF(sfl_paddingleft.toFloat(),sfl_paddingtop.toFloat(),  (width - sfl_paddingright).toFloat(), (height - sfl_paddingbottom).toFloat())

        var p: Paint = Paint()
        p.color = Color.TRANSPARENT
        p.setFilterBitmap(true);
        p.setDither(true);
        p.setAntiAlias(true)
        p.style = Paint.Style.FILL
        p.setShadowLayer(shadowRadio, 0f, shadowLength, shadowColor)
        canvas.drawRoundRect(rect, radius, radius, p)

        if (needshadow) {
            bgD?.setBounds(rect.left.toInt(), rect.top.toInt(), rect.right.toInt(), rect.bottom.toInt())
        }
        bgD?.draw(canvas)
        super.draw(canvas)
    }
}
