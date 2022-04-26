package com.studying.imgurchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.studying.imgurchallenge.adapter.GalleryAdapter
import com.studying.imgurchallenge.databinding.ActivityGalleryBinding
import com.studying.imgurchallenge.model.CatsImagesResponse
import com.studying.imgurchallenge.viewmodel.GalleryViewModel
import com.studying.imgurchallenge.viewmodel.GalleryViewModelFactory

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGalleryBinding
    lateinit var viewModel: GalleryViewModel
    private val galleryList: MutableList<CatsImagesResponse> = mutableListOf()
    private val mAdapter = GalleryAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()

        viewModel = ViewModelProvider(this, GalleryViewModelFactory())[GalleryViewModel::class.java]
        setObservers()
    }

    private fun setUpRecyclerView() {
        val recyclerView = binding.galleryRecyclerView
        recyclerView.adapter = mAdapter
    }

    private fun setObservers(){
        viewModel.catsImagesList.observe(this) {
            mAdapter.populateAdapter(mutableListOf(it))
        }

        viewModel.catsImagesListErrorResponse.observe(this){
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
        }
    }


}