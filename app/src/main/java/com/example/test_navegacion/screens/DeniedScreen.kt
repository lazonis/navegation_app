package com.example.test_navegacion.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun DeniedScreen(onNavigationWelcome : () -> Unit) {

    Icon(
        Icons.Default.ArrowBack,
        contentDescription = "Favorite",
        modifier = Modifier.clickable{ onNavigationWelcome() }.size(40.dp),
        tint = Color.White
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()).background(Color.Gray.copy(alpha = 0.3f))
    ) {
        Text(
            text = "📜 ROYAL DECREE Nº 404/2026: ABSOLUTE SERIOUSNESS ACT",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "WHEREAS: Laughter distracts from productivity, leisure clouds judgment, and fun is, ultimately, a structural waste of time.",
            color = Color.White,
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "IT IS DECREED:",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "1. PROHIBITION OF ENTERTAINMENT: The use of any software, mechanism, or activity that generates \"fun,\" \"enjoyment,\" or \"entertainment\" without a prior educational or punitive purpose is strictly prohibited.",
            color = Color.White,
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "2. UNIVERSAL AGE RESTRICTION: Given that maturity is a subjective and dangerous concept, video games are restricted to citizens of exactly 99 years old. If you are 98, you are too young; if you are 100, you have played enough.",
            color = Color.White,
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "3. PENALTIES: Any citizen caught enjoying a game shall be sentenced to stare at a blank wall for 14 hours while listening to an audiobook about the reproduction of garden snails.",
            color = Color.White,
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Issued at the Palace of Boredom, on January 31st, 2026.",
            color = Color.LightGray,
            modifier = Modifier.padding(10.dp)
        )
    }
}