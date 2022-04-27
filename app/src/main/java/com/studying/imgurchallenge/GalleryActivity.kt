package com.studying.imgurchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.studying.imgurchallenge.adapter.GalleryAdapter
import com.studying.imgurchallenge.databinding.ActivityGalleryBinding
import com.studying.imgurchallenge.model.MyModel
import com.studying.imgurchallenge.viewmodel.GalleryViewModel
import com.studying.imgurchallenge.viewmodel.GalleryViewModelFactory

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGalleryBinding
    lateinit var viewModel: GalleryViewModel
    private lateinit var mAdapter: GalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, GalleryViewModelFactory()).get(GalleryViewModel::class.java)
        setObservers()

        viewModel.getImages()

    }

    private fun setUpRecyclerView(list: List<MyModel>) {
        mAdapter = GalleryAdapter(list, this)
        binding.galleryRecyclerView.apply {
            adapter = mAdapter
            adapter?.notifyDataSetChanged()
            layoutManager = LinearLayoutManager(context)

        }
    }

    private fun setObservers() {
        viewModel.catsImagesList.observe(this, Observer {
            setUpRecyclerView(it)

        })

        viewModel.catsImagesListErrorResponse.observe(this) {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
        }
    }


}