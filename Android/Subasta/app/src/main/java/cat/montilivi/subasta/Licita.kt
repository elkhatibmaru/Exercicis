package cat.montilivi.subasta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Licita : AppCompatActivity() {

    companion object{
        public const val NOMLICITA="nom"
        public const val QUANTITATLICITA="0"
    }

    lateinit var editTextNom:EditText
    lateinit var editTextQuantitat:EditText
    lateinit var btnTanca:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_licita)

        btnTanca = findViewById(R.id.btnTanca)
        editTextNom = findViewById(R.id.editText)
        editTextQuantitat = findViewById(R.id.editText2)

        btnTanca.setOnClickListener {
            intent.putExtra(NOMLICITA,editTextNom.text.toString())
            intent.putExtra(QUANTITATLICITA,editTextQuantitat.text.toString())
            setResult(RESULT_OK,intent)
            finish()
        }


    }
}