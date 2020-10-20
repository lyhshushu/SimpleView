package com.example.simpleview.simpleview

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.lifecycle.LifecycleObserver
import com.example.simpleview.viewmodel.DimpleViewModel
import java.util.*
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin
import kotlin.properties.Delegates

/**
 * Project Name: SimpleView
 * File Name:    SimpleView.java
 * ClassName:    SimpleView
 *
 * Description: 波浪涟漪view控件
 *
 * @author  yh.liu
 * @date    2020年10月20日 9:36
 *
 * Copyright (c) 2020年, 4399 Network CO.ltd. All Rights Reserved.
 */
class DimpleView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var particleList = mutableListOf<Particle>()
    private var paint = Paint()

    private var centerX by Delegates.notNull<Float>()
    private var centerY by Delegates.notNull<Float>()
    private val random = Random()
    private var path = Path()
    private val pathMeasure = PathMeasure()
    private var pos = FloatArray(2)//点 x，y
    private val tan = FloatArray(2)//切线
    private var sendDimple = false


    private var animator = ValueAnimator.ofFloat(0f, 1f)

    init {
        animator.duration = 2000
        animator.repeatCount = -1
        animator.interpolator = LinearInterpolator()
        animator.addUpdateListener {
            updateParticle(it.animatedValue as Float)
            invalidate()
        }
    }

    private fun updateParticle(value: Float) {
        particleList.forEach {
            if (it.offset > it.maxOffset) {
                it.offset = 0
                it.speed = random.nextInt(2) + 2f
            }
            it.alpha = ((1f - (it.offset / it.maxOffset)) * 255f).toInt()
            it.x = (centerX + cos(it.angel) * (280f + it.offset)).toFloat()
            if (it.y > centerY) {
                it.y = (sin(it.angel) * (280f + it.offset) + centerY).toFloat()
            } else {
                it.y = (centerY - sin(it.angel) * (280f + it.offset)).toFloat()
            }
            it.offset += it.speed.toInt()

            if (sendDimple) {
                if (random.nextInt(4) == 1) {
                    it.offset = 0
                    it.speed = 4f
                }
            }
        }
        sendDimple = false
    }

    fun setSendDimple() {
        sendDimple = true
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = (w / 2).toFloat()
        centerY = (h / 2).toFloat()


        path.addCircle(centerX, centerY, 280f, Path.Direction.CCW)
        pathMeasure.setPath(path, false)
        var nextX = 0f
        var nextY = 0f
        var speed = 0f
        var offset = 0
        var maxOffset = 0
        var angel = 0.0
        for (i in 0..2000) {
            pathMeasure.getPosTan(i / 2000f * pathMeasure.length, pos, tan)
            nextX = pos[0] + random.nextInt(6) - 3f
            nextY = pos[1] + random.nextInt(6) - 3f
            speed = random.nextInt(2) + 2f
            angel = acos(((pos[0] - centerX) / 280f).toDouble())
            offset = random.nextInt(200)
            maxOffset = random.nextInt(300)

            particleList.add(
                Particle(
                    nextX,
                    nextY,
                    2f,
                    speed,
                    100,
                    offset,
                    angel,
                    maxOffset.toFloat()
                )
            )
        }
        animator.start()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.WHITE
        paint.isAntiAlias = true
        particleList.forEach {
            paint.alpha = it.alpha
            canvas.drawCircle(it.x, it.y, it.radius, paint)
        }
    }

    class Particle(
        var x: Float,
        var y: Float,
        var radius: Float,
        var speed: Float,
        var alpha: Int,
        var offset: Int,
        var angel: Double,
        var maxOffset: Float
    )
}