package co.joaoagapito.tutorial.jokerappdev.presentation

import co.joaoagapito.tutorial.jokerappdev.data.JokeCallback
import co.joaoagapito.tutorial.jokerappdev.data.JokeDayRemoteDataSource
import co.joaoagapito.tutorial.jokerappdev.data.JokeRemoteDataSource
import co.joaoagapito.tutorial.jokerappdev.model.Joke
import co.joaoagapito.tutorial.jokerappdev.view.JokeDayFragment

class JokeDayPresenter (
    private val view: JokeDayFragment,
    private val dataSource: JokeDayRemoteDataSource = JokeDayRemoteDataSource()
    ) : JokeCallback {

        fun findRandom (){
            view.showProgress()
            dataSource.findRandom(this)
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
