package com.example.gitlistmvp.mvp.presentation.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lessonone.R
import com.example.lessonone.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment


class UserFragment : MvpAppCompatFragment(), IUserView{

    private val presenter = UserPresenter(this)
    private var _binding : FragmentUserBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.setLogin(arguments?.getString(LOGIN) ?: "Пусто")
    }

    companion object {

        fun newInstance(login : String) : UserFragment{
            val arg = Bundle()
            arg.putString(LOGIN,login)
            val fragment = UserFragment()
            fragment.arguments = arg
            return fragment
        }
        private const val LOGIN = "LOGIN"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun setLogin(login: String) {
        binding.loginTextView.text = login
    }
}