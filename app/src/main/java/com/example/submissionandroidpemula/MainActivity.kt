package com.example.submissionandroidpemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submissionandroidpemula.adapter.ListBolaAdapter
import com.example.submissionandroidpemula.data.BolaData
import com.example.submissionandroidpemula.model.Bola

class MainActivity : AppCompatActivity() {
    private lateinit var rvBola: RecyclerView
    private var list: ArrayList<Bola> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Home"

        rvBola = findViewById(R.id.rv_bola)
        rvBola.setHasFixedSize(true)

        list.addAll(BolaData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvBola.layoutManager = LinearLayoutManager(this)
        val listBolaAdapter = ListBolaAdapter(list)
        rvBola.adapter = listBolaAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val iAbout = Intent(this@MainActivity, about::class.java)
                startActivity(iAbout)
            }
        }
    }
}