package com.example.cse226classwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.os.AsyncTask

class AsyncTask : AppCompatActivity() {
    private lateinit var  textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)
        textView = findViewById(R.id.textView)


        MyAsyncTask().execute(10)
    }

    private inner class MyAsyncTask : AsyncTask<Int, Void, String>() {

        override fun onPreExecute() {
            super.onPreExecute()
            textView.text = "Task is running..."
        }

        override fun doInBackground(vararg params: Int?): String {
            val input = params[0] ?: 0
            Thread.sleep(2000)
            return "Task completed with input: $input"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            textView.text = result
        }
    }
}
