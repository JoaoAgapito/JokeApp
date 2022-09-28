package co.joaoagapito.tutorial.jokerappdev.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import co.joaoagapito.tutorial.jokerappdev.R
import co.joaoagapito.tutorial.jokerappdev.model.Joke
import co.joaoagapito.tutorial.jokerappdev.presentation.JokeDayPresenter
import com.squareup.picasso.Picasso

class JokeDayFragment : Fragment() {

    private lateinit var progressBar: ProgressBar
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView

    private lateinit var presenter: JokeDayPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = JokeDayPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.findViewById<Toolbar>(R.id.toolbar)?.title = getString(R.string.menu_joker_day)
        progressBar = view.findViewById(R.id.progess_bar)
        textView = view.findViewById(R.id.txt_joker)
        imageView = view.findViewById(R.id.img_joker)


        presenter.findRandom()

    }

    fun showJoker(joke: Joke) {
        textView.text = joke.text
        Picasso.get().load(joke.iconUrl).into(imageView)
    }

    fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    fun showFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}