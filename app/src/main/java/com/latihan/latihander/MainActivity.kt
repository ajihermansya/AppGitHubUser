package com.latihan.latihander

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.latihan.latihander.adapter.RickAdapter
import com.latihan.latihander.databinding.ActivityMainBinding
import com.latihan.latihander.model.ResponseRick
import com.latihan.latihander.model.ResultsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rick = findViewById<RecyclerView>(R.id.rv_character)
        showLoading(true)

        ApiConfig.getService().getRick().enqueue(object : Callback<ResponseRick>{
            override fun onResponse(call : Call<ResponseRick>, response: Response<ResponseRick>) {
                if(response.isSuccessful) {
                    val responseRick = response.body()
                    val dataRick = responseRick?.results
                    val rickAdapter = RickAdapter(dataRick as List<ResultsItem>)
                    rick.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        rickAdapter.notifyDataSetChanged()
                        adapter = rickAdapter
                    }
                }
                showLoading(false)
        }
            override fun onFailure (call: Call<ResponseRick>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
                showLoading(true)
            }

        })
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}