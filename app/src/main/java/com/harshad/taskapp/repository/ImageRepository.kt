package com.harshad.taskapp.repository


import androidx.lifecycle.MutableLiveData
import com.harshad.taskapp.data.ApiClient
import com.harshad.taskapp.data.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback

class ImageRepository {

    val apiClient = ApiClient.create()
    var images = MutableLiveData<List<Response?>?>()

    fun getImages(pageNo: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiClient.getImages(pageNo)
            response.enqueue(object : Callback<MutableLiveData<List<Response?>>?> {
                override fun onResponse(
                    call: Call<MutableLiveData<List<Response?>>?>,
                    response: retrofit2.Response<MutableLiveData<List<Response?>>?>
                ) {
                    response.body()?.let { images.postValue(it.value) }
                }

                override fun onFailure(
                    call: Call<MutableLiveData<List<Response?>>?>,
                    t: Throwable
                ) {
                    images.postValue(null)
                }

            })
        }
    }

}