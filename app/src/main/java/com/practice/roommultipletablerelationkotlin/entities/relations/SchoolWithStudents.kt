package com.practice.roommultipletablerelationkotlin.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.practice.roommultipletablerelationkotlin.entities.School
import com.practice.roommultipletablerelationkotlin.entities.Student

data class SchoolWithStudents(  //One to N Relation
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
