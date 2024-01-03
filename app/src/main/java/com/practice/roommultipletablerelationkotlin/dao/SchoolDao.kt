package com.practice.roommultipletablerelationkotlin.dao

import androidx.room.*
import com.practice.roommultipletablerelationkotlin.entities.*
import com.practice.roommultipletablerelationkotlin.entities.relations.*

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    //One to One Relation
    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String) : List<SchoolAndDirector>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    //One to N Relation
    @Transaction
    @Query("SELECT * FROM School WHERE schoolName= :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)


//    //M to N Relation
//    @Transaction
//    @Query("SELECT * FROM Subject WHERE subjectName= :subjectName")
//    suspend fun getStudentsOfSubject(subjectName: String): List<SchoolWithStudents>

    //M to N Relation
    @Transaction
    @Query("SELECT * FROM Subject WHERE subjectName= :subjectName")
    suspend fun getStudentsOfSubject(subjectName: String): List<SubjectWithStudents>

    //M to N Relation
    @Transaction
    @Query("SELECT * FROM Student WHERE studentName= :studentName")
    suspend fun getSubjectsOfStudent(studentName: String): List<StudentWithSubjects>

}