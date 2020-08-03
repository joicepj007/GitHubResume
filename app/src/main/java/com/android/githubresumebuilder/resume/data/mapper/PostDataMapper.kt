package com.android.githubresumebuilder.resume.data.mapper

import com.android.githubresumebuilder.core.mapper.Mapper
import com.android.githubresumebuilder.resume.data.datasource.rest.response.PostResponseData
import com.android.githubresumebuilder.resume.domain.model.PostEntity


class PostDataMapper : Mapper<PostResponseData, PostEntity> {
    override fun map(origin: PostResponseData) =
        PostEntity(
            name = origin.name,
            description = origin.description,
            html_url = origin.html_url
        )
}