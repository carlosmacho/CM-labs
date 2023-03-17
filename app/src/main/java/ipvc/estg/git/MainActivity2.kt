package ipvc.estg.git

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import ipvc.estg.git.MainActivity.Companion.PARAM1_NAME

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val message = intent.getStringExtra(MainActivity.PARAM1_NAME)
        findViewById<EditText>(R.id.et4).setText(message)
    }

    fun onClick2(view: View) {
        val edit = findViewById<EditText>(R.id.et4)
        val message = edit.text.toString()

        val replyIntent = Intent()
        if (TextUtils.isEmpty(message)){
            setResult(Activity.RESULT_CANCELED, replyIntent)
        } else {
            replyIntent.putExtra(PARAM1_NAME, message)
            setResult(Activity.RESULT_OK, replyIntent)
        }
        finish()
    }
}