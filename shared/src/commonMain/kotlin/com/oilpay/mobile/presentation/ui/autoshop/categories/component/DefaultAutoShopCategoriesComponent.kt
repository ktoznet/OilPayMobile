
import com.oilpay.mobile.core.content.ComponentContent
import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.ui.autoshop.categories.AutoShopCategories
import com.oilpay.mobile.presentation.ui.autoshop.categories.AutoShopCategoriesScreen
import com.oilpay.mobile.presentation.ui.autoshop.categories.component.AutoShopCategoriesComponent

class DefaultAutoShopCategoriesComponent(
    componentContext: AppComponentContext,
    private val onCategorySelected: (Int) -> Unit,
    private val onBackNav: () -> Unit,
) : AutoShopCategoriesComponent, AppComponentContext by componentContext {
    override val content: ComponentContent = AutoShopCategoriesScreen(this)
    override val categories: List<AutoShopCategories> = listOf(
        AutoShopCategories(0, "", "Аксессуары для салона"),
        AutoShopCategories(1, "", "Шины"),
        AutoShopCategories(2, "", "Моющие Средства"),
        AutoShopCategories(3, "", "Масла"),
        AutoShopCategories(4, "", "Автоэлектроника"),
        AutoShopCategories(5, "", "Наружние аксессуары"),
        AutoShopCategories(6, "", "Инструменты для ремонта"),
        AutoShopCategories(7, "", "Товары для путешествия")
    )

    override fun onCategorySelected(categoryId: Int) {
        onCategorySelected(categoryId)
    }

    override fun onBack(){
        onBackNav()
    }


}
