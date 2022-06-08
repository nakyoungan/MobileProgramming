package com.example.weplay

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.weplay.databinding.ActivityMapsBinding
import com.example.weplay.databinding.ActivitySportsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_headcount.*


class MapsActivity : AppCompatActivity() {
    lateinit var binding: ActivityMapsBinding
    lateinit var user: FirebaseUser
    lateinit var userList: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        initLayout()
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        val seoul = LatLng(37.566, 126.978)
        googleMap?.moveCamera(CameraUpdateFactory.newLatLng(seoul))
        googleMap?.moveCamera(CameraUpdateFactory.zoomTo(10f))
    }

    private fun initLayout() {
        user = Firebase.auth.currentUser!!
        userList = Firebase.database.getReference("Parties/party")
        val id = user.uid

        userList.child(id).get().addOnSuccessListener {
            binding.apply {

            }
        }


        binding.mapbtn.setOnClickListener {
            val pparticipantsNum = numberPicker.value
            finish()
        }
    }
}