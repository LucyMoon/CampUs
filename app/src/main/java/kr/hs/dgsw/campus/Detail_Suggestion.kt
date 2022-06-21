package kr.hs.dgsw.campus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kr.hs.dgsw.campus.databinding.ActivityDetailSuggestionBinding

class Detail_Suggestion : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDetailSuggestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_suggestion)
        val data = intent.getSerializableExtra("data") as Suggestion_Item

        initsettings(data)
        settingListener()

        supportFragmentManager.beginTransaction()
            .replace(R.id.Map_Layout, MapsFragment())
            .commit()
    }

    private fun settingListener() {
        binding.BackBtn.setOnClickListener(this)
    }

    private fun initsettings(data : Suggestion_Item){
        binding.TitleText.text = data.Name
        binding.RateText.text = data.Rate
        binding.PriceText.text = data.Price
        Glide.with(this).load(data.Img)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(25)))
            .into(binding.MainPhoto)
        Glide.with(this).load("https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/advices/165172934505944494.jpg?gif=1&w=480")
            .apply(RequestOptions.bitmapTransform(RoundedCorners(25)))
            .into(binding.Photo1)
        Glide.with(this).load("https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/advices/165172934505944494.jpg?gif=1&w=480")
            .apply(RequestOptions.bitmapTransform(RoundedCorners(25)))
            .into(binding.Photo2)
        Glide.with(this).load("https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/advices/165172934505944494.jpg?gif=1&w=480")
            .apply(RequestOptions.bitmapTransform(RoundedCorners(25)))
            .into(binding.Photo3)
        Glide.with(this).load("https://image.ohou.se/i/bucketplace-v2-development/uploads/cards/advices/165172934505944494.jpg?gif=1&w=480")
            .apply(RequestOptions.bitmapTransform(RoundedCorners(25)))
            .into(binding.Photo4)
    }

    override fun onClick(p0: View?) {
        when(p0) {
            binding.BackBtn -> {
                finish()
            }
        }
    }
}