package com.example.randomuserapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randomuserapp.databinding.ActivityMainBinding
import com.example.randomuserapp.ui.models.InfoUi
import com.example.randomuserapp.ui.models.ResultUi
import com.example.randomuserapp.ui.models.UserRoomUiModel
import com.example.randomuserapp.ui.useradapter.UserAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private var rvUserAdapter: UserAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getUserInformation()
        observeData()
        observeError()
        viewModel.bringUsersSaved()
        observeUsersSaved()
    }

    private fun observeUsersSaved() {
        viewModel.usersSaved.observe(this){
            setRvUsersSaved(it)
        }
    }

    private fun observeError() {
        viewModel.messageError.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun observeData() {
        viewModel.userModelUi.observe(this) {
            setInfo(it.info)
            //setResults(it.results.toMutableList())
            setUserInfoToSaveInRoom(it.results[0])
        }
    }

    private fun setRvUsersSaved(it: List<UserRoomUiModel>?) {
        rvUserAdapter = UserAdapter(it!!.toMutableList()) { navigateToShowFullResult(it) }
        binding.rvUsers.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = rvUserAdapter
        }
    }

    private fun navigateToShowFullResult(resultUi: UserRoomUiModel) {
        /*val bundle = Bundle()
        bundle.putParcelable("myUser", resultUi)
        val intent = Intent(this, ShowAllUserInformationActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)*/
    }

    private fun setInfo(info: InfoUi) {
        binding.tvPage.text = "page: " + info.page.toString()
        binding.tvQuantityOfResults.text = "#results: " + info.results.toString()
        binding.tvSeed.text = "seed: " + info.seed
        binding.tvVersion.text = "V. " + info.version
    }

    private fun setUserInfoToSaveInRoom(resultUi: ResultUi) {
        val fullName = resultUi.name
        val picture = resultUi.picture.medium
        val email = resultUi.email
        val newUser = UserRoomUiModel(fullName, picture, email)
        viewModel.saveUser(newUser)
    }
}
