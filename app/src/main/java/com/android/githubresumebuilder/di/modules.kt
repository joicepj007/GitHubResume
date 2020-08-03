package com.android.githubresumebuilder.di


import com.android.githubresumebuilder.resume.data.datasource.rest.PostRestDataStore
import com.android.githubresumebuilder.resume.data.repository.PostRepositoryImpl
import com.android.githubresumebuilder.resume.domain.interactor.GetPostByIdInteractor
import com.android.githubresumebuilder.resume.domain.interactor.GetPostsInteractor
import com.android.githubresumebuilder.resume.domain.repository.PostRepository
import com.android.githubresumebuilder.resume.presentation.viewmodel.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val postModule = module {

    //region ViewModel
    viewModel {
        PostViewModel(get(),get())
    }
    //endregion

    //region Interactor
    single {
        GetPostsInteractor(
            get()
        )
    }
    single {
        GetPostByIdInteractor(
            get()
        )
    }
    //endregion

    //region Repository
    single<PostRepository> {
        PostRepositoryImpl(get())
    }
    //endregion

    //region Datastore
    single {
        PostRestDataStore()
    }
    //endregion
}

val modules = listOf(postModule)