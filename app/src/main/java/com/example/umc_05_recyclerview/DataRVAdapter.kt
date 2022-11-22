package com.example.umc_05_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_05_recyclerview.databinding.ItemdataBinding

class DataRVAdapter(private val dataList: ArrayList<Data>):RecyclerView.Adapter<DataRVAdapter.DataViewHolder>() {

    //private val checkboxStatus = SparseBooleanArray()


    val roomDb= AppDatabase.getInstance(this)
    inner class DataViewHolder(private val viewBinding: ItemdataBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(data: Data) {
            viewBinding.tvTitle.text = data.title
            viewBinding.tvContent.text = data.content

//            viewBinding.checkboxUser.isChecked = checkboxStatus[adapterPosition]
//
//            viewBinding.checkboxUser.setOnClickListener {
//                if(!viewBinding.checkboxUser.isChecked)
//                    checkboxStatus.put(adapterPosition, false)
//                else
//                    checkboxStatus.put(adapterPosition, true)
//                notifyItemChanged(adapterPosition)
//            }

            viewBinding.btnRm.setOnClickListener {
                //roomDb!!.DataDao().delete(title)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemdataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder((viewBinding))
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}