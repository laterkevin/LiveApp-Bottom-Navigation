package de.syntax_institut.liveappbottomnavigation.ui.bookmarks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import de.syntax_institut.liveappbottomnavigation.R
import de.syntax_institut.liveappbottomnavigation.adapter.NewsAdapter
import de.syntax_institut.liveappbottomnavigation.databinding.FragmentBookmarksBinding
import de.syntax_institut.liveappbottomnavigation.ui.MainViewModel

class BookmarksFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentBookmarksBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookmarksBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.bookmarkedArticles.observe(
            viewLifecycleOwner
        ) {
            binding.recyclerView.adapter = NewsAdapter(R.layout.list_item_foryou, it, viewModel.addArticleToBookmarks)
        }
    }
}
