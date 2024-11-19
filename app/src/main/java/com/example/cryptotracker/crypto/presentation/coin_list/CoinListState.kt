package com.example.cryptotracker.crypto.presentation.coin_list

import androidx.compose.runtime.Immutable
import com.example.cryptotracker.crypto.presentation.models.CoinUi

@Immutable
data class CoinListState(
    val isLoading:Boolean,
    val coins:List<CoinUi> = emptyList(),
    val selectedCoin:CoinUi? = null
)