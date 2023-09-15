package com.atp.assignments.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.atp.assignments.R
import com.atp.assignments.ui.Experience
import com.atp.assignments.ui.theme.SimpleTextTypo
import com.atp.assignments.ui.theme.SubTitleTypo

@Composable
fun ExperienceSection() {

    val list = mutableListOf<Experience>().apply {
        add(Experience("Metologix Pvt Ltd", "June 2018 - July 2019"))
        add(Experience("Funsol Technologies Pvt Ltd", "Oct 2029 - Nov - 2020"))
        add(Experience("AKSA-SDS Pvt Ltd", "Dec 2020 - Mar 2022"))
        add(Experience("Tkxel", "April 2022 - Jan 2023"))
        add(Experience("Systems Limited", "Feb 2023 - Current"))
        reverse()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.experiences),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            style = SubTitleTypo
        )
        list.forEach {
            Text(
                text = it.companyName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                style = SimpleTextTypo
            )
            Text(
                text = it.companyDuration,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                style = SimpleTextTypo
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                thickness = 1.dp,
                color = Color.LightGray
            )
        }

    }
}