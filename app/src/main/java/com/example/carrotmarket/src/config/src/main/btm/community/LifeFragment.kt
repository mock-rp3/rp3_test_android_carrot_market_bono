package com.example.carrotmarket.src.config.src.main.btm.community

import android.os.Bundle
import android.view.View
import com.example.carrotmarket.R
import com.example.carrotmarket.config.BaseFragment
import com.example.carrotmarket.databinding.FragmentLifeBinding
import com.example.carrotmarket.src.config.src.main.btm.community.models.CommunityResponse
import com.example.carrotmarket.src.config.src.main.btm.community.models.CommunityResult

class LifeFragment :
    BaseFragment<FragmentLifeBinding>(FragmentLifeBinding::bind, R.layout.fragment_life),
    CommunityFragmentView {

    lateinit var communityAdapter: CommunityAdapter
    var communityResponse = ArrayList<CommunityResult>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        communityAdapter = CommunityAdapter(requireActivity(), communityResponse)
        binding.lifeRv.adapter = communityAdapter

        CommunityService(this).tryCommunityHome()

    }

    override fun onGetCommunitySuccess(response: CommunityResponse) {

        //    val commentCount: Int,
        ////    val communityIdx: Int,
        //    val createdAt: String,
        //    val description: String,
        //    val name: String,
        ////    val reactionCount: Int,
        //    val regionNameTown: String
        for (i in 0 until response.result.size) {


            communityResponse.add(
                CommunityResult(
                    response.result[i].commentCount,
                    response.result[i].communityIdx,
                    response.result[i].createdAt,
                    response.result[i].description,
                    response.result[i].name,
                    response.result[i].regionNameTown
                )
            )
        }
        communityAdapter.notifyDataSetChanged()
    }

    override fun onGetCommunityFailure(message: String) {
    }
}