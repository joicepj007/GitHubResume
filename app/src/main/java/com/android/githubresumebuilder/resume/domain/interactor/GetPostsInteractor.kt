package com.android.githubresumebuilder.resume.domain.interactor


import com.android.githubresumebuilder.core.interactor.Interactor
import com.android.githubresumebuilder.resume.domain.model.PostEntity
import com.android.githubresumebuilder.resume.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class GetPostsInteractor(
    private val postRepository: PostRepository
) : Interactor<GetPostsInteractor.Params, Flow<PostEntity>> {

    override fun execute(params: Params): Flow<PostEntity> {
        return postRepository.getPosts(user = params.id)
    }

    data class Params(val id: String)
}