package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

   private lateinit var btnMoveActivity:Button
   private lateinit var btnMoveData:Button
   private lateinit var btnMoveObject:Button
   private lateinit var btnDial:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = findViewById<Button>(R.id.btnMove_Activity)
        btnMoveActivity.setOnClickListener(this)
        btnMoveData  = findViewById<Button>(R.id.btnMoveActivity_Data)
        btnMoveData.setOnClickListener(this)
        btnMoveObject = findViewById(R.id.btnMoveActivityObject)
        btnMoveObject.setOnClickListener(this)
        btnDial = findViewById(R.id.btnDialNumber)
        btnDial.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnMove_Activity -> {
                val moveIntent = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(moveIntent)
            }
            R.id.btnMoveActivity_Data -> {
                val moveIntWithData = Intent(this@MainActivity, MainActivity3::class.java)
                moveIntWithData.putExtra(MainActivity3.EXTRA_NAME , "Dicoding Academy Salahudin")
                moveIntWithData.putExtra(MainActivity3.EXTRA_AGE, 20)
                startActivity(moveIntWithData)
            }
            R.id.btnMoveActivityObject -> {
                val person = Person (
                    "M Salahudin",
                    20,
                    "salahudin@gmail.com",
                    "Magelang"
                )

                val btnObjectMove = Intent(this@MainActivity, MainActivity4::class.java)
                btnObjectMove.putExtra(MainActivity4.EXTRA_PERSON , person)
                startActivity(btnObjectMove)
            }
            R.id.btnDialNumber -> {
                val phoneNumber = "087273812311"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}