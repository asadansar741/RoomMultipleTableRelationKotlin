package com.practice.roommultipletablerelationkotlin.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.practice.roommultipletablerelationkotlin.entities.Student
import com.practice.roommultipletablerelationkotlin.entities.StudentSubjectCrossRef
import com.practice.roommultipletablerelationkotlin.entities.Subject

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)
