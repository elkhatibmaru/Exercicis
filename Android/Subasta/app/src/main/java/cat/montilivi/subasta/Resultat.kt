package cat.montilivi.subasta

import android.app.Person
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.get
import org.w3c.dom.Text

class Resultat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        lateinit var ResultatNom:TextView
        lateinit var ResultatPreu:TextView
        lateinit var ResultatLinear:LinearLayout



        var intent: Intent = this.intent
        var articleVenut: Boolean? = intent.getBooleanExtra("Venut",false)
        var PersonesNomResultat: ArrayList<String>? = intent.getStringArrayListExtra("Persones")
        var PersonesQuantitatResultat: ArrayList<String>? = intent.getStringArrayListExtra("Quantitats")
        var PreuMinim:String? = intent.getStringExtra("PreuMinim")



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultat)


        ResultatNom = findViewById(R.id.txtResultatNom)
        ResultatPreu = findViewById(R.id.txtResultatPreu)
        ResultatLinear = findViewById(R.id.linearResultat)



        if(articleVenut==false)
        {
            ResultatNom.text = "No s'ha venut el producte"

            ResultatPreu.text = "Prova a fer una millor una oferta!!"
        }
        else
        {
            var i: Int = 0

            if (PersonesNomResultat != null) {
                for (item in PersonesNomResultat) {

                    var layoutLi:LinearLayout = LinearLayout(this)
                    var txtNom:TextView = TextView(this)
                    var txtQuantitat:TextView = TextView(this)

                    var params1 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT,1F)


                    txtNom.textSize= 25F
                    txtQuantitat.textSize= 25F
                    txtNom.setText(item.toString())
                    txtQuantitat.setText(PersonesQuantitatResultat?.get(i).toString())
                    txtNom.layoutParams=params1
                    txtQuantitat.gravity= Gravity.RIGHT
                    layoutLi.orientation = LinearLayout.HORIZONTAL
                    layoutLi.addView(txtNom)
                    layoutLi.addView(txtQuantitat)
                    i++
                    ResultatLinear.addView(layoutLi)

                }
            }

            if(PersonesQuantitatResultat!=null)
            {
                for(item in PersonesQuantitatResultat)
                {
                        if(PreuMinim!!.toInt()<item.toInt())
                        {
                            PreuMinim = item
                            ResultatNom.text = "L'article s'ha venut a "+PreuMinim
                            ResultatPreu.text ="Felicitats"
                        }

                    else
                        {
                            ResultatNom.text = "L'article no s'ha venut"
                            ResultatPreu.text = "Prova a fer una millor una oferta!!"
                        }

                }



            }





        }



    }
}