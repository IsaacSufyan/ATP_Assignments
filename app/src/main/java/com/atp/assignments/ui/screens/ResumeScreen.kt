package com.atp.assignments.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.atp.assignments.R
import com.atp.assignments.ui.theme.LightPurple
import com.atp.assignments.ui.theme.SimpleTextTypo
import com.atp.assignments.ui.theme.TitleTypo

@Composable
fun ResumeScreen() {
    val skillsList = mutableListOf<String>().apply {
        add("Android")
        add("Clean Architecture")
        add("Modularizing App Development")
        add("Spring Boot")
        add("Spring")
        add("React")
        add("AWS")
        add("Azure")
        add("Microservices")
        add("Vaadin")
        add("Firebase")
        add("ParseDB")
        add("PostgreSQL")
        add("JPA")
        add("Hibernate")
        add("Onion Architecture")
    }

    val languageList = mutableListOf<String>().apply {
        add("English")
        add("Urdu")
        add("Punjabi")
    }

    val hobbiesList = mutableListOf<String>().apply {
        add("Travelling")
        add("Hiking")
        add("Cricket")
        add("Coin Collection")
        add("History")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightPurple)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        IntroSection()
        ExperienceSection()
        BulletSection(stringResource(id = R.string.skills),skillsList)
        BulletSection(stringResource(id = R.string.language),languageList)
        BulletSection(stringResource(id = R.string.hobbies),hobbiesList)
    }
}