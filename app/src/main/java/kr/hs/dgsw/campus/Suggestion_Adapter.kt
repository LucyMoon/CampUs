package kr.hs.dgsw.campus

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.campus.databinding.RcvSuggestionItemBinding

class Suggestion_Adapter(private val context: Context) : RecyclerView.Adapter<Suggestion_Adapter.ViewHolder>() {

    var data = listOf<Suggestion_Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RcvSuggestionItemBinding.inflate(
            LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    inner class ViewHolder(val binding: RcvSuggestionItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Suggestion_Item) {
            binding.item = data
            itemView.setOnClickListener {
                val intent = Intent(context, Detail_Suggestion::class.java).apply {
                    putExtra("data", data)
                }.run { context.startActivity(this) }
            }

        }
    }


}