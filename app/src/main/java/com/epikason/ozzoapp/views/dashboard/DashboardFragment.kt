package com.epikason.ozzoapp.views.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.epikason.ozzoapp.R
import com.epikason.ozzoapp.base.BaseFragment
import com.epikason.ozzoapp.databinding.FragmentDashboardBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate){
    @Inject
    lateinit var qAuth: FirebaseAuth
    override fun setListener() {

        with(binding){
            btnLogout.setOnClickListener {

                loadingDialog?.show()
                qAuth.signOut()

                root.postDelayed({
                loadingDialog?.dismiss()
               findNavController().navigate(R.id.action_dashboardFragment_to_startFragment,
                   null,
                   NavOptions.Builder()
                       .setPopUpTo(R.id.main_nav, true)
                       .build()
               )},800)

            }
        }

    }

    override fun allObserver() {

    }

}