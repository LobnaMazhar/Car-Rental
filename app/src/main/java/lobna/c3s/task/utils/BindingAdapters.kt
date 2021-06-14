package lobna.c3s.task.utils

import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


object BindingAdapters {

    @JvmStatic
    @BindingAdapter("loadImage:src")
    fun loadImage(imageView: ImageView, src: String) {
        if (src.isNotBlank()) {
            val resource = imageView.context.resources.getIdentifier(
                src, "drawable", imageView.context.packageName
            )
            imageView.setImageResource(resource)
        }
    }

    @JvmStatic
    @BindingAdapter("loadImage:url")
    fun loadImageUrl(imageView: ImageView, url: String) {
        if (url.isNotBlank()) {
            Glide.with(imageView).load(url).centerCrop().into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("recycler:adapter")
    fun recyclerAdapter(
        recyclerView: RecyclerView,
        adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>
    ) {
        recyclerView.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("recycler:layoutManager")
    fun recyclerLayoutManager(
        recyclerView: RecyclerView, layoutManager: RecyclerView.LayoutManager
    ) {
        recyclerView.layoutManager = layoutManager
    }

    @JvmStatic
    @BindingAdapter("bind:onBackListener")
    fun onBackPressed(toolbar: Toolbar, lambda: () -> Unit) {
        toolbar.setNavigationOnClickListener {
            lambda.invoke()
        }
    }
}