package com.example.cse226classwork
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), Custom.OnDeleteClickListener {

    private var dataModelList: ArrayList<DataModel>? = null
    private lateinit var listView: ListView
    private lateinit var adapter: Custom
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list_view_1)
        button=findViewById(R.id.btnshow)


        dataModelList = ArrayList()
        dataModelList!!.add(DataModel("Apple ", false))
        dataModelList!!.add(DataModel("Banana ", false))
        dataModelList!!.add(DataModel("Mango", false))
        dataModelList!!.add(DataModel("Orange", false))
        dataModelList!!.add(DataModel("Kiwi", false))
        dataModelList!!.add(DataModel("mango", false))
        dataModelList!!.add(DataModel("Apple ", false))
        dataModelList!!.add(DataModel("Banana ", false))



        adapter = Custom(dataModelList!!, applicationContext)
        adapter.setOnDeleteClickListener(this)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val dataModel: DataModel = dataModelList!![position]
            dataModel.checked = !dataModel.checked
            adapter.notifyDataSetChanged()
        }
        button.setOnClickListener {
            val selectedCount = dataModelList!!.count { it.checked }
            val message = "Number of selected items: $selectedCount"
            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDeleteClick(dataModel: DataModel) {
        adapter.remove(dataModel)
        Toast.makeText(applicationContext, "Item deleted", Toast.LENGTH_SHORT).show()
        button.isEnabled = adapter.count > 0 && adapter.dataSet.any { it.checked }
    }


}
