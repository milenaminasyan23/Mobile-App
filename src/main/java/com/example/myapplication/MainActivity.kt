package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getPosts()

        viewModel.posts.observe(this) { postsResult ->
            setContent {
                PostResponse(postsResult)
            }
        }
    }
}

@Composable
fun PostResponse(postsResult: Result<Response>) { ////
    Column {
        when (postsResult) {
            is Result.Success -> {
                val posts = postsResult.data.entries
                LazyColumn {
                    items(posts) { post ->
                        Card(
                            Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                        ) {
                            Column( // row
                                Modifier.padding(8.dp)
                            ) {
                                Text(text = post.API, style = MaterialTheme.typography.h5)    ///
                                Text(text = post.Description, style = MaterialTheme.typography.body1) ///
                            }
                        }
                    }
                }
            }
            is Result.Error -> {
                Text(text = "Error: ${postsResult.exception.message}")
            }
            else -> {

            }
        }
    }
}