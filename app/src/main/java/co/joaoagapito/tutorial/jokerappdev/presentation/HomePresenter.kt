package co.joaoagapito.tutorial.jokerappdev.presentation


import android.graphics.Color
import co.joaoagapito.tutorial.jokerappdev.data.CategoryRemoteDataSource
import co.joaoagapito.tutorial.jokerappdev.data.ListCategoryCallback
import co.joaoagapito.tutorial.jokerappdev.model.Category
import co.joaoagapito.tutorial.jokerappdev.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)

    }

    override fun onSuccess(response: List<String>) {
        val start = 40
        val end = 215
        val diff = (end - start) / response.size

        val categories = response.mapIndexed { index, s ->
            val hsv = floatArrayOf(
                start + (diff * index).toFloat(),
                35.0f,
                70.0f,
            )
            Category(s, Color.HSVToColor(hsv).toLong())
        }

        view.showCategories(categories)

    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }

}