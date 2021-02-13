package com.example.nytimes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimes.data.model.Article
import com.example.nytimes.databinding.ArticleItemBinding

/** Responsible to adapt data to the RecyclerView. ListAdapter will take care of track the list data
in order to check if something has changed. The ListAdapter uses DiffUtils to check what changed
when the list got updated.
It takes a clickListener for databinding to know where to call onClick().
We do not define the clicklistener here but inside the fragment. The fragment is responsible
to send the clicklistener to the adapter.
 */
class ArticleAdapter(val clickListener: ArticleClickListener) :
    ListAdapter<Article, ArticleAdapter.ViewHolder>(ArticleDiffCallback()) {

    // ViewHolder holds a view for the RecyclerView, describes to the RecyclerView when
    // and how display the item in the list. It is responsible for everything related to managing views.
    // It has a private constructor so other classes cannot create a new instance of the ViewHolder,
    // they can still use the from function to do it.
    class ViewHolder private constructor(val binding: ArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Article, clickListener: ArticleClickListener) {
            binding.article = item
            //Pass the clicklistener to the binding object
            binding.clickListener = clickListener
            //Evaluates the pending bindings, updating any Views that have expressions bound to
            //modified variables
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ArticleItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    // When the RecyclerView needs a new ViewHolder the adapter can call
    // from(parent) to create a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    // Called when the RecyclerView needs to show an item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        // Pass the clicklistener to the ViewHolder
        holder.bind(item, clickListener)
    }
}

// Used to calculate the minimum number of changes to make to produce the new list starting from the old list.
// It takes two lists and checks which are the differences
class ArticleDiffCallback : DiffUtil.ItemCallback<Article>() {
    // Check if two items have the same id
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.id == newItem.id
    }

    // Check if two items have the same content
    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}

// When the user clicks on the item the onClick method is triggered.
// If we have a database we could also send only the item id, since that is enough to retrieve the
// item from the database.
class ArticleClickListener(val clickListener: (article: Article) -> Unit) {
    fun onClick(article: Article) = clickListener(article)
}