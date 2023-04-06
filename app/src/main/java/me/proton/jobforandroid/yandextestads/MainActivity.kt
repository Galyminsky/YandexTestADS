package me.proton.jobforandroid.yandextestads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.banner.BannerAdEventListener
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData
import me.proton.jobforandroid.yandextestads.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.banner.setAdUnitId("demo-banner-yandex")
        // binding.banner.setAdSize(AdSize.stickySize(300))

        val adRequest = AdRequest.Builder().build()
        binding.banner.loadAd(adRequest)

        // Отслеживание ошибок
        binding.banner.setBannerAdEventListener(object : BannerAdEventListener{
            override fun onAdLoaded() {

            }

            override fun onAdFailedToLoad(erorr: AdRequestError) {
                Log.d("MyLog", "Yandex Ad Error: ${erorr.description}")
            }

            override fun onAdClicked() {

            }

            override fun onLeftApplication() {

            }

            override fun onReturnedToApplication() {

            }

            override fun onImpression(p0: ImpressionData?) {

            }

        })


    }
}