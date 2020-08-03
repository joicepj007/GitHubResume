package com.android.githubresumebuilder.resume.data.repository

import com.android.githubresumebuilder.resume.data.datasource.rest.PostRestDataStore
import com.android.githubresumebuilder.resume.data.mapper.PostDataMapper
import com.android.githubresumebuilder.resume.data.mapper.PostDataRepoMapper
import com.android.githubresumebuilder.resume.domain.model.PostEntity
import com.android.githubresumebuilder.resume.domain.model.PostRepoEntity
import com.android.githubresumebuilder.resume.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PostRepositoryImpl(
    private val postRestDataStore: PostRestDataStore
) : PostRepository {

    private val mPostDataMapper by lazy { PostDataMapper() }
    private val mPostDataRepoMapper by lazy { PostDataRepoMapper() }

    override fun getPosts(user: String): Flow<PostEntity> =
        postRestDataStore.getPosts(user = user).map{
            mPostDataMapper.map(it)
        }



    override fun getPostById(user: String): Flow<PostRepoEntity> =
        postRestDataStore.getPostById(user = user).map {
            mPostDataRepoMapper.map(it)
        }
}
