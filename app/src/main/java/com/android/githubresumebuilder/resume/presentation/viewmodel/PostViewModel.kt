package com.android.githubresumebuilder.resume.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.githubresumebuilder.core.platform.BaseViewModel
import com.android.githubresumebuilder.core.utils.io
import com.android.githubresumebuilder.core.utils.ui
import com.android.githubresumebuilder.resume.domain.interactor.GetPostByIdInteractor
import com.android.githubresumebuilder.resume.domain.interactor.GetPostsInteractor
import com.android.githubresumebuilder.resume.presentation.model.mapper.PostVMMapper
import com.android.githubresumebuilder.resume.presentation.model.mapper.PostVMRepoMapper
import com.android.githubresumebuilder.resume.presentation.viewmodel.state.PostVS
import com.android.githubresumebuilder.resume.presentation.viewmodel.state.PostVSRepo
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PostViewModel(
    private val getPostsInteractor: GetPostsInteractor,
    private val getPostsbyIdInteractor: GetPostByIdInteractor
) : BaseViewModel() {

    val viewState: LiveData<PostVS> get() = mViewState
    private val mViewState = MutableLiveData<PostVS>()

    val viewRepoState: LiveData<PostVSRepo> get() = mViewRepoState
    private val mViewRepoState = MutableLiveData<PostVSRepo>()

    private val mPostVMMapper by lazy { PostVMMapper() }
    private val mPostVMRepoMapper by lazy { PostVMRepoMapper() }

        fun getPosts(string: String) {
        viewModelScope.launch {
            try {
                io {
                    getPostsInteractor.execute(GetPostsInteractor.Params(string))
                        .collect {
                            ui { mViewState.value = PostVS.AddPost(mPostVMMapper.map(it)) }
                        }
                }
            } catch (e: Exception) {
                ui { mViewState.value = PostVS.Error(e.message) }
            }
        }
    }
    fun getPostsbyId(string: String) {
        viewModelScope.launch {
            try {
                io {
                    getPostsbyIdInteractor.execute(GetPostByIdInteractor.Params(string))
                        .collect {
                            ui { mViewRepoState.value = PostVSRepo.AddPost(mPostVMRepoMapper.map(it)) }
                        }
                }
            } catch (e: Exception) {
                ui { mViewRepoState.value = PostVSRepo.Error(e.message) }
            }
        }
    }
}