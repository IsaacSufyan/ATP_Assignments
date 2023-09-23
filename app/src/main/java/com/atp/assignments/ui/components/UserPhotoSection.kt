package com.atp.assignments.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atp.assignments.R

@Preview
@Composable
fun UserPhotoSection(modifier: Modifier = Modifier) {

  Card(
    modifier = modifier,
    elevation = 5.dp
  ) {
    Column(modifier = Modifier.padding(20.dp)) {

      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Text(
          text = "Photos",
          fontWeight = FontWeight.Bold,
          fontSize = 20.sp
        )
        Text(text = "See All".uppercase())
      }

      Row(
        modifier = Modifier
          .fillMaxWidth()
          .height(150.dp)
          .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {

        Image(
          modifier = Modifier
            .padding(end = 10.dp)
            .weight(2f)
            .fillMaxHeight()
            .clip(RoundedCornerShape(10.dp)),
          painter = painterResource(id = R.drawable.karachi),
          contentDescription = "Karachi",
          contentScale = ContentScale.FillBounds
        )

        Image(
          modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .clip(RoundedCornerShape(10.dp)),
          painter = painterResource(id = R.drawable.karachi),
          contentDescription = "Lahore",
          contentScale = ContentScale.FillBounds
        )
      }
    }
  }
}