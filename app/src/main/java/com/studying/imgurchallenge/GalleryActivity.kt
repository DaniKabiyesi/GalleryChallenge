package com.studying.imgurchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.studying.imgurchallenge.adapter.GalleryAdapter
import com.studying.imgurchallenge.databinding.ActivityGalleryBinding
import com.studying.imgurchallenge.model.Data
import com.studying.imgurchallenge.model.MyModel
import com.studying.imgurchallenge.viewmodel.GalleryViewModel
import com.studying.imgurchallenge.viewmodel.GalleryViewModelFactory

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGalleryBinding
    lateinit var viewModel: GalleryViewModel
//    private val galleryList: MutableList<DataResponse> = mutableListOf()

    //    private val mAdapter = GalleryAdapter(this)
    private lateinit var mAdapter: GalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setUpRecyclerView()
        val galleryViewModelFactory = GalleryViewModelFactory()

        viewModel =
            ViewModelProvider(this, galleryViewModelFactory).get(GalleryViewModel::class.java)
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

//    private fun setUpRecyclerView() {
//        val recyclerView = binding.galleryRecyclerView
//        recyclerView.adapter = mAdapter
//    }

    private fun setObservers() {
        viewModel.catsImagesList.observe(this, Observer {
//            mAdapter.populateAdapter(it)
//            galleryList.addAll(it as MutableList<DataResponse>)
            setUpRecyclerView(it)
        })

        viewModel.catsImagesListErrorResponse.observe(this) {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
        }
    }


}