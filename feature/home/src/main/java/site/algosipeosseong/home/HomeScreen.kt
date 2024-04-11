package site.algosipeosseong.home
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import site.algosipeosseong.designsystem.theme.KnowledgenderTheme

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {



    Column {
        Header()
        Body()
    }

}

@Composable
private fun Header() {
    Column {
        Text(text = "아니")
    }
}

@Composable
private fun Body() {

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    KnowledgenderTheme {
        HomeScreen(navController = rememberNavController())
    }
}
