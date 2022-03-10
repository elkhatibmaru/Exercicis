package cat.montilivi.parelles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var btnPerDos:Button
        lateinit var btnPerQuatre:Button
        lateinit var btnPerSis:Button

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnPerDos = findViewById(R.id.btnPerDos)
        btnPerQuatre = findViewById(R.id.btnPerQuatre)
        btnPerSis = findViewById(R.id.btnPerSis)


        btnPerDos.setOnClickListener{
            val intent = Intent(this,Puzzle::class.java)
            intent.putExtra("numero",2)
            startActivity(intent)
        }

        btnPerQuatre.setOnClickListener{
            val intent = Intent(this,Puzzle::class.java)
            intent.putExtra("numero",4)
            startActivity(intent)
        }

        btnPerSis.setOnClickListener{
            val intent = Intent(this,Puzzle::class.java)
            intent.putExtra("numero",6)
            startActivity(intent)
        }

    }
}