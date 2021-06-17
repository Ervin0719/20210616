package tw.edu.pu.o1083011.a20210616
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        login.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                intent = Intent(this@MainActivity, ChatActivity::class.java)
                startActivity(intent)
            }
        })

    }
}
