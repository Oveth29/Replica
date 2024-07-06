package com.example.replicaroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.replicaroom.dao.DatabaseBuilder
import com.example.replicaroom.databinding.ActivityMainBinding
import com.example.replicaroom.entity.City
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        funMain()


    }

    private fun funMain() = runBlocking{
        val context = this@MainActivity
        val db = DatabaseBuilder.getInstance(context)

        val city1 = City(0, "Masaya", "Ciudad de las flores", 50000)
        val city2 = City(0, "Managua", "Capital de Nicaragua", 450000)
        val city3 = City(0, "Masaya", "La gran sultana", 8750)


        var listCities : List<City> = listOf(city1,city2,city3)

        val cityDao = db.cityDao()
        listCities.forEach{
            city -> cityDao.insert(city)
        }
    }
}