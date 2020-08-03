package com.android.githubresumebuilder.resume.domain.interactor

import com.android.githubresumebuilder.core.interactor.Interactor
import com.android.githubresumebuilder.resume.domain.model.PostRepoEntity
import com.android.githubresumebuilder.resume.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class GetPostByIdInteractor(
    private val postRepository: PostRepository
) : Interactor<GetPostByIdInteractor.Params, Flow<PostRepoEntity>> {

    override fun execute(params: Params): Flow<PostRepoEntity> {
        return postRepository.getPostById(id = params.id)
    }

    data class Params(val id: String)
}