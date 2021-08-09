package com.example.flow.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flow.R
import com.example.flow.databinding.ActivityMainBinding
import com.example.flow.models.UserEntity
import com.example.flow.presentation.adapters.UserAdapter
import com.example.flow.utils.DataState
import com.example.flow.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var usersAdapter: UserAdapter

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init(){
        initRecyclerView()
        initObservers()
        initListeners()
    }

    private fun initRecyclerView() = binding.rvUsers.apply {
        adapter = usersAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }

    private fun initObservers(){
        viewModel.userDataState.observe(this, Observer { dataState ->
            when(dataState){
                is DataState.Success<List<UserEntity>> -> handleSuccess(dataState.data)
                is DataState.Loading -> handleLoading(true)
                is DataState.Error -> handleError(dataState.error)
                else -> Unit
            }
        })
    }

    private fun initListeners(){
        binding.mbGetUserData.setOnClickListener { viewModel.getUsers() }
    }

    private fun handleLoading(isLoading: Boolean) {
        binding.mbGetUserData.isEnabled = !isLoading
        binding.mbGetUserData.text = ""
        binding.pbGetData.visibility = View.VISIBLE
    }

    private fun handleSuccess(users: List<UserEntity>){
        binding.mbGetUserData.isEnabled = true
        binding.mbGetUserData.text = getString(R.string.get_data)
        binding.pbGetData.visibility = View.GONE

        usersAdapter.submitList(users)
    }

    private fun handleError(error: String){
        binding.mbGetUserData.isEnabled = true
        binding.mbGetUserData.text = getString(R.string.get_data)
        binding.pbGetData.visibility = View.GONE
        toast(error)
    }
}