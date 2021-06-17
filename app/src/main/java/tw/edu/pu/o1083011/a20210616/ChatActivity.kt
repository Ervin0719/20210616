package tw.edu.pu.o1083011.a20210616

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_draw.*
import kotlinx.android.synthetic.main.activity_main.*

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        Startbutton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                intent = Intent(this@ChatActivity, DrawActivity::class.java)
                startActivity(intent)
            }
        })

            backbtn.setOnClickListener(object :View.OnClickListener{
                override fun onClick(v: View?) {
                    finish()
                }
            })
    }
}