package kr.hs.dgsw.campus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kr.hs.dgsw.campus.databinding.ActivityFindIdBinding
import java.util.regex.Pattern

class FindIdActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityFindIdBinding
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
        when (p0) {
            binding.NextBtn -> {
                CheckJoin()
            }
            binding.PhoneCheckBtn -> {
                //폰 번호 인증
            }
            binding.MailCheckBtn -> {
                //인증 번호 확인
            }
        }
    }

    private fun CheckJoin() { //이거는 정규식이라서 설명할 게 없음
        if (!Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}\$",
                binding.PhoneET.text.toString())
        ) {
            binding.PhoneET.requestFocus()
            Toast.makeText(this, "올바른 핸드폰 번호가 아닙니다.", Toast.LENGTH_SHORT).show()
        } else if (false) {
            //TODO 인증번호 확인
        } else {
            //TODO 서버에 포스트...
            //TODO 올바르면 아이디 찾아주기...
            val intent = Intent(this, LoginActivity::class.java)
            finishAffinity()
            startActivity(intent)
        }
    }
}