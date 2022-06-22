package de.syntax_institut.liveappbottomnavigation.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import de.syntax_institut.liveappbottomnavigation.data.Repository
import de.syntax_institut.liveappbottomnavigation.data.datamodels.NewsArticle

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository(application)

    val newsArticles = repository.newsArticles
    val bookmarkedArticles = repository.bookmarkedArticles

    val addArticleToBookmarks: (NewsArticle) -> Unit = {
        repository.addArticleToBookmarks(it)
    }
}
