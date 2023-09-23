package com.atp.assignments.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atp.assignments.R
import com.atp.assignments.ui.model.User

@Preview
@Composable
fun UserFriendsSection(modifier: Modifier = Modifier) {

  val friendsList = mutableListOf<User>().apply {
    add(User(R.drawable.ic_launcher_foreground, "A-000"))
    add(User(R.drawable.ic_launcher_foreground, "B-000"))
    add(User(R.drawable.ic_launcher_foreground, "C-000"))
    add(User(R.drawable.ic_launcher_foreground, "D-000"))
    add(User(R.drawable.ic_launcher_foreground, "E-000"))
    add(User(R.drawable.ic_launcher_foreground, "F-000"))
    add(User(R.drawable.ic_launcher_foreground, "G-000"))
    add(User(R.drawable.ic_launcher_foreground, "H-000"))
  }.toList()

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
          text = "Friends",
          fontWeight = FontWeight.Bold,
          fontSize = 20.sp
        )
        Text(text = "See All".uppercase())
      }

      LazyRow(
        Modifier
          .fillMaxWidth()
          .padding(top = 20.dp)
      ) {
        items(friendsList.size) {
          val padding = if (it == friendsList.size-1) 0.dp
          else 12.dp
          
          Column(
            modifier = Modifier.padding(end = padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
          ) {

            Icon(
              modifier = Modifier
                .padding(bottom = 5.dp)
                .size(48.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.secondary),
              painter = painterResource(friendsList[it].userImage),
              contentDescription = "User Info",
              tint = Color.White
            )

            Text(text = friendsList[it].userName)

          }
        }
      }
    }
  }

}
