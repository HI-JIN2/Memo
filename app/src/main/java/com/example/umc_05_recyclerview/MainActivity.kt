package com.example.umc_05_recyclerview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_05_recyclerview.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewbinding: ActivityMainBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>

//
//    val sharedPrefs = getSharedPreferences("sharedprefs", Context.MODE_PRIVATE)
//    val editor = sharedPrefs.edit()

    var roomDb:AppDatabase?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)

        val roomDb= AppDatabase.getInstance(this)
        val list =roomDb?.DataDao()?.selectALL()

        val dataList: ArrayList<Data> = arrayListOf()
        val DataRVAdapter = DataRVAdapter(dataList)

        dataList.apply {
            add(Data("이거슨 제목", "이거슨 예시"))
            add(Data("이거슨 제목2", "이거슨 예시2"))
//            add(Data("${title}","${content}"))
        }

        getResultText = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val title = result.data?.getStringExtra("title")
                val content = result.data?.getStringExtra("content")

                dataList.apply {
                    add(Data(title.toString(), content.toString()))
                }
                DataRVAdapter.notifyDataSetChanged()

                //val roomDb = AppDatabase.getInstance(this)
                val user = Data("$title", "$content",0)
                if (roomDb != null) {
                    roomDb.DataDao().insert(user)
                    Log.d("db",user.title)
                }
            }
        }

        //메모작성으로 화면 전환
        val buttonWrite = viewbinding.btnWrite
        buttonWrite.setOnClickListener {
            val intent = Intent(this, MemoActivity::class.java)
            //startActivity(intent)
            getResultText.launch(intent)
        }
            viewbinding.rvData.adapter = DataRVAdapter
            viewbinding.rvData.layoutManager = LinearLayoutManager(this)

        val buttonBookmark = viewbinding.btnBookMark
        buttonBookmark.setOnClickListener {
            val intentb = Intent(this, BookmarkActivity::class.java)
            startActivity(intentb)
            //getResultText.launch(intent)

        }
    }
}