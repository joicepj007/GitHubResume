package com.android.githubresumebuilder.resume.presentation.viewmodel.state

import com.android.githubresumebuilder.resume.presentation.model.PostVM


sealed class PostVS {
    class AddPost(val postVM: PostVM):PostVS()
    class Error(val message:String?):PostVS()
}