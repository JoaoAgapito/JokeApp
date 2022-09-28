package co.joaoagapito.tutorial.jokerappdev.presentation

import co.joaoagapito.tutorial.jokerappdev.data.JokeCallback
import co.joaoagapito.tutorial.jokerappdev.data.JokeRemoteDataSource
import co.joaoagapito.tutorial.jokerappdev.model.Joke
import co.joaoagapito.tutorial.jokerappdev.view.JokerFragment

class JokerPresenter(
    private val view: JokerFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallback {

    fun findBy(categoryName: String) {
        view.showProgress()
        dataSource.findBy(categoryName, this)
    }

    override fun onSuccess(response: Joke) {
        view.showJoker(response)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }

}
