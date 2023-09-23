package com.atp.assignments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atp.assignments.ui.components.CustomToolbar
import com.atp.assignments.ui.components.UserFriendsSection
import com.atp.assignments.ui.components.UserInfoSection
import com.atp.assignments.ui.components.UserPhotoSection
import com.atp.assignments.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      AppTheme {
        ProfileScreen()
      }
    }
  }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
  AppTheme {
    ProfileScreen()
  }
}

@Composable
fun ProfileScreen() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(MaterialTheme.colors.background)
  ) {

    /** Top Design **/
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(250.dp)
        .clip(AbsoluteCutCornerShape(bottomRight = 60.dp, bottomLeft = 60.dp))
        .background(MaterialTheme.colors.primary)
    )

    /** Bottom Design **/
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .align(Alignment.BottomCenter)
        .height(10.dp)
        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
        .background(MaterialTheme.colors.primary)
    )

    Column {

      CustomToolbar(modifier = Modifier.padding(20.dp))

      Column(
        modifier = Modifier
          .padding(horizontal = 20.dp)
          .fillMaxSize()
          .verticalScroll(
            rememberScrollState()
          ),
      ) {


        UserInfoSection(
          modifier = Modifier.padding(vertical = 20.dp)
        )

        UserFriendsSection(
          modifier = Modifier.padding()
        )

        UserPhotoSection(
          modifier = Modifier.padding(vertical = 20.dp)
        )

      }

    }



  }
}