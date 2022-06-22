package de.syntax_institut.liveappbottomnavigation.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import de.syntax_institut.liveappbottomnavigation.data.Repository
import de.syntax_institut.liveappbottomnavigation.data.datamodels.NewsArticle

/**
 * Das ViewModel verwaltet die Zustände der App
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

    // Erzeugt eine Repository Instanz
    private val repository = Repository(application)

    // Die Artikelliste und die Lesezeichenliste wird in einer Live Variablen gespeichert
    val newsArticles = repository.newsArticles
    val bookmarkedArticles = repository.bookmarkedArticles

    // Erstellt die benötigte Pfeilfunktion zum Hinzufügen neuer Artikel,
    // die dem Adapter übergeben wird
    val addArticleToBookmarks: (NewsArticle) -> Unit = {
        repository.addArticleToBookmarks(it)
    }
}
