import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.Drawer
import components.customShape
import kotlinx.coroutines.launch


@Composable

fun App() {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    MaterialTheme {
        Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = {
                Drawer(scope, scaffoldState)

            },
            drawerGesturesEnabled = false,
            drawerShape = customShape(),
            topBar = {
                TopAppBar(title = { Text("Sym Integrador") }, navigationIcon = {
                    IconButton(onClick = { scope.launch { scaffoldState.drawerState.apply { if (isClosed) open() else close() } } }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                })


            }, content = {
                Column(
                    modifier = Modifier.padding(16.dp).fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Content goes here")
                }
            })
    }


}

