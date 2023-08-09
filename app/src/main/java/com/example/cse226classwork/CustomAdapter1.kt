package com.example.cse226classwork
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter1(private var mList: MutableList<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter1.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.newdesignview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]

        holder.imageView.setImageResource(item.image)
        holder.textView.text = item.text

        holder.button.setOnClickListener {
            mList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, mList.size)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val button: ImageButton = itemView.findViewById(R.id.btndlt)

        init {
            textView.setOnClickListener {
                Toast.makeText(itemView.context, "${textView.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
