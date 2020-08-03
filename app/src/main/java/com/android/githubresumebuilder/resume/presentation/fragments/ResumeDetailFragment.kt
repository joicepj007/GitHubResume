package com.android.githubresumebuilder.resume.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.githubresumebuilder.databinding.ResumeDetailFragmentBinding
import com.android.githubresumebuilder.resume.presentation.adapter.RVPostAdapter
import com.android.githubresumebuilder.resume.presentation.viewmodel.PostViewModel
import com.android.githubresumebuilder.resume.presentation.viewmodel.state.PostVS
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_repo_list.*
import kotlinx.android.synthetic.main.resume_detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResumeDetailFragment : Fragment() {

    private var name: String?=null
    private var login: String?=null
    private var avatarUrl: String?=null
    private var url: String?=null
    private var blog: String?=null
    private var bio: String?=null
    private var publicRepos: String?=null
    private var followers: String?=null
    private var following: String?=null
    private var location: String?=null
    private var company: String?=null
    private val viewModels: PostViewModel by viewModel()
    private lateinit var viewDataBinding: ResumeDetailFragmentBinding
    private val mAdapter = RVPostAdapter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = ResumeDetailFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return viewDataBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString("name")?.let {
            name = it
        }
        arguments?.getString("login")?.let {
            login = it
        }
        arguments?.getString("avatar_url")?.let {
            avatarUrl = it
        }
        arguments?.getString("url")?.let {
            url = it
        }
        arguments?.getString("blog")?.let {
            blog = it
        }
        arguments?.getString("bio")?.let {
            bio = it
        }
        arguments?.getString("public_repos")?.let {
            publicRepos = it
        }
        arguments?.getString("followers")?.let {
            followers = it
        }
        arguments?.getString("following")?.let {
            following = it
        }
        arguments?.getString("location")?.let {
            location = it
        }
        arguments?.getString("company")?.let {
            company = it
        }
        Picasso.get().load(avatarUrl).into(iv_profile)
        tv_name?.text = name
        tv_bio?.text = bio
        tv_company?.text = company
        tv_repo_count?.text = publicRepos
        tv_followers?.text = followers
        tv_following?.text = following
        tv_blog?.text = blog
        tv_location?.text = location
        setupAdapter()
        setupObservers()
    }
    private fun setupObservers() {
                viewModels.viewState.observe(viewLifecycleOwner, Observer {
                    when (it) {
                        is PostVS.AddPost -> {

                            mAdapter.add(it.postVM)
                        }
                        is PostVS.Error -> {

                        }
                    }
                })
        viewModels.getPosts(login.toString())
    }
    private fun setupAdapter() {
        repo_list_rv.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = mAdapter
        }
    }
}