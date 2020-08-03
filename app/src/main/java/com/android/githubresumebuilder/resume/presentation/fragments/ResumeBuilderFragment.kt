package com.android.githubresumebuilder.resume.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.android.githubresumebuilder.R
import com.android.githubresumebuilder.databinding.ResumeBuilderFragmentBinding
import com.android.githubresumebuilder.resume.presentation.viewmodel.PostViewModel
import com.android.githubresumebuilder.resume.presentation.viewmodel.state.PostVSRepo
import kotlinx.android.synthetic.main.resume_builder_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResumeBuilderFragment : Fragment(),View.OnClickListener {


    private val viewModels: PostViewModel by viewModel()
    private lateinit var viewDataBinding:ResumeBuilderFragmentBinding
    private var name: String?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = ResumeBuilderFragmentBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                validation()
            }
            else -> {
                // else condition
            }

        }
    }
    fun validation()
    {
        name=search_edt.text.toString()
        if (!name.isNullOrBlank())
        {
            pb_loading.visibility=View.VISIBLE
            viewModels.viewRepoState.observe(viewLifecycleOwner, Observer {
                when (it) {
                    is PostVSRepo.AddPost -> {
                        if (!it.PostVMRepo.name.equals(null))
                        {
                            pb_loading.visibility=View.GONE
                            val bundle = bundleOf("name" to it.PostVMRepo.name,"avatar_url" to it.PostVMRepo.avatar_url,"url" to it.PostVMRepo.url,
                                "blog" to it.PostVMRepo.blog,"public_repos" to it.PostVMRepo.public_repos,"public_gists" to it.PostVMRepo.public_gists,"followers" to it.PostVMRepo.followers,
                                "company" to it.PostVMRepo.company,"following" to it.PostVMRepo.following,"location" to it.PostVMRepo.location,"bio" to it.PostVMRepo.bio,"login" to it.PostVMRepo.login)
                            findNavController(requireParentFragment()).navigate(R.id.action_navigation_home_to_detailTeamFragment, bundle)
                        }
                        else{
                            pb_loading.visibility=View.GONE
                            Toast.makeText(activity, getString(R.string.str_user_check), Toast.LENGTH_SHORT).show()
                        }
                    }
                    is PostVSRepo.Error -> {
                        pb_loading.visibility=View.GONE
                        Toast.makeText(activity, getString(R.string.str_user_check), Toast.LENGTH_SHORT).show()
                    }
                }

            })

            viewModels.getPostsbyId(name.toString())

        }
        else
        {
            Toast.makeText(activity, getString(R.string.str_user_check), Toast.LENGTH_SHORT).show()
        }
    }


}