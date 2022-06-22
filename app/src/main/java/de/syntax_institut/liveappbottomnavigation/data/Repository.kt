package de.syntax_institut.liveappbottomnavigation.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.syntax_institut.liveappbottomnavigation.R
import de.syntax_institut.liveappbottomnavigation.data.datamodels.NewsArticle
/**
 * Hier werden die Daten für die App vorbereitet und verwaltet
 */
class Repository(private val context: Context) {

    // hier sind alle Artikel gespeichert
    private val _newsArticles = MutableLiveData<List<NewsArticle>>()
    val newsArticles: LiveData<List<NewsArticle>>
        get() = _newsArticles

    // hier sind alle Artikel mit Lesezeichen gespeichert
    private val _bookmarkedArticles = MutableLiveData<MutableList<NewsArticle>>()
    val bookmarkedArticles: LiveData<MutableList<NewsArticle>>
        get() = _bookmarkedArticles

    // hole zu Beginne alle Artikel mithilfe der Funktion loadNewsArticles()
    init {
        _newsArticles.value = loadNewsArticles()
    }

    /**
     * Eine Funktion um einen Artikel zu den Lesezeichen hinzuzufügen
     */
    fun addArticleToBookmarks(article: NewsArticle) {
        val bookmarks = _bookmarkedArticles.value
        val newList = mutableListOf(article)
        if (bookmarks != null) {
            newList.addAll(bookmarks.toTypedArray())
        }
        _bookmarkedArticles.value = newList
    }

    /**
     * Diese Funktion liefert eine Liste an NewsArticle Objekten zurück
     */
    private fun loadNewsArticles(): List<NewsArticle> {
        return listOf(
            NewsArticle(
                context.resources.getString(R.string.title1),
                R.drawable.raubtier,
                context.resources.getString(R.string.location1),
                context.resources.getString(R.string.date)
            ),
            NewsArticle(
                context.resources.getString(R.string.title2),
                R.drawable.ai,
                context.resources.getString(R.string.location2),
                context.resources.getString(R.string.date)
            ),
            NewsArticle(
                context.resources.getString(R.string.title3),
                R.drawable.hochhaus,
                context.resources.getString(R.string.location1),
                context.resources.getString(R.string.date)
            ),
            NewsArticle(
                context.resources.getString(R.string.title4),
                R.drawable.leo,
                context.resources.getString(R.string.location3),
                context.resources.getString(R.string.date)
            ),
            NewsArticle(
                context.resources.getString(R.string.title5),
                R.drawable.cast_away,
                context.resources.getString(R.string.location3),
                context.resources.getString(R.string.date)
            ),
            NewsArticle(
                context.resources.getString(R.string.title6),
                R.drawable.abnehmen,
                context.resources.getString(R.string.location2),
                context.resources.getString(R.string.date)
            )
        )
    }
}
