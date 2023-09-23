package com.atp.assignments.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atp.assignments.R
import java.util.Locale

@Preview
@Composable
fun UserInfoSection(modifier: Modifier = Modifier) {

  Column(modifier = modifier) {

    Box {

      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 36.dp), elevation = 5.dp
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(
            modifier = Modifier.padding(top = 36.dp),
            text = stringResource(id = R.string.sufyan_sattar),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
          )
          Text(text = stringResource(R.string.pakistan))

          Spacer(modifier = Modifier.height(20.dp))

          Button(modifier = Modifier
            .clip(RoundedCornerShape(30.dp)),
            onClick = {}) {
            Text(
              modifier = Modifier.padding(vertical = 6.dp, horizontal = 20.dp),
              text = stringResource(R.string.follow).uppercase(Locale.ROOT),
            )
          }
        }
      }

      Icon(
        modifier = Modifier
          .size(72.dp)
          .align(Alignment.TopCenter)
          .clip(CircleShape)
          .background(MaterialTheme.colors.secondary),
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "User Info",
        tint = Color.White
      )
    }

    Card(
      modifier = Modifier.padding(top = 20.dp),
      elevation = 5.dp
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .height(IntrinsicSize.Min)
          .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
      ) {

        Column(
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(
            text = "224",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
          )
          Text(text = "Following")
        }

        Divider(
          modifier = Modifier
            .fillMaxHeight()
            .width(1.dp),
          color = Color.Gray,
          thickness = 1.dp
        )

        Column(
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(
            text = "48.6 K",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
          )
          Text(text = "Followers")
        }

        Divider(
          modifier = Modifier
            .fillMaxHeight()
            .width(1.dp),
          color = Color.Gray,
          thickness = 1.dp
        )

        Column(
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(
            text = "3.2 M",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
          )
          Text(text = "Likes")
        }
      }
    }

  }
}