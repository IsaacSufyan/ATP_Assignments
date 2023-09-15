package com.atp.assignments.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.atp.assignments.R
import com.atp.assignments.ui.theme.SimpleTextTypo
import com.atp.assignments.ui.theme.SubTitleTypo

@Composable
fun BulletSection(title:String, list:List<String>) {

    val bullet = "\u2022"


    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            style = SubTitleTypo
        )

        list.forEach {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)) {
                Text(
                    text = bullet,
                    style = SimpleTextTypo
                )
                Text(
                    text = it,
                    modifier = Modifier
                        .padding(start = 8.dp),
                    style = SimpleTextTypo
                )
            }

        }

    }
}