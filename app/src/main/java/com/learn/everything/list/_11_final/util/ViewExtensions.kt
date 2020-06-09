import android.view.InflateException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View = try {
    LayoutInflater.from(context).inflate(layoutRes, this, false)
} catch (cause: InflateException) {
    val layout = context.resources.getResourceEntryName(layoutRes)
    throw InflateException("Error inflating layout $layout", cause)
}
