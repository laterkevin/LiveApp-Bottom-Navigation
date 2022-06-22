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

/**
 * Dieses Fragment verwaltet die Anzeige der Lesezeichen
 */
class BookmarksFragment : Fragment() {

    // Hier wird das ViewModel geholt
    private val viewModel: MainViewModel by activityViewModels()

    // hier wird die binding Variable deklariert
    private lateinit var binding: FragmentBookmarksBinding

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookmarksBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Die Lesezeichen Liste aus dem VieModel wird beobachtet und bei einer Änderung wird ein neuer
        // Adapter erzeugt
        viewModel.bookmarkedArticles.observe(
            viewLifecycleOwner
        ) {
            binding.recyclerView.adapter = NewsAdapter(R.layout.list_item_foryou, it, viewModel.addArticleToBookmarks)
        }
    }
}
