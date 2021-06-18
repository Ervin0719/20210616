package tw.edu.pu.o1083011.a20210616

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
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

        btnLogOut.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                Firebase.auth.signOut()
                Toast.makeText(baseContext, "您已成功登出",
                    Toast.LENGTH_SHORT).show()

                finish()

            }
        })

    }
}