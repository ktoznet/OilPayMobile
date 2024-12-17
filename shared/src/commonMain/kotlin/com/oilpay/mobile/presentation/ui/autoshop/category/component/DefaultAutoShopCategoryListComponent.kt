import com.arkivanov.decompose.value.MutableValue
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.ui.autoshop.category.AutoShopCategory


class DefaultAutoShopCategoryListComponent(
    componentContext: AppComponentContext,
    private val id: Int,
    private val onCategorySelected: (Int) -> Unit
) : AutoShopCategoryListComponent, AppComponentContext by componentContext {


    private val _categories = MutableValue(
        listOf(
            AutoShopCategory(0, "", TITLE, DESC),
            AutoShopCategory(1, "", TITLE, DESC),
            AutoShopCategory(2, "", TITLE, DESC),
            AutoShopCategory(3, "", TITLE, DESC),
            AutoShopCategory(4, "", TITLE, DESC),
            AutoShopCategory(5, "", TITLE, DESC)
        )
    )

    override val categories: List<AutoShopCategory> get() = _categories.value

    override fun onCategorySelected(categoryId: Int) {
        onCategorySelected(categoryId)
    }
    companion object{
        const val TITLE = "Lorem Ipsum"
        const val DESC = "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
    }
}
