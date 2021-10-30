package com.example.k2p.presentation.mealdetail

import com.example.k2p.core.exception.Failure
import com.example.k2p.core.interactor.UseCase
import com.example.k2p.core.presentation.BaseViewModel
import com.example.k2p.domain.model.Food
import com.example.k2p.domain.model.Like
import com.example.k2p.domain.usecase.*
import com.example.k2p.presentation.account.AccountViewState
import com.example.k2p.presentation.foods.FoodViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import java.security.PrivateKey
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class DetailFoodViewModel @Inject constructor(
    private val getFoodById: GetFoodById,
    private val saveFoods: SaveFoods,
    private val saveLikes: SaveLikes,
    private val getLikeByUserId: GetLikeByUserId,
    private val deleteLike: DeleteLike,
    private val getLocalUser: GetLocalUser):
    BaseViewModel() {

    fun getLocalUser(){
        getLocalUser(UseCase.None()){
            it.fold(::userNotFound) {
                state.value = AccountViewState.LoggedUser(it)
                true
            }
        }
    }

    private fun userNotFound(failure: Failure){
        state.value = AccountViewState.UserNotFound
        handleFailure(failure)
    }

    fun doSaveLikes(likes: List<Like>){
        saveLikes(likes)
    }

        fun doGetFoodById(id: String){
            getFoodById(id){
                it.fold(::handleFailure){
                    state.value = FoodViewState.FoodsReceived(it.meals?: listOf())

                    saveFoods(it.meals ?: listOf())

                    true
                }
            }
        }

    private fun saveFoods(foods: List<Food>){
        saveFoods(foods){
            it.fold(::handleFailure){
                it
            }
        }
    }

    fun doGetLikeByUserId(id: String){
        getLikeByUserId(id){
            it.fold(::handleFailure){
                state.value = LikeViewState.LikesReceived(it.likes?: listOf())
                true
            }
        }
    }

    fun removeLike(id: String){
        deleteLike(id)
    }

}