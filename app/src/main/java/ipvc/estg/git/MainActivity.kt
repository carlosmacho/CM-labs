package ipvc.estg.git

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val TAG = "MY_TAG"
    val ACT2_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")

        val sharedPref: SharedPreferences = getSharedPreferences(getString(R.string.preference_file_key),
            Context.MODE_PRIVATE)

        // Retrieve the sound value from the shared preferences and set the checkbox accordingly
        val tickedValue = sharedPref.getBoolean(getString(R.string.ticked), false)
        Log.d("****SHAREDPREF", "Read $tickedValue")

        if(tickedValue){
            findViewById<CheckBox>(R.id.checkbox1).isChecked = tickedValue
        }

        // adicionei o metodo A

        // add method B
        
        // john added method C

        // Carlos added method D
    }

    companion object {
        const val PARAM1_NAME = "param1"
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    fun onClick(view: View) {

        //val textView = findViewById<TextView>(R.id.tv1);

        val text1 = findViewById<EditText>(R.id.et1)
        val text2 = findViewById<EditText>(R.id.et2)
        val text3 = findViewById<EditText>(R.id.et3)

        var result = (text1.text.toString().toInt() + text2.text.toString().toInt()) * text3.text.toString().toInt();

        if(result > 30 && findViewById<CheckBox>(R.id.checkbox1).isChecked == false){
            Toast.makeText(
                applicationContext,
                "Resultado: $result",
                Toast.LENGTH_LONG
            ).show()
        }
        else if ( findViewById<CheckBox>(R.id.checkbox1).isChecked && result > 30 ){
            result *= 2
            Toast.makeText(
                applicationContext,
                "Resultado: $result",
                Toast.LENGTH_LONG
            ).show()
        }
        Log.d(TAG, "Resultado da conta: $result")

        //textView.setText("O resultado é $result")


//        val intent = Intent (this, MainActivity2::class.java)
//        intent.putExtra(PARAM1_NAME, findViewById<EditText>(R.id.et1).text.toString())
//        startActivityForResult(intent, ACT2_CODE)

    }

    fun onCheck(view: View) {
        if (view is CheckBox) {
            val sharedPref: SharedPreferences = getSharedPreferences(getString(R.string.preference_file_key),
                Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                putBoolean(getString(R.string.ticked), view.isChecked)
                commit()
            }
            Log.d("****SHAREDPREF", "Changed to ${view.isChecked}")

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ACT2_CODE && resultCode == Activity.RESULT_OK) {

            val msg = data?.getStringExtra(PARAM1_NAME)
            if (msg != null) {
                var teste = findViewById<EditText>(R.id.et1)
                teste.setText(msg)

            } else {

            }

        }

    }

}
