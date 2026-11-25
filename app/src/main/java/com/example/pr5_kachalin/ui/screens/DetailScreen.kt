package com.example.pr5_kachalin.ui.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pr5_kachalin.R
import com.example.pr5_kachalin.data.Specialty
import com.example.pr5_kachalin.data.SpecialtyRepository
import com.example.pr5_kachalin.ui.navigation.AppHavHost

class  DetailScreen
{

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(specialtyId: Int, navController: NavController) {
    val specialty = SpecialtyRepository.getSpecialtyById(specialtyId) ?: Specialty(0,"null","null","null","null")
    val cont = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.text6)) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(R.string.text5)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = specialty.title,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Специальность: ${specialty.code}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = specialty.description,
                style = MaterialTheme.typography.bodyMedium
            )
            Button(onClick = { Click(cont) }) {
                Text(text = stringResource(R.string.text3))
            }
        }
    }
}

fun Click(context: Context) {
    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+7999348566"))
    context.startActivity(intent)
}

