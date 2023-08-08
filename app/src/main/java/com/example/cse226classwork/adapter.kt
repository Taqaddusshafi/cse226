package com.example.cse226classwork

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class Custom(val dataSet: ArrayList<DataModel>, mContext: Context) :
    ArrayAdapter<DataModel>(mContext, R.layout.listview, dataSet) {

    private class ViewHolder {
        lateinit var txtName: TextView
        lateinit var checkBox: CheckBox
        lateinit var button: Button
    }

    private var onDeleteClickListener: OnDeleteClickListener? = null

    fun setOnDeleteClickListener(listener: OnDeleteClickListener) {
        onDeleteClickListener = listener
    }

    override fun getCount(): Int {
        return dataSet.size
    }

    override fun getItem(position: Int): DataModel {
        return dataSet[position]
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        val viewHolder: ViewHolder
        val result: View
        if (convertView == null) {
            viewHolder = ViewHolder()
            convertView =
                LayoutInflater.from(parent.context).inflate(R.layout.listview, parent, false)
            viewHolder.txtName =
                convertView.findViewById(R.id.txtName)
            viewHolder.checkBox =
                convertView.findViewById(R.id.checkBox)
            viewHolder.button =
                convertView.findViewById(R.id.btn)
            result = convertView
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
            result = convertView
        }

        viewHolder.button.setOnClickListener {
            val item = getItem(position)
            onDeleteClickListener?.onDeleteClick(item)
        }

        val item: DataModel = getItem(position)
        viewHolder.txtName.text = item.name
        viewHolder.checkBox.isChecked = item.checked

        return result
    }

    interface OnDeleteClickListener {
        fun onDeleteClick(dataModel: DataModel)
    }
}
