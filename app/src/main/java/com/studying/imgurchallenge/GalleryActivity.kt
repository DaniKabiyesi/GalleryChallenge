package com.studying.imgurchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Gallery
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.studying.imgurchallenge.adapter.GalleryAdapter
import com.studying.imgurchallenge.databinding.ActivityGalleryBinding
import com.studying.imgurchallenge.model.DataResponse
import com.studying.imgurchallenge.viewmodel.GalleryViewModel
import com.studying.imgurchallenge.viewmodel.GalleryViewModelFactory

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGalleryBinding
    lateinit var viewModel: GalleryViewModel
    private val galleryList: MutableList<DataResponse> = mutableListOf()
    private val mAdapter = GalleryAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
        val galleryViewModelFactory = GalleryViewModelFactory()

        viewModel = ViewModelProvider(this, galleryViewModelFactory).get(GalleryViewModel::class.java)
        viewModel.getImages()
        setObservers()
    }

    private fun setUpRecyclerView() {
        val recyclerView = binding.galleryRecyclerView
        recyclerView.adapter = mAdapter
    }

    private fun setObservers() {
        viewModel.catsImagesList.observe(this, Observer {
            mAdapter.populateAdapter(it)
        })

        viewModel.catsImagesListErrorResponse.observe(this) {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
        }
    }


}