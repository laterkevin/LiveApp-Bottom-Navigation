package de.syntax_institut.liveappbottomnavigation.ui.foryou

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import de.syntax_institut.liveappbottomnavigation.R
import de.syntax_institut.liveappbottomnavigation.adapter.NewsAdapter
import de.syntax_institut.liveappbottomnavigation.databinding.FragmentForyouBinding
import de.syntax_institut.liveappbottomnavigation.ui.MainViewModel

class ForYouFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentForyouBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForyouBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.newsArticles.observe(
            viewLifecycleOwner
        ) {
            binding.recyclerView.adapter = NewsAdapter(R.layout.list_item_foryou, it, viewModel.addArticleToBookmarks)
        }
    }
}
