package cat.montilivi.subasta

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    lateinit var btnPreuBase:Button
    lateinit var btnLicita:Button
    lateinit var btnResultat:Button
    lateinit var nomArticle:String
    lateinit var preuMinim:String

    var PersonesNom = ArrayList<String>()
    var PersonesQuantitat = ArrayList<String>()

    var venut:Boolean=false

    val getPreuBaseFormulari =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode== RESULT_OK)
            {
                val nomPrimerArticle = it.data!!.getStringExtra(PreuBase.NOM)
                val preuMinimArticle = it.data!!.getStringExtra(PreuBase.PREU)

                nomArticle= nomPrimerArticle.toString()
                preuMinim = preuMinimArticle.toString()

            }
        }

    val getLicitaFormulari =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK)
            {
                val nomLicita = it.data!!.getStringExtra(Licita.NOMLICITA)
                val quantLicita = it.data!!.getStringExtra(Licita.QUANTITATLICITA)



                PersonesNom.add(nomLicita.toString())
                PersonesQuantitat.add(quantLicita.toString())

            }
        }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPreuBase = findViewById(R.id.btnPreuBase)
        btnLicita = findViewById(R.id.btnLicita)
        btnResultat = findViewById(R.id.btnResultat)

        btnPreuBase.setOnClickListener {
            var intencio = Intent(this, PreuBase::class.java)
            getPreuBaseFormulari.launch(intencio)
            btnPreuBase.isClickable=false

        }

        btnLicita.setOnClickListener{
            venut=true
           var intencio = Intent(this,Licita::class.java)
            getLicitaFormulari.launch(intencio)

        }

        btnResultat.setOnClickListener {
            var intencio = Intent(this,Resultat::class.java)
            intencio.putExtra("Venut",venut)
            intencio.putExtra("Persones",PersonesNom)
            intencio.putExtra("Quantitats",PersonesQuantitat)
            intencio.putExtra("PreuMinim",preuMinim)
            startActivity(intencio)

        }

    }
}