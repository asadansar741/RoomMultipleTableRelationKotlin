package com.practice.roommultipletablerelationkotlin.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.practice.roommultipletablerelationkotlin.entities.Student
import com.practice.roommultipletablerelationkotlin.entities.StudentSubjectCrossRef
import com.practice.roommultipletablerelationkotlin.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students: List<Student>
)
