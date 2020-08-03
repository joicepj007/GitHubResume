package com.android.githubresumebuilder.resume.presentation.viewmodel.state

import com.android.githubresumebuilder.resume.presentation.model.PostVMRepo

sealed class PostVSRepo {
    class AddPost(val PostVMRepo: PostVMRepo):PostVSRepo()
    class Error(val message:String?):PostVSRepo()
}