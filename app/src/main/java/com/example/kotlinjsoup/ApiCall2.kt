package com.example.kotlinjsoup

import android.content.Context
import android.os.AsyncTask
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import kotlin.math.log

class ApiCall2(textView: TextView) : AsyncTask<Void, Void, Document>() {
    val textView: TextView? = textView
    override fun doInBackground(vararg params: Void?): Document? {
        val doc = Jsoup.connect("https://vn.investing.com/currencies/eur-usd").get()
        return doc
    }


    override fun onPostExecute(result: Document?) {
        super.onPostExecute(result)

        textView?.setText(result?.select(".overViewBox .left .top SPAN:first-child")?.text().toString())

    }

}