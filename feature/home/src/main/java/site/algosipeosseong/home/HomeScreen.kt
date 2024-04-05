package site.algosipeosseong.home
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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
