package com.android.githubresumebuilder.resume.domain.repository

import com.android.githubresumebuilder.resume.domain.model.PostEntity
import com.android.githubresumebuilder.resume.domain.model.PostRepoEntity
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getPosts(user: String): Flow<PostEntity>
    fun getPostById(id: String): Flow<PostRepoEntity>
}