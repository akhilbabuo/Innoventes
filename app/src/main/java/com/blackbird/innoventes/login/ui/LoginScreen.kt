package com.blackbird.innoventes.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.blackbird.innoventes.R
import com.blackbird.innoventes.databinding.FragmentLoginScreenBinding
import com.blackbird.innoventes.extentions.setClickableSpan


class LoginScreen : Fragment() {

    private lateinit var binding: FragmentLoginScreenBinding
    private val viewModel: LoginViewModel by lazy { LoginViewModel() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()

    }

    private fun initializeView() {
        with(binding) {
            viewModel = this@LoginScreen.viewModel
            binder = this@LoginScreen.viewModel.binder
            tvInfo.setClickableSpan(
                getString(R.string.login_info),
                getString(R.string.learn_more)
            ) {
                Toast.makeText(context, getString(R.string.learn_more), Toast.LENGTH_SHORT).show()
            }
        }
    }


}