package kr.hs.dgsw.campus

import android.graphics.drawable.Drawable
import android.view.RoundedCorner
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

object BindingConversions {
    @BindingAdapter("imageUrl","error")
    @JvmStatic
    fun loadImage(imageView : ImageView, url : String, error : Drawable){

        Glide.with(imageView.context).load(url)
            .error(error)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(20)))
            .into(imageView)
    }

}