package kr.hs.dgsw.campus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import kr.hs.dgsw.campus.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        settingListener()
    }

    private fun settingListener() {
        binding.LoginBtn.setOnClickListener(this)
        binding.JoinBtn.setOnClickListener(this)
        binding.FindId.setOnClickListener(this)
        binding.FindPw.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.LoginBtn -> {
                val intent = Intent(this, MainActivity::class.java)
                finishAffinity()
                startActivity(intent)
            }
            binding.JoinBtn -> {
                val intent = Intent(this, JoinActivity::class.java)
                startActivity(intent)
            }
            binding.FindId -> {
                val intent = Intent(this, FindIdActivity::class.java)
                startActivity(intent)
            }
            binding.FindPw -> {

            }
        }
    }
}