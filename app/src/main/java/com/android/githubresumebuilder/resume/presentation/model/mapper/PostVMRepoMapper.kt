package com.android.githubresumebuilder.resume.presentation.model.mapper

import com.android.githubresumebuilder.core.mapper.Mapper
import com.android.githubresumebuilder.resume.domain.model.PostRepoEntity
import com.android.githubresumebuilder.resume.presentation.model.PostVMRepo

class PostVMRepoMapper : Mapper<PostRepoEntity, PostVMRepo> {
    override fun map(origin: PostRepoEntity) =
        PostVMRepo(
            name = origin.name,
            login = origin.login,
            avatar_url = origin.avatar_url,
            url = origin.url,
            blog = origin.blog,
            bio = origin.bio,
            public_repos = origin.public_repos,
            public_gists = origin.public_gists,
            followers = origin.followers,
            following = origin.following,
            location = origin.location,
            company = origin.company
        )
}