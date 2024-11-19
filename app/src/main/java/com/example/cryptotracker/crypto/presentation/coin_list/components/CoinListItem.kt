package com.example.cryptotracker.crypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptotracker.crypto.domain.Coin
import com.example.cryptotracker.crypto.presentation.models.CoinUi
import com.example.cryptotracker.crypto.presentation.models.DisplayableNumber
import com.example.cryptotracker.crypto.presentation.models.toCoinUi
import com.example.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun CoinListItem(coinUi: CoinUi, onClick: () -> Unit, modifier: Modifier = Modifier) {

    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(coinUi.iconRes),
            contentDescription = coinUi.name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(85.dp)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = coinUi.symbol,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = contentColor
            )
            Text(
                text = coinUi.name,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                color = contentColor
            )
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = "$ ${coinUi.priceUsd.formatted}",
                color = contentColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Spacer(Modifier.height(8.dp))
            PriceChange(coinUi.changePercent24Hr)
        }
    }
}

@Preview
@PreviewLightDark
@PreviewDynamicColors
@Composable
private fun PrevCoinListItem() {
    CryptoTrackerTheme {
        CoinListItem(
            previewCoin.toCoinUi(),
            {},
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}

internal val previewCoin = Coin(
    id = "bitcoin",
    rank = 1,
    name = "Bitcoin",
    symbol = "BTC",
    marketCapUsd = 12454564545.75,
    priceUsd = 62584.45,
    changePercent24Hr = 0.1
)