package tw.edu.pu.o1083011.a20210616

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class HandPaint(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)  //畫筆(避免踞齒)

    init {
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE //描邊
        paint.strokeWidth = 10f  //設置畫筆寬度
        paint.strokeCap = Paint.Cap.ROUND //線帽(線條開始區域，筆觸端點)平滑
        paint.strokeJoin = Paint.Join.ROUND //連接處圓弧
    }
    var path : Path = Path() //繪圖軌跡

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.LTGRAY)  //背景
        canvas.drawPath(path, paint)

    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        var xPos = event.getX()
        var yPos = event.getY()
        when (event.action) {
            MotionEvent.ACTION_DOWN -> path.moveTo(xPos, yPos)
            MotionEvent.ACTION_MOVE -> path.lineTo(xPos, yPos)
        }
        invalidate()
        return true
    }
}

