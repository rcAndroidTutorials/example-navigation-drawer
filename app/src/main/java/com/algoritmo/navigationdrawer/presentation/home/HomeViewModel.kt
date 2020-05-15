package com.algoritmo.navigationdrawer.presentation.home

import androidx.lifecycle.ViewModel
import com.algoritmo.navigationdrawer.common.SingleLiveEvent

class HomeViewModel: ViewModel() {
    val openDrawerSLE = SingleLiveEvent<Unit>()
    val closeDrawerSLE = SingleLiveEvent<Unit>()
}