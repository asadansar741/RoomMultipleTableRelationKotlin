package com.practice.roommultipletablerelationkotlin.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Director (
    @PrimaryKey(autoGenerate = false)
    val directorName: String,
    val schoolName: String
)