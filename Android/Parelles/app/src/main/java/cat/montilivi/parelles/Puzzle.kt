package cat.montilivi.parelles

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop
import org.w3c.dom.Text
import kotlin.random.Random


class Puzzle : AppCompatActivity() {


    var primerClick:TextView? = null
    var segonClick:TextView? = null
    var tercerClick:TextView?=null
    var numIntents:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {



        lateinit var tercerClick:Button
        lateinit var linearPuzzle:LinearLayout

        val abecedari = arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "U", "V", "W", "X", "Y", "Z")




        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puzzle)
        linearPuzzle = findViewById(R.id.linerPuzzle)

        var contador:Int=0
        var valor:Int = 0
        var nums:Int = 0
        var intent: Intent = this.intent
        var numeroPuzzle: Int = intent.getIntExtra("numero",0)

        if(numeroPuzzle==2)
        {
            nums=2
        }
        else if (numeroPuzzle==4){
            nums=8
        }
        else
        {
            nums=18
        }

        val parellesDeLletres: MutableList<TextView> = mutableListOf()
        val parellesDesordenades: MutableList<TextView> = mutableListOf()




        //region Creacio de la llista i desordenacio

        for(i in 1..nums)
        {
            var lletra:String = abecedari[Random.nextInt(1,25)]
            for(j in 1..2)
            {
                var textView:TextView = TextView(this)
                textView.textSize=25F
                textView.text=lletra

                parellesDeLletres.add(textView)
            }
        }

        while(parellesDeLletres.count()>0)
        {
            valor = Random.nextInt(0,parellesDeLletres.count())
            parellesDesordenades.add(parellesDeLletres[valor])
            parellesDeLletres.removeAt(valor)
        }

        //endregion


        //region Creacio de columnes
        for(i in 1..numeroPuzzle)
        {
            var columna:LinearLayout = LinearLayout(this)
            var params= LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,1F,)
            params.setMargins(2,2,2,2)

            columna.layoutParams=params
            columna.setVerticalGravity(Gravity.CENTER_VERTICAL)
            columna.orientation=LinearLayout.VERTICAL
            for(j in 1..numeroPuzzle)
            {

                var tv:TextView = parellesDesordenades[contador]
                tv.textSize=85f
                var txtParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
                txtParams.setMargins(0,2,0,2)
                tv.layoutParams=txtParams
                tv.setTextColor(Color.parseColor("#FF6200EE"))
                tv.setBackgroundColor(Color.parseColor("#FF6200EE"))
                tv.gravity=Gravity.CENTER
                tv.setOnClickListener {
                    comprobarSiSonIguals(tv)
                    title = "Intents:" +numIntents.toString()
                }
                if(tv.parent!=null)
                {
                    (tv.parent as ViewGroup).removeView(tv)
                }
                contador++
                columna.addView(tv)
            }
            linearPuzzle.addView(columna)
        }
        //endregion
    }

    private fun comprobarSiSonIguals(txtView:TextView) {
        if(primerClick==null)
        {
            numIntents++
            txtView.setTextColor(Color.WHITE)
            primerClick=txtView
        }
        else
        {
            if(segonClick==null)
            {
                txtView.setTextColor(Color.WHITE)
                segonClick=txtView
                numIntents++
                if(primerClick!!.text==segonClick!!.text)
                {
                    primerClick=null
                    segonClick=null
                }
            }
            else
            {
                numIntents++
                tercerClick=txtView

                if(segonClick!!.text!= primerClick!!.text)
                {
                    segonClick!!.setTextColor(Color.parseColor("#FF6200EE"))
                    primerClick!!.setTextColor(Color.parseColor("#FF6200EE"))
                    primerClick=null
                    segonClick=null
                }

            }





        }
    }


}