package tw.edu.pu.o1083011.a20210616

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)


        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                intent = Intent(this@PlayerActivity, MainActivity::class.java)
                startActivity(intent)
            }
        })
        object : CountDownTimer(30000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                timetext.setText("倒數時間: " + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                timetext.setText("時間到!")
            }
        }.start()
    }
}