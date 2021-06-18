package tw.edu.pu.o1083011.a20210616

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_draw.*
import kotlinx.android.synthetic.main.activity_draw.handv
import kotlinx.android.synthetic.main.activity_main.*

class DrawActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw)

        backbttn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                intent = Intent(this@DrawActivity, MainActivity::class.java)
                startActivity(intent)
            }
        })

        btn.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                handv.path.reset()
                handv.invalidate()
            }
        })
        handv.setOnTouchListener(object:View.OnTouchListener{
            override fun onTouch(p0: View?, event: MotionEvent): Boolean {
                var xPos = event.getX()
                var yPos = event.getY()
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> handv.path.moveTo(xPos, yPos)
                    MotionEvent.ACTION_MOVE -> handv.path.lineTo(xPos, yPos)
                    MotionEvent.ACTION_UP -> {
                        //將handv轉成Bitmap
                        val b = Bitmap.createBitmap(handv.measuredWidth, handv.measuredHeight,
                            Bitmap.Config.ARGB_8888)
                        val c = Canvas(b)
                        handv.draw(c)
                    }
                }
                handv.invalidate()
                return true
            }
        })
        object : CountDownTimer(30000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                timetext2.setText("倒數時間: " + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                timetext2.setText("時間到!")
                intent = Intent(this@DrawActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }.start()
    }
}