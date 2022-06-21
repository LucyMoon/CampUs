package kr.hs.dgsw.campus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kr.hs.dgsw.campus.databinding.ActivityFindPwBinding
import java.util.regex.Pattern

class FindPwActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityFindPwBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_find_pw)

        settingListener()
    }

    private fun settingListener() {
        binding.NextBtn.setOnClickListener(this)
        binding.PhoneCheckBtn.setOnClickListener(this)
        binding.MailCheckBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0) {
            binding.NextBtn -> {
                CheckJoin()
            }
            binding.PhoneCheckBtn -> {
                //폰 번호 인증
            }
            binding.MailCheckBtn -> {
                //인증 번호 인증
            }
        }
    }

    private fun CheckJoin() { //이거는 정규식이라서 설명할 게 없음
        if (!Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9]).{5,15}.\$", binding.UserIdET.text.toString())) {
            binding.UserIdET.requestFocus()
            Toast.makeText(this, "아이디는 6~16자 문자와 숫자가 필수로 포함되어야합니다.", Toast.LENGTH_SHORT).show()
        } else if (!Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[\$@\$!%*#?&]).{7,15}.\$", binding.PwET.text.toString())) {
            binding.PwET.requestFocus()
            Toast.makeText(this, "비밀번호는 8~16자 문자와 숫자, 특수문자가 필수로 포함되어야합니다.", Toast.LENGTH_SHORT).show()
        }else if(binding.PwET.text.toString() != binding.RPwET.text.toString()){
            binding.RPwET.requestFocus()
            Toast.makeText(this, "비밀번호와 비밀번호 확인이 일치하지않습니다.", Toast.LENGTH_SHORT).show()
        } else if (!Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}\$", binding.PhoneET.text.toString())) {
            binding.PhoneET.requestFocus()
            Toast.makeText(this, "올바른 핸드폰 번호가 아닙니다.", Toast.LENGTH_SHORT).show()
        } else if(false){
            //TODO 인증번호 확인
        } else {
            //TODO 서버에 포스트...
            //TODO 올바르면 비밀번호 변경...
            val intent = Intent(this, LoginActivity::class.java)
            finishAffinity()
            startActivity(intent)
        }
    }
}