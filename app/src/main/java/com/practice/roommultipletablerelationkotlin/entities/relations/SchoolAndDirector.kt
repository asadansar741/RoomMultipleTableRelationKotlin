package com.practice.roommultipletablerelationkotlin.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.practice.roommultipletablerelationkotlin.entities.Director
import com.practice.roommultipletablerelationkotlin.entities.School

data class SchoolAndDirector(   //One to One Relation
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)
