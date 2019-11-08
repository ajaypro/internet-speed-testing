package com.oatrice.internet_speed_testing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.internet_speed_testing.ProgressionModel
import kotlinx.android.synthetic.main.view_item.view.*
import java.util.ArrayList

/**
 * Created by Ajay Deepak on 31-10-2019, 22:20
 */

class ProgressionAdapter(private val dataList: ArrayList<ProgressionModel>, private val context: MainActivity)
    : RecyclerView.Adapter<ProgressionAdapter.MyViewHolder>() {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder?.bind(dataList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.view_item, parent, false));
    }

    override fun getItemCount() = dataList.size

    fun setDataList(position: Int, data: ProgressionModel) {
        if (dataList.size <= position) {
            dataList.add(data)

        } else {
            dataList[position] = data
        }
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvProgress = itemView.tvProgress
        val tvDownload = itemView.tvDownload
        val tvUpload = itemView.tvUpload

        fun bind(progressionModel: ProgressionModel) {
            tvProgress.text = "${progressionModel.progressTotal}"
            tvDownload.text = "${progressionModel.downloadSpeed}"
            tvUpload.text = "${progressionModel.uploadSpeed}"
        }

    }


}

