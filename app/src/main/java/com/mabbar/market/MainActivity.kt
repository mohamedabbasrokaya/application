package com.mabbar.market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.mabbar.market.adapter.NewsAdapter
import com.mabbar.market.api.ApiManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var progressBar: ProgressBar
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initviews()
        getnewssource()

    }
    val adapter=NewsAdapter(null)
    fun initviews(){
        progressBar=findViewById(R.id.progress_Bar)
        recyclerView=findViewById(R.id.recycle_view)
        recyclerView.adapter=adapter
    }



    private fun getnewssource() {
        ApiManager.getApi().getSources()
            .enqueue(object :Callback<ApiInterface>{
                override fun onResponse(
                    call: Call<ApiInterface>,
                    response: Response<ApiInterface>
                ) {
                    Log.e("data",response.body().toString())
                progressBar.isVisible=false
                    adapter.changeData(response.body()?.data)

                }

                override fun onFailure(call: Call<ApiInterface>, t: Throwable) {
                    Log.e("error",t.localizedMessage)
                    progressBar.isVisible=false

                }

            })
    }
}