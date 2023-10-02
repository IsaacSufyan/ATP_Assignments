package com.atp.assignments.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.atp.assignments.R

@Preview
@Composable
fun CustomToolbar(modifier: Modifier = Modifier) {

    var showMenu by remember { mutableStateOf(false) }

    ConstraintLayout(
        modifier = modifier.fillMaxWidth(),
    ) {

        val (icon, title, menu) = createRefs()

        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back",
            tint = MaterialTheme.colors.onPrimary,
            modifier = Modifier.constrainAs(icon) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
                end.linkTo(title.start)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            },
        )

        Text(
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                start.linkTo(icon.end)
                end.linkTo(menu.start)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            },
            text = stringResource(R.string.profile),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onPrimary,
            fontWeight = FontWeight.Bold
        )

        Box(
            modifier = Modifier.constrainAs(menu) {
                top.linkTo(parent.top)
                start.linkTo(title.end)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            },
        ) {

            IconButton(onClick = {
                showMenu = !showMenu
            }) {
                Icon(
                    imageVector = Icons.Outlined.MoreVert,
                    contentDescription = stringResource(R.string.menu),
                    tint = MaterialTheme.colors.onPrimary,
                )
            }

            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(onClick = { }) {
                    Icon(Icons.Filled.Settings, "Setting")
                    Text("Setting", modifier = Modifier.padding(2.dp))
                }
                DropdownMenuItem(onClick = { }) {
                    Icon(Icons.Filled.ExitToApp, "Logout")
                    Text("Logout", modifier = Modifier.padding(2.dp))
                }
            }
        }
    }
}