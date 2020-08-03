package com.android.githubresumebuilder.resume.data.mapper

import com.android.githubresumebuilder.core.mapper.Mapper
import com.android.githubresumebuilder.resume.data.datasource.rest.response.PostResponseRepoData
import com.android.githubresumebuilder.resume.domain.model.PostRepoEntity

class PostDataRepoMapper : Mapper<PostResponseRepoData, PostRepoEntity> {
    override fun map(origin: PostResponseRepoData) =
        PostRepoEntity(
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