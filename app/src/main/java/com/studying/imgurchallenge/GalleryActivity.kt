package com.studying.imgurchallenge

import android.icu.lang.UCharacter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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

        //ViewModel instantiated
        viewModel =
            ViewModelProvider(this, GalleryViewModelFactory()).get(GalleryViewModel::class.java)
        setObservers()

        viewModel.getImages()

    }

    private fun setUpRecyclerView(list: List<MyModel>) {
        //RecyclerView Configuration and SetUp
        mAdapter = GalleryAdapter(list, this)
        binding.galleryRecyclerView.apply {
            adapter = mAdapter
            adapter?.notifyDataSetChanged()
            layoutManager = StaggeredGridLayoutManager(4, VERTICAL)
        }
    }

    private fun setObservers() {
        //Method to observe api response succeed from ViewModel
        viewModel.catsImagesList.observe(this, Observer {
            setUpRecyclerView(it)

        })

        //Method to observe api response error from ViewModel
        viewModel.catsImagesListErrorResponse.observe(this) {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
        }
    }


}