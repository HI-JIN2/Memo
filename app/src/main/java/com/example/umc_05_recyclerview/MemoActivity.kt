package com.example.umc_05_recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_05_recyclerview.databinding.ActivityMemoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemoActivity : AppCompatActivity() {
    private lateinit var viewbinding : ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)

        val editTitle = viewbinding.etTitle
        val editContent = viewbinding.etContent
        val roomDb=AppDatabase.getInstance(this)

        viewbinding.btnSave.setOnClickListener{
            // 메인화면에 리스트로 추가
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("title",editTitle.getText().toString())
            intent.putExtra("content",editContent.getText().toString())
            setResult(RESULT_OK,intent)
            startActivity(intent)
            finish()
        }
    }
}