package com.sahan.universitiesinfo.fragment


import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.sahan.universitiesinfo.R
import com.sahan.universitiesinfo.databinding.FragmentDetailBinding
import com.sahan.universitiesinfo.viewmodel.DetailFragmentViewModel
import com.sahan.universitiesinfo.viewmodel.FeedFragmentViewModel


class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    private lateinit var viewModel: DetailFragmentViewModel

    override fun initUi() {

        val args: DetailFragmentArgs by navArgs()
        viewModel = ViewModelProvider(this)[DetailFragmentViewModel::class.java]
        viewModel.showWebView(fragmentDataBinding.universityWeb,args)

        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object  : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if(fragmentDataBinding.universityWeb.canGoBack()) {
                        fragmentDataBinding.universityWeb.goBack()
                    } else {
                        val action = DetailFragmentDirections.actionDetailFragmentToFeedFragment()
                        Navigation.findNavController(fragmentDataBinding.root).navigate(action)
                    }
                }

            }
        )


    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_detail
    }




    companion object {

        @JvmStatic
        fun newInstance() = DetailFragment()


    }
}