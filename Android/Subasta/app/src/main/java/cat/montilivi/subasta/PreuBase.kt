package cat.montilivi.subasta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class PreuBase : AppCompatActivity() {

    companion object{
        public const val NOM="nom"
        public const val PREU="0"
    }

    lateinit var btnEnviar:Button
    lateinit var txtNomArticle:EditText
    lateinit var txtPreuMinim:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preu_base)

        txtNomArticle = findViewById(R.id.txtNom)
        txtPreuMinim = findViewById(R.id.txtPreuBase)
        btnEnviar = findViewById(R.id.btnEnviar)

        btnEnviar.setOnClickListener {
            intent.putExtra(NOM,txtNomArticle.text.toString())
            intent.putExtra(PREU,txtPreuMinim.text.toString())
            setResult(RESULT_OK,intent)
            finish()
        }





    }
}