package com.harshad.taskapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harshad.taskapp.data.Response
import com.harshad.taskapp.repository.ImageRepository

class ImagesViewModel(val imageRepo: ImageRepository) : ViewModel() {

    var imagesLiveData = MutableLiveData<List<Response?>>()

    fun getImages(pageNo: Int) {
        imageRepo.getImages(pageNo)
        imagesLiveData.postValue(imageRepo.images.value)
    }

    fun nextPage(pageNo: Int){
        imageRepo.getImages(pageNo)
        imagesLiveData.postValue(imageRepo.images.value)
    }
}