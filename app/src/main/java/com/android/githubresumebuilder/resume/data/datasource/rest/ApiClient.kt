package com.android.githubresumebuilder.resume.data.datasource.rest

import com.android.githubresumebuilder.core.network.BaseApiClient
import com.android.githubresumebuilder.resume.data.datasource.rest.interfaces.IPostApiClient


object PostApiClient : BaseApiClient<IPostApiClient>(IPostApiClient::class.java)