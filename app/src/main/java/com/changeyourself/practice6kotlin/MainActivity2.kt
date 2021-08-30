package com.changeyourself.practice6kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    private val name: String? = null
    private val pasword: String? = null
    private var drink: String? = null
    private val builder = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val aza: Intent = intent
        if (aza.hasExtra("name") && aza.hasExtra("pasword")) {
            val name = aza.getStringExtra("name")
            val pasWord = aza.getStringExtra("pasword")
            textViewgreaatings.text = "Hello $name what whould you like"
        }


    }

    fun onCklickMakeOrder(view: android.view.View) {
      builder.setLength(0)
        if(checkboxlemon.isChecked){
            builder.append(getString(R.string.lemon)).append(" ")
        }
        if(checkboxsugar.isChecked){
            builder.append(getString(R.string.sugar)).append(" ")
        }
        if(checkboxmilk.isChecked){
            builder.append(getString(R.string.milk)).append(" ")
        }
      var optionalsofdrink=""
        optionalsofdrink = if(drink.equals(getString(R.string.tea))){
            spinnerOfDrink_tea.selectedItem.toString()
        }else{
           spinnerOfDrink_cofee.selectedItem.toString()
        }
        var oredr=String.format("Name $name\n Pasword $pasword\n Drink $drink Type of Drink $optionalsofdrink")
        val additions=if(builder.isNotEmpty()){
            "Additions of drink ${builder.toString()}"

        } else {
            " "
        }
        val totalOrder = "$oredr  $additions"
        val intent=Intent(this,MainActivity3::class.java)
        intent.putExtra("info",totalOrder)
        startActivity(intent)
    }

    fun onCklickChangeDrink(view: android.view.View) {
      var radiobuton:RadioButton=view as RadioButton
        val id:Int=radiobuton.id
        if(id==R.id.radiobuttonTea){
          drink=getString(R.string.tea)
            spinnerOfDrink_tea.visibility = View.VISIBLE
            spinnerOfDrink_cofee.visibility=View.GONE
            checkboxlemon.visibility = View.VISIBLE
        }else if(id==R.id.radiobuttonCofee){
            drink=getString(R.string.coffea)
            spinnerOfDrink_cofee.visibility=View.VISIBLE
            spinnerOfDrink_tea.visibility = View.INVISIBLE
            checkboxlemon.visibility=View.INVISIBLE
        }
        TextviewWhatAddtoTea.text="What Add to your $drink"

    }
}