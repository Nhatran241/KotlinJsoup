package com.example.kotlinjsoup

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learnkotlin.Data.API
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() , Callback<Repo> {
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewManager = LinearLayoutManager(this)
        rv.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
        }
         val Receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                ApiCall(rv).execute()
                ApiCall2(tv_eurusd).execute()
            }
        }
    val filter = IntentFilter()
    filter.addAction("android.intent.action.TIME_TICK")
    registerReceiver(Receiver,filter)
}

    override fun onFailure(call: Call<Repo>, t: Throwable) {
        Toast.makeText(this,t.toString(),Toast.LENGTH_LONG).show()
    }

    override fun onResponse(call: Call<Repo>, response: Response<Repo>) {
        tv_eurusd.setText(response.body()?.rates?.EURUSD?.rate.toString())
    }

}
