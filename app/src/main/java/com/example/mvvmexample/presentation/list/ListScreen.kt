package com.example.mvvmexample.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.mvvmexample.R
import com.example.mvvmexample.domain.model.DomainCharacter

// Widok
@Composable
fun ListScreen(
    listViewModel: ListViewModel = hiltViewModel()
) {
    val state = listViewModel.viewState

    // Lista która wyświetla itemy (CharacterItem)
    // + personalizacja (backgroundColor, padding itd...)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(250, 240, 255, 255))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(state.characters) { character ->
            CharacterItem(
                character = character,
                onCountChange = listViewModel::changeColor
            )
        }
    }
}

// Widok jednego itemu w liście
// WYniesiony do innej funkcji, żeby kod był czystszy
@Composable
fun CharacterItem(
    character: DomainCharacter,
    onCountChange: (id: Int?, option: CountOptions) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row {

            AsyncImage(
                modifier = Modifier.size(132.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(character.image)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(id = R.string.character_image),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column {

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = character.name.orEmpty(),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Species: ${character.species.orEmpty()}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Gender: ${character.gender.name}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Status: ${character.status.name}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    IconButton(onClick = { onCountChange(character.id, CountOptions.MINUS) }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            tint = Color(168, 0, 0, 255),
                            contentDescription = stringResource(R.string.minus_count)
                        )
                    }
                    Text(
                        text = "${character.count}",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    IconButton(onClick = { onCountChange(character.id, CountOptions.PLUS) }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowUp,
                            tint = Color(53, 150, 0, 255),
                            contentDescription = stringResource(R.string.add_count)
                        )
                    }
                }
            }
        }
    }
}


enum class CountOptions {
    PLUS,
    MINUS
}
