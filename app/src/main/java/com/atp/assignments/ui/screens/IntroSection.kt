@file:JvmName("IntroSectionKt")

package com.atp.assignments.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.atp.assignments.R
import com.atp.assignments.ui.theme.SimpleTextTypo
import com.atp.assignments.ui.theme.SubTitleTypo
import com.atp.assignments.ui.theme.TitleTypo

@Composable
fun IntroSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.sufyan_sattar),
            modifier = Modifier.fillMaxWidth(),
            style = TitleTypo,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.sr_consultant_developer),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            style = SimpleTextTypo,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.professional_summary),
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            style = SubTitleTypo
        )
        Text(
            text = stringResource(id = R.string.professional_summary_details),
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            style = SimpleTextTypo
        )
    }
}