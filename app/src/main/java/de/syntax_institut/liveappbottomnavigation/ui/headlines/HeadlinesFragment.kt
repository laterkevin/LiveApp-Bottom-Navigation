package de.syntax_institut.liveappbottomnavigation.ui.headlines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import de.syntax_institut.liveappbottomnavigation.R
import de.syntax_institut.liveappbottomnavigation.adapter.NewsAdapter
import de.syntax_institut.liveappbottomnavigation.databinding.FragmentHeadlinesBinding
import de.syntax_institut.liveappbottomnavigation.ui.MainViewModel

class HeadlinesFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentHeadlinesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeadlinesBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.newsArticles.observe(
            viewLifecycleOwner
        ) {
            binding.recyclerView.adapter = NewsAdapter(R.layout.list_item_news, it, viewModel.addArticleToBookmarks)
        }
    }
}
