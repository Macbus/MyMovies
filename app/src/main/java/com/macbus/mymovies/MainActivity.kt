package com.macbus.mymovies

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.macbus.mymovies.MediaItem.*
import com.macbus.mymovies.ui.theme.MyMoviesTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMoviesTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text(text = stringResource(id = R.string.app_name)) },
                                actions = {
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            imageVector = Icons.Default.Search,
                                            contentDescription = null
                                        )
                                    }
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            imageVector = Icons.Default.Share,
                                            contentDescription = null
                                        )
                                    }
                                }
                                /*
                                Para insertar el icono tipo Hamburguesa,
                                en este caso no realiza ninguna función porque no le hemos dado una accion onClick
                                navigationIcon = {
                                    IconButton(onClick = { *//*TODO*//* }) {
                                        Icon(imageVector = Icons.Default.Menu,
                                        contentDescription = null)
                                    }
                                }*/

                            )
                        }
                    ) { padding ->
                        MediaList(modifier = Modifier.padding())
                    }

                    //var (value, onValueChange) = rememberSaveable {mutableStateOf("")}
                    //StateSample(value = value, onvalueChange = onValueChange)
                    //Greeting("Android")
                }
            }
        }
    }
}
/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StateSample(value : String, onvalueChange: (String)->Unit){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.Center

    ) {
        TextField(
            value = value,
            onValueChange = { onvalueChange(it) },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = value,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(8.dp)
            )


        Button(onClick = { onvalueChange("")  },
        modifier = Modifier.fillMaxWidth(),
        enabled = value.isNotEmpty()

            ) {
            Text(text = "Clear")
        }
    }
}
*/



//@Preview
@Composable
fun MediaList(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(4.dp),
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier
        //verticalArrangement = Arrangement.spacedBy(5.dp), Opcion general
        //horizontalArrangement = Arrangement.spacedBy(5.dp) Opción general.

    ) {
        items(getMedia()) { item ->
            MediaListItem(item, Modifier.padding(2.dp))
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun MediaListItem(item: MediaItem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier

    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()

        ) {
            AsyncImage(
                model = item.thumb,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )
            if (item.type == Type.VIDEO)
                Icon(
                    imageVector = Icons.Default.PlayCircleOutline,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(92.dp)
                        .align(Alignment.Center)

                )

        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .padding(16.dp)
        ) {
            Text(
                item.title,
                style = MaterialTheme.typography.titleMedium
            )

        }

    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


//@Preview(showBackground = true, widthDp= 200, heightDp = 100)
@Composable
fun ButtonText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello World",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Red,
            textDecoration = TextDecoration.LineThrough

        )
    }
}


//@Preview(showBackground = true, name = "Android Greating")
@Composable
fun DefaultPreview() {
    MyMoviesTheme {
        Greeting("Android")
    }
}



