package com.atp.assignments.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.atp.assignments.R

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun UserPhotoSection(modifier: Modifier = Modifier) {

    Card(
        modifier = modifier, elevation = 5.dp
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {

            val (row, staggeredGrid) = createRefs()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(row) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                        height = Dimension.wrapContent
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Photos", fontWeight = FontWeight.Bold, fontSize = 20.sp
                )
                Text(text = "See All".uppercase())
            }

            LazyVerticalStaggeredGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(top = 20.dp)
                    .constrainAs(staggeredGrid) {
                        top.linkTo(row.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    },
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 4.dp,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(listOfPhotos.size) {
                    var loaded by remember { mutableStateOf(false) }
                    AsyncImage(
                        model = listOfPhotos[it],
                        contentDescription = "Photos",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .clip(RoundedCornerShape(10.dp)),
                        placeholder = painterResource(id = R.drawable.karachi),
                        error = painterResource(id = R.drawable.karachi),
                        fallback = painterResource(id = R.drawable.karachi),
                        onSuccess = {
                            loaded = true
                        },
                        colorFilter = if (!loaded) ColorFilter.tint(LocalContentColor.current) else null,
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
        }
    }
}

val listOfPhotos = listOf(
    getRandomImageUrl(width = 1600, height = 900),
    getRandomImageUrl(width = 900, height = 1600),
    getRandomImageUrl(width = 500, height = 500),
    getRandomImageUrl(width = 300, height = 400),
    getRandomImageUrl(width = 1600, height = 900),
    getRandomImageUrl(width = 500, height = 500),
    getRandomImageUrl(width = 1600, height = 900),
    getRandomImageUrl(width = 900, height = 1600),
    getRandomImageUrl(width = 500, height = 500),
    getRandomImageUrl(width = 300, height = 400),
    getRandomImageUrl(width = 1600, height = 900),
    getRandomImageUrl(width = 500, height = 500),
    getRandomImageUrl(width = 900, height = 1600),
    getRandomImageUrl(width = 500, height = 500),
    getRandomImageUrl(width = 300, height = 400),
    getRandomImageUrl(width = 1600, height = 900),
    getRandomImageUrl(width = 500, height = 500),
    getRandomImageUrl(width = 500, height = 500),
    getRandomImageUrl(width = 300, height = 400),
    getRandomImageUrl(width = 1600, height = 900),
)

fun getRandomImageUrl(
    seed: Int = (0..100).random(),
    width: Int = 300,
    height: Int = width,
): String {
    return "https://picsum.photos/seed/$seed/$width/$height"
}