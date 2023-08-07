package com.example.cse226classwork
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), CustomAdapter.OnDeleteClickListener {

    private var dataModelList: ArrayList<DataModel>? = null
    private lateinit var listView: ListView
    private lateinit var adapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list_view_1)

        dataModelList = ArrayList()
        dataModelList!!.add(DataModel("Apple ", false))
        dataModelList!!.add(DataModel("Banana ", false))
        dataModelList!!.add(DataModel("Mango", false))
        dataModelList!!.add(DataModel("Orange", false))
        dataModelList!!.add(DataModel("Kiwi", false))
        dataModelList!!.add(DataModel("mango", false))
        dataModelList!!.add(DataModel("Apple ", false))
        dataModelList!!.add(DataModel("Banana ", false))

        // Add more items here...

        adapter = CustomAdapter(dataModelList!!, applicationContext)
        adapter.setOnDeleteClickListener(this)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val dataModel: DataModel = dataModelList!![position]
            dataModel.checked = !dataModel.checked
            adapter.notifyDataSetChanged()
        }
    }

    override fun onDeleteClick(dataModel: DataModel) {
        dataModelList?.remove(dataModel)
        adapter.notifyDataSetChanged()
        Toast.makeText(applicationContext,"item deleted",Toast.LENGTH_SHORT).show()

    }


}
