package com.example.retrofitinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitinkotlin.databinding.ActivityMainBinding
import com.facebook.shimmer.ShimmerFrameLayout
import retrofit2.HttpException
import java.io.IOException


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var container : ShimmerFrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        container = findViewById(R.id.shimmer_layout)
        container.startShimmer()

        lifecycleScope.launchWhenCreated {

            val response = try {
                RetrofitInstance.api.getTodos()
            } catch (e: IOException) {
                Log.e(TAG, "IOException, You might not have internet connection! ${e.message}")
                container.stopShimmer()
                container.setShimmer(null)
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, Unexpected Response!")
                container.stopShimmer()
                container.setShimmer(null)
                return@launchWhenCreated
            }

            if (response.isSuccessful && response.body() != null) {
                todoAdapter.todos = response.body()!!
            } else {
                Log.e(TAG, "Response Not successful!")
            }
            container.stopShimmer()
            container.setShimmer(null)
            container.visibility = View.GONE
        }
    }

    private fun setupRecyclerView() = binding.rvTodos.apply {
        todoAdapter = TodoAdapter()
        adapter = todoAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }
}