package com.example.k2p.presentation.mealdetail

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.k2p.R
import com.example.k2p.core.extension.failure
import com.example.k2p.core.extension.loadFromURLRounded
import com.example.k2p.core.extension.observe
import com.example.k2p.core.presentation.BaseFragment
import com.example.k2p.core.presentation.BaseViewState
import com.example.k2p.databinding.DetailFoodFragmentBinding
import com.example.k2p.domain.model.Food
import com.example.k2p.domain.model.Like
import com.example.k2p.domain.model.User
import com.example.k2p.presentation.account.AccountViewState
import com.example.k2p.presentation.foods.FoodViewState
import com.example.k2p.presentation.random.RandomMealAdapter
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class DetailFoodFragment : BaseFragment(R.layout.detail_food_fragment) {

    private lateinit var binding: DetailFoodFragmentBinding
    private val adapter: RandomMealAdapter by lazy { RandomMealAdapter() }
    private lateinit var like: Like
    private lateinit var user: User
    private var listLikes: MutableList<Like> = mutableListOf()
    private var flag: Boolean = false
    private var idLike: Int = 0

    private val args: DetailFoodFragmentArgs by navArgs()

    private val foodViewModel by viewModels<DetailFoodViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user = User(0,"","")
        foodViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)

            doGetFoodById(args.food.idMeal.toString())
            getLocalUser()
        }
        like = Like(0,0,0)
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when(state) {
            is FoodViewState.FoodsReceived -> setUpAdapter(state.meals[0])
            is AccountViewState.LoggedUser -> {
                user = state.user
                foodViewModel.doGetLikeByUserId(user.idUser.toString())
                binding.btnFav.isVisible = true
            }
            is AccountViewState.UserNotFound -> {
                binding.btnFav.isVisible = false
            }
            is LikeViewState.LikesReceived ->{
                state.likes.forEach {
                    flag = it.idLikeFood == args.food.idMeal
                    idLike = it.idLike
                }
                checkFavButton(flag)
            }
        }
    }

    private fun checkFavButton(flag: Boolean){
        if(flag)
        binding.btnFav.setImageResource(R.drawable.ic_full_star)
        else binding.btnFav.setImageResource(R.drawable.ic_empty_star)
    }

    private fun setUpAdapter(food: Food){
        /*adapter.addData(foods)
        binding.recyclerDetail.apply {
            adapter = this@DetailFoodFragment.adapter
        }*/
        binding.txtViewMealName.text = food.mealName
        binding.imgMeal.loadFromURLRounded(food.urlMealThumb)
        binding.txtViewCategory.text = food.mealCategory
        binding.txtViewArea.text = food.area
        binding.txtInstructions.text = food.instructions
    }

    override fun setBinding(view: View) {
        binding = DetailFoodFragmentBinding.bind(view)
        binding.lifecycleOwner = this
        binding.btnFav.setOnClickListener {
            if(!flag){
                saveLike()
                flag = true
                checkFavButton(flag)
            }else{
                foodViewModel.removeLike(idLike.toString())
                flag = false
                checkFavButton(flag)
            }
        }
    }

    private fun deleteLike(){

    }

    private fun saveLike(){
        like.apply {
            idLikeFood = args.food.idMeal
            idLikeUser = user.idUser
        }
        listLikes.add(like)
        foodViewModel.doSaveLikes(listLikes)
    }
}