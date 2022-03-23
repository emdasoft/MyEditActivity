package org.mcalc.editactivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import org.mcalc.editactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val adapter = CheckAdapter()
    private lateinit var binding: ActivityMainBinding
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK) {
                adapter.addCheck(it.data?.getSerializableExtra("check") as Check)
            }
        }
    }

    private fun init(){
        binding.apply {
            rView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rView.adapter = adapter
            btnAddChek.setOnClickListener {
                editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
            }
        }
    }
}