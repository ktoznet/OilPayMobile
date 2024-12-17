import com.oilpay.mobile.core.context.AppComponentContext
import com.oilpay.mobile.presentation.ui.autoshop.category.AutoShopCategory
import com.oilpay.mobile.presentation.components.decompose.DecomposeComponent

interface AutoShopCategoryListComponent : DecomposeComponent {
    val categories: List<AutoShopCategory>
    fun onCategorySelected(categoryId: Int)

    fun interface Factory {
        fun create(context: AppComponentContext, id: Int): AutoShopCategoryListComponent
    }
}
