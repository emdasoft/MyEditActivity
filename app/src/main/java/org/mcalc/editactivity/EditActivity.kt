package org.mcalc.editactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.mcalc.editactivity.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private var index = 0
    private val arrayId = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8
    )
    private var imageId = arrayId[0]
    private lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() = with(binding){
        btnNext.setOnClickListener {
            index++
            if(index > 7) index = 0
            imageId = arrayId[index]
            imView.setImageResource(imageId)
        }

        btnPrev.setOnClickListener {
            index--
            if(index < 0) index = 7
            if(index > 7) index = 0
            imageId = arrayId[index]
            imView.setImageResource(imageId)
        }

        btnDone.setOnClickListener {
            val check = Check(imageId, edName.text.toString(), edAmount.text.toString().toDouble(), "Some Description")
            val editIntent = Intent().apply {
                putExtra("check", check)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}