package kr.hs.dgsw.campus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import kr.hs.dgsw.campus.databinding.ActivityFindIdBinding

class FindIdActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityFindIdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_find_id)

        settingListener()
    }

    private fun settingListener() {
        binding.NextBtn.setOnClickListener(this)
        binding.PhoneCheckBtn.setOnClickListener(this)
        binding.MailCheckBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0){
            binding.NextBtn -> {
                val intent = Intent(this, LoginActivity::class.java)
                finishAffinity()
                startActivity(intent)
            }
            binding.PhoneCheckBtn -> {
                //폰 번호 인증
            }
            binding.MailCheckBtn -> {
                //인증 번호 확인
            }
        }
    }
}