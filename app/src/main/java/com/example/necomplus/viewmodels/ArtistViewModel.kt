package com.example.necomplus.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.necomplus.models.Artist
import com.example.necomplus.models.ArtistResponse
import com.example.necomplus.repository.contract.ArtistRepository
import com.example.necomplus.repository.remote.ArtistRemote
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

class ArtistViewModel(application: Application) : AndroidViewModel(application) {
    private var topListArtist = MutableLiveData<MutableList<Artist>>()
    private var repository: ArtistRepository = ArtistRemote()
    private var compositeDisposable = CompositeDisposable()


    fun getTopListArtist(): MutableLiveData<MutableList<Artist>> {
        return topListArtist
    }

    fun getTopArtistByCountry(country: String, limit: String) {

        compositeDisposable.add(repository.getTopArtist(country, limit)
            .subscribeWith(object : DisposableObserver<ArtistResponse>() {
                override fun onComplete() {
                }

                override fun onNext(t: ArtistResponse) {
                    topListArtist.postValue(t.topartists.artist.toMutableList())
                }

                override fun onError(e: Throwable) {
                    e.message?.let { Log.d("ERROR", it) }
                }
            })
        )

    }

}