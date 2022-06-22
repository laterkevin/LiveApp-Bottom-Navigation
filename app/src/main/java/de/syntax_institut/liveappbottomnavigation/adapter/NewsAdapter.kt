package de.syntax_institut.liveappbottomnavigation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.liveappbottomnavigation.R
import de.syntax_institut.liveappbottomnavigation.data.datamodels.NewsArticle

class NewsAdapter(
    private val layout: Int,
    private val dataset: List<NewsArticle>,
    private val addArticleToBookmarks: (NewsArticle) -> Unit
) : RecyclerView.Adapter<NewsAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvLocation: TextView = itemView.findViewById(R.id.tvLocation)
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        val ivPicture: ImageView = itemView.findViewById(R.id.ivPicture)
        val btnBookmark: ImageButton = itemView.findViewById(R.id.btnBookmark)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)

        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.tvTitle.text = item.title
        holder.tvLocation.text = item.location
        holder.tvDate.text = item.date
        holder.ivPicture.setImageResource(item.imgResourceId)

        holder.btnBookmark.setOnClickListener {
            addArticleToBookmarks(item)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
