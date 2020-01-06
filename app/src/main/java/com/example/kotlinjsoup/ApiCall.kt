package com.example.kotlinjsoup

import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import kotlin.math.log

class ApiCall(recyclerView: RecyclerView) : AsyncTask<Void, Void, Document>() {
    val mrecyclerView: RecyclerView? = recyclerView
    override fun doInBackground(vararg params: Void?): Document? {
        val doc = Jsoup.connect("https://vn.investing.com/technical/indicators").data("period", "60").post()
        return doc
    }


    override fun onPostExecute(result: Document?) {
        super.onPostExecute(result)
        var list = mutableListOf<Currency>()
        for (i in 1..8) {
            var cur = Currency()
            cur.name =result?.getElementsByClass("h3LikeTitle")?.get(i-1)?.text().toString()
            cur.indiName =result?.select(".technicalIndicatorsTbl TD.symbol")?.get((i*12)-6)?.text().toString()
            cur.indiValue = result?.getElementsByClass("right")?.get((i*13)-7)?.text().toString()
            list.add(i-1,cur)

        }
        mrecyclerView?.adapter = CustomAdapter(list)
        mrecyclerView?.adapter!!.notifyDataSetChanged()
    }

}