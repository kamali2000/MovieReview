package comb.nyp.sit.dit.it2107.moviereview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showCheckBox(v: View)
    {
        if (checkbox1.isChecked)
        {
            checkbox2.visibility = View.VISIBLE
            checkbox3.visibility = View.VISIBLE
            checkbox2.isChecked = true
            checkbox3.isChecked = true
        }
        else
        {
            checkbox2.visibility = View.INVISIBLE
            checkbox3.visibility = View.INVISIBLE
            checkbox2.isChecked = false
            checkbox3.isChecked = false
        }
    }
    fun btnClick(v: View)
    {
        //Validation

        var errorMsg = "Field empty"

        if (et_movie.text.toString() == "")
        {
            et_movie.setError(errorMsg)
        }
        if (et_description.text.toString() == "")
        {
            et_description.setError(errorMsg)
        }
        if (editTextRelDate.text.toString() == "")
        {
            editTextRelDate.setError(errorMsg)
        }
        showDetails()
    }
    private fun showDetails(){
        var name = et_movie.text
        var desc = et_description.text
        var date = editTextRelDate.text

        var selectedId = radioGroupLanguage.checkedRadioButtonId
        var radio: RadioButton = findViewById(selectedId)
        var language = radio.text
        var suitable = !checkbox1.isChecked
        var reason: String

        if (checkbox1.isChecked)
        {
            reason = checkbox2.text.toString() + "\n" + (checkbox3.text.substring(0, 8))
        } else
        {
            reason = "No mature content"
        }

        var toast = Toast.makeText(this, "Title = $name \nOverview = $desc \nRelease Date = $date \nLanguage = $language \nSuitable for all ages = $suitable \nReason: \n$reason", Toast.LENGTH_LONG)

        toast.show()
    }
}
