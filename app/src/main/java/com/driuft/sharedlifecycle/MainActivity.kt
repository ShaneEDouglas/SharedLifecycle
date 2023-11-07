package com.driuft.sharedlifecycle

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var _sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _sharedPreferences = this.getSharedPreferences(this.packageName, MODE_PRIVATE)
        _sharedPreferences.registerOnSharedPreferenceChangeListener(listener)

        with (_sharedPreferences.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onCreate")
            apply()
        }

//        val currentState = _sharedPreferences.getString(
//            getString(R.string.current_lifecycle_state),
//            resources.getString(R.string.default_state)
//        ) ?: resources.getString(R.string.default_state)
//
//        Log.d("Lifecycle: ", currentState)
//        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()

        with(_sharedPreferences.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onStart")
            apply()
        }

//        val currentState = _sharedPreferences.getString(
//            getString(R.string.current_lifecycle_state),
//            resources.getString(R.string.default_state)
//        ) ?: resources.getString(R.string.default_state)
//
//        Log.d("Lifecycle: ", currentState)
//        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()

        with(_sharedPreferences.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onStart")
            apply()
        }

//        val currentState = _sharedPreferences.getString(
//            getString(R.string.current_lifecycle_state),
//            resources.getString(R.string.default_state)
//        ) ?: resources.getString(R.string.default_state)
//
//        Log.d("Lifecycle: ", currentState)
//        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()

        with(_sharedPreferences.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onPause")
            apply()
        }

//        val currentState = _sharedPreferences.getString(
//            getString(R.string.current_lifecycle_state),
//            resources.getString(R.string.default_state)
//        ) ?: resources.getString(R.string.default_state)
//
//        Log.d("Lifecycle: ", currentState)
//        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()

        with(_sharedPreferences.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onStop")
            apply()
        }

//        val currentState = _sharedPreferences.getString(
//            getString(R.string.current_lifecycle_state),
//            resources.getString(R.string.default_state)
//        ) ?: resources.getString(R.string.default_state)
//
//        Log.d("Lifecycle: ", currentState)
//        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()

        with(_sharedPreferences.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onRestart")
            apply()
        }

//        val currentState = _sharedPreferences.getString(
//            getString(R.string.current_lifecycle_state),
//            resources.getString(R.string.default_state)
//        ) ?: resources.getString(R.string.default_state)
//
//        Log.d("Lifecycle: ", currentState)
//        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        with(_sharedPreferences.edit()) {
            putString(getString(R.string.current_lifecycle_state), "onDestroy")
            apply()
        }
        unregisterListener()

//        val currentState = _sharedPreferences.getString(
//            getString(R.string.current_lifecycle_state),
//            resources.getString(R.string.default_state)
//        ) ?: resources.getString(R.string.default_state)
//
//        Log.d("Lifecycle: ", currentState)
//        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }

    private val listener =
        SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
            Toast.makeText(
                this,
                sharedPreferences.getString(
                    key,
                    resources.getString(R.string.default_state)
                ),
                Toast.LENGTH_SHORT
            ).show()
        }

    private fun unregisterListener() {
        _sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
    }
}
