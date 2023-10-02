package com.atp.assignments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
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

        Image(
            painterResource(id = R.drawable.top_shape),
            "",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.FillBounds
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(10.dp)
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(MaterialTheme.colors.primary)
        )

        ConstraintLayout(modifier = Modifier.fillMaxSize()) {

            val (toolbar, sectionLayout) = createRefs()

            CustomToolbar(
                modifier = Modifier
                    .padding(20.dp)
                    .constrainAs(toolbar) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(sectionLayout.top)
                        width = Dimension.fillToConstraints
                        height = Dimension.wrapContent
                    }
            )

            ConstraintLayout(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .constrainAs(sectionLayout) {
                        top.linkTo(toolbar.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    },
            ) {


                val (userInfoSection, userFriendSection, userPhotoSection) = createRefs()

                UserInfoSection(
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .constrainAs(userInfoSection) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                            height = Dimension.wrapContent
                        }
                )

                UserFriendsSection(
                    modifier = Modifier
                        .padding()
                        .constrainAs(userFriendSection) {
                            top.linkTo(userInfoSection.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                            height = Dimension.wrapContent
                        }
                )

                UserPhotoSection(
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .constrainAs(userPhotoSection) {
                            top.linkTo(userFriendSection.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                            height = Dimension.wrapContent
                        }
                )
            }
        }
    }
}