package org.mcalc.editactivity

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.mcalc.editactivity.databinding.CheckItemBinding

class CheckAdapter:RecyclerView.Adapter<CheckAdapter.CheckHolder>() {
    var arrayCheck = arrayListOf<Check>()

    class CheckHolder(item: View):RecyclerView.ViewHolder(item) {
        private val binding = CheckItemBinding.bind(item)
        fun bind(check: Check) = with(binding){
            imageView.setImageResource(check.imageId)
            tvName.text = check.name
            tvAmount.text = check.amount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.check_item, parent, false)
        return CheckHolder(view)
    }

    override fun onBindViewHolder(holder: CheckHolder, position: Int) {
        holder.bind(arrayCheck[position])
    }

    override fun getItemCount(): Int {
        return arrayCheck.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addCheck(check: Check){
        arrayCheck.add(check)
        notifyDataSetChanged()
    }
}