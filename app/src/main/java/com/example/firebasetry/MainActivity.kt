package com.example.firebasetry

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFirebaseRemoteConfig()

//        recyclerView.adapter = Adapter()
//
//        Firebase.database.reference.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                val value = dataSnapshot.value
////                val value = dataSnapshot.value as Map<*, *>?
//                Log.d("tag", "Value is: $value")
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // Failed to read value
//                Log.d("tag", "Failed to read value.", error.toException())
//            }
//        })
    }

    private fun initFirebaseRemoteConfig() {
        val remoteConfig = Firebase.remoteConfig
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
        remoteConfig.fetchAndActivate().addOnCompleteListener(this) { task ->
            val updated = task.result
            if (task.isSuccessful) {
                val updated = task.result
                Log.d("TAG", "Config params updated 1: ${updated}")
                Log.d("TAG", "Config params updated: ${remoteConfig.getBoolean("my_value")}")
            } else {
                Log.d("TAG", "Config - params updated 1: ${updated}")
                Log.d("TAG", "Config - params updated: ${remoteConfig.getBoolean("my_value")}")
            }
        }

    }
}