package com.example.myintentapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.myintentapp.Person
class MainActivity4 : AppCompatActivity() {

    private lateinit var textObjectReceived:TextView

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        textObjectReceived = findViewById(R.id.getObjectReceived)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)

        }else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if (person != null) {
            val text = "Name : ${person.name.toString()} \n" +
                    "Email : ${person.email}\n" +
                    "Age : ${person.age}\n" +
                    "Location : ${person.city}"

            textObjectReceived.text = text
            Log.i("info",text)
        }
    }
}