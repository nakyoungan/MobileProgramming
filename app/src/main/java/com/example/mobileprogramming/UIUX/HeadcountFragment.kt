package com.example.mobileprogramming.UIUX

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileprogramming.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HeadcountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HeadcountFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_headcount, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HeadcountFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HeadcountFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
        }
        override fun onStart() {
            super.onStart()
            initNumberPicker()
            numberPickerListener()
        }
        // 넘버 픽커 초기화
        private fun initNumberPicker(){
            val data1: Array<String> = Array(100){
                    i -> i.toString()
            }
            numberPicker.minValue = 0
            numberPicker.maxValue = 100
            numberPicker.wrapSelectorWheel = false
            numberPicker.displayedValues = data1
        }
        // 넘버 픽커 리스너
        private fun numberPickerListener(){
            numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
                Log.d("test", "oldVal : ${oldVal}, newVal : $newVal")
                Log.d("test", "picker.displayedValues ${picker.displayedValues[picker.value]}")
            }
        }
    }


}