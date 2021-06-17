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

private lateinit var auth: FirebaseAuth


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance();

        val auth = auth.currentUser



        login.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                intent = Intent(this@MainActivity, ChatActivity::class.java)
                startActivity(intent)




            }
        })

    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.getCurrentUser();
        updateUI(currentUser);
        //檢查
    }
    private fun signIn() {
        //開始登錄
        auth.signInAnonymously()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // 如果成功
                    Log.d(TAG, "匿名登錄成功！")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // 如果失敗了
                    Log.w(TAG, "匿名登錄失敗！ 請輸入名稱！", task.exception)
                    Toast.makeText(
                        baseContext, "登錄失敗",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }
            }
    }
    private fun updateUI(user: FirebaseUser?) {
    }
}