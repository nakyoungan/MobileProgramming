package com.example.mywebview

import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.media.MediaPlayer
import com.example.mywebview.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private val jsonString = "{\"UserInfo\":{\"Name\":\"IU\",\"id\":\"test1\",\"pay\":20000000,\"address\":\"서울시....\"}}"

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            baseTextView.text = jsonString
            try{
                val userInfo = JSONObject(jsonString).getJSONObject("UserInfo")
                val userName = userInfo.getString("Name")
                val userId = userInfo.getString("id")
                val userPay = userInfo.getInt("pay")
                val userAddress = userInfo.getString("address")

                resultTextView.text = "이름:$userName\n식별코드:$userId\n"+
                        "연봉:$userPay\n" +
                        "주소:$userAddress"
                } catch (e: JSONException){
                    e.printStackTrace()
                }
    }
}