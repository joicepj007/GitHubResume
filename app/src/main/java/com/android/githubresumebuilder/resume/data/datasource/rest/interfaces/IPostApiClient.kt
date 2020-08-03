package com.android.githubresumebuilder.resume.data.datasource.rest.interfaces
import com.android.githubresumebuilder.resume.data.datasource.rest.response.PostResponseData
import com.android.githubresumebuilder.resume.data.datasource.rest.response.PostResponseRepoData
import retrofit2.http.GET
import retrofit2.http.Path

interface IPostApiClient {
    @GET("/users/{user}")
    suspend fun getUserbyId(@Path("user") user:String): PostResponseRepoData

    @GET("/users/{user}/repos")
    suspend fun getPublicRepositories(@Path("user")user:String): List<PostResponseData>
}