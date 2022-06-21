package kr.hs.dgsw.campus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import kr.hs.dgsw.campus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var bannerPosition = Int.MAX_VALUE / 2

    private val intervalTime = 5000.toLong()
    private var homeBannerHandler = BannerHandler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSuggestionRcv()
        setVp()

        binding.VPBanner.setCurrentItem(bannerPosition, false) //시작 위치 지정

        binding.RcvSuggestion.setOnTouchListener { _, _ ->
            binding.ScrollViewMain.requestDisallowInterceptTouchEvent(true)//부모 scroll 권한 빼는 부분)
            return@setOnTouchListener false
        }


        binding.VPBanner.apply {
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                //이 메서드의 state 값으로 뷰페이저의 상태를 알 수 있음
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    when (state) {
                        //뷰페이저가 움직이는 중일 때 자동 스크롤 멈춤 함수 호출
                        ViewPager2.SCROLL_STATE_DRAGGING -> {
                            autoScrollStop()
                        }
                        //뷰페이저에서 손 뗐을 때, 뷰페이저가 멈춰있을 때 자동 스크롤 시작 함수 호출
                        ViewPager2.SCROLL_STATE_IDLE -> {
                            autoScrollStart(intervalTime)
                        }
                    }
                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int,
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                    bannerPosition = position
                }
            })
        }

    }

    private fun setSuggestionRcv() {
        val suggestionAdapter = Suggestion_Adapter(this)
        binding.RcvSuggestion.adapter = suggestionAdapter
        binding.RcvSuggestion.layoutManager = GridLayoutManager(this, 2)
        suggestionAdapter.data = mutableListOf(
            Suggestion_Item("https://img7.yna.co.kr/etc/inner/KR/2020/03/13/AKR20200313159800805_02_i_P4.jpg", "캠핑장이름1", "34,000", "4.55"),
            Suggestion_Item("https://img.kr.news.samsung.com/kr/wp-content/uploads/2014/09/01102.jpg", "캠핑장이름2", "28,000", "4.50"),
            Suggestion_Item("https://post-phinf.pstatic.net/MjAyMDA3MDhfMjc1/MDAxNTk0MTczMjk3NTgx.HESbIHOx_nRR3cT1T29So3kiJ1CmYoZuI49Z9lF7Oj4g.JagQP2wpFGiKi5PyJOmMgbZo_nu-gg3oHV6Q3Nv5B34g.JPEG/%EC%97%B0%EA%B3%A1%EC%86%94%ED%96%A5%EA%B8%B0%EC%BA%A0%ED%95%91%EC%9E%A5_1.jpg?type=w1200", "캠핑장이름3", "42,000", "4.52"),
            Suggestion_Item("https://t1.daumcdn.net/cfile/tistory/994AFB3E5BC698E026", "캠핑장이름4", "37,000", "4.44"),
            Suggestion_Item("https://img7.yna.co.kr/etc/inner/KR/2020/03/13/AKR20200313159800805_02_i_P4.jpg", "캠핑장이름1", "34,000", "4.55"),
            Suggestion_Item("https://img.kr.news.samsung.com/kr/wp-content/uploads/2014/09/01102.jpg", "캠핑장이름2", "28,000", "4.50"),
            Suggestion_Item("https://post-phinf.pstatic.net/MjAyMDA3MDhfMjc1/MDAxNTk0MTczMjk3NTgx.HESbIHOx_nRR3cT1T29So3kiJ1CmYoZuI49Z9lF7Oj4g.JagQP2wpFGiKi5PyJOmMgbZo_nu-gg3oHV6Q3Nv5B34g.JPEG/%EC%97%B0%EA%B3%A1%EC%86%94%ED%96%A5%EA%B8%B0%EC%BA%A0%ED%95%91%EC%9E%A5_1.jpg?type=w1200", "캠핑장이름3", "42,000", "4.52"),
            Suggestion_Item("https://t1.daumcdn.net/cfile/tistory/994AFB3E5BC698E026", "캠핑장이름4", "37,000", "4.44"),
            Suggestion_Item("https://img7.yna.co.kr/etc/inner/KR/2020/03/13/AKR20200313159800805_02_i_P4.jpg", "캠핑장이름1", "34,000", "4.55"),
            Suggestion_Item("https://img.kr.news.samsung.com/kr/wp-content/uploads/2014/09/01102.jpg", "캠핑장이름2", "28,000", "4.50"),
            Suggestion_Item("https://post-phinf.pstatic.net/MjAyMDA3MDhfMjc1/MDAxNTk0MTczMjk3NTgx.HESbIHOx_nRR3cT1T29So3kiJ1CmYoZuI49Z9lF7Oj4g.JagQP2wpFGiKi5PyJOmMgbZo_nu-gg3oHV6Q3Nv5B34g.JPEG/%EC%97%B0%EA%B3%A1%EC%86%94%ED%96%A5%EA%B8%B0%EC%BA%A0%ED%95%91%EC%9E%A5_1.jpg?type=w1200", "캠핑장이름3", "42,000", "4.52"),
            Suggestion_Item("https://t1.daumcdn.net/cfile/tistory/994AFB3E5BC698E026", "캠핑장이름4", "37,000", "4.44"),

        )
        suggestionAdapter.notifyDataSetChanged()
    }

    private fun setVp() {
        val viewPagerAdapter = ViewPagerAdapter(this)
        binding.VPBanner.adapter = viewPagerAdapter // 어댑터 생성
        binding.VPBanner.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로
        viewPagerAdapter.data = listOf(
            BannerData("https://www.mangoboard.net/bbs/attachments/6824"),
            BannerData("https://www.mangoboard.net/bbs/attachments/6824"),
            BannerData("https://www.mangoboard.net/bbs/attachments/6824"),
            BannerData("https://www.mangoboard.net/bbs/attachments/6824"),
            BannerData("https://www.mangoboard.net/bbs/attachments/6824"),
            BannerData("https://www.mangoboard.net/bbs/attachments/6824"),
            BannerData("https://www.mangoboard.net/bbs/attachments/6824"),
            BannerData("https://www.mangoboard.net/bbs/attachments/6824"),
            BannerData("https://www.mangoboard.net/bbs/attachments/6824"),
            BannerData("https://www.mangoboard.net/bbs/attachments/6824")
        )
        viewPagerAdapter.notifyDataSetChanged()
    }

    //배너 자동 스크롤 시작하게 하는 함수
    private fun autoScrollStart(intervalTime: Long) {
        homeBannerHandler.removeMessages(0) //이거 안하면 핸들러가 여러개로 계속 늘어남
        homeBannerHandler.sendEmptyMessageDelayed(0, intervalTime) //intervalTime만큼 반복해서 핸들러를 실행
    }

    //배너 자동 스크롤 멈추게 하는 함수
    private fun autoScrollStop() {
        homeBannerHandler.removeMessages(0) //핸들러 중지
    }

    //배너 자동 스크롤 컨트롤하는 클래스
    private inner class BannerHandler : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 0) {
                binding.VPBanner.setCurrentItem(++bannerPosition, true) //다음 페이지로 이동
                autoScrollStart(intervalTime) //스크롤 킵고잉
            }
        }
    }

    //다른 화면으로 갔다가 돌아오면 배너 스크롤 다시 시작
    override fun onResume() {
        super.onResume()
        autoScrollStart(intervalTime)
    }

    //다른 화면을 보고 있는 동안에는 배너 스크롤 안함
    override fun onPause() {
        super.onPause()
        autoScrollStop()
    }
}