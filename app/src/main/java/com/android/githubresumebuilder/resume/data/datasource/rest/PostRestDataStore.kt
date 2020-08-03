package com.android.githubresumebuilder.resume.data.datasource.rest

import com.android.githubresumebuilder.resume.data.datasource.rest.response.PostResponseData
import com.android.githubresumebuilder.resume.data.datasource.rest.response.PostResponseRepoData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostRestDataStore {

    fun getPosts(user: String): Flow<PostResponseData> = flow {
        PostApiClient.getApiClient().getPublicRepositories(user = user).forEach {
            emit(it)
        }
    }


    fun getPostById(user: String): Flow<PostResponseRepoData> = flow {
        emit(PostApiClient.getApiClient().getUserbyId(user = user))
    }

}