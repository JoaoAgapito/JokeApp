package co.joaoagapito.tutorial.jokerappdev.data

import co.joaoagapito.tutorial.jokerappdev.model.Joke

interface JokeCallback {
    fun onSuccess(response: Joke)

    fun onError(response: String)

    fun onComplete()
}