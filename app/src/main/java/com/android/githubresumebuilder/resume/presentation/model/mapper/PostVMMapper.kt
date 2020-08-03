package com.android.githubresumebuilder.resume.presentation.model.mapper

import com.android.githubresumebuilder.core.mapper.Mapper
import com.android.githubresumebuilder.resume.domain.model.PostEntity
import com.android.githubresumebuilder.resume.presentation.model.PostVM


class PostVMMapper : Mapper<PostEntity, PostVM> {
    override fun map(origin: PostEntity) =
        PostVM(
            name = origin.name,
            description = origin.description,
            html_url = origin.html_url
        )
}