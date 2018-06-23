package com.edu.DataModel



data class Student(
    val student_id: Int,
    val academicYear: String,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val dob: String,
    val gender: String,
    val bloodGroup: String,
    val category: String,
    val caste: String,
    val religion: String,
    val standard: Standard,
    val division: Division,
    val nationality: String,
    val permanentAddress: String,
    val correspondenceAddress: String,
    val country: String,
    val state: String,
    val city: String,
    val postalCode: String,
    val father: Father,
    val mother: Mother,
    val guardian: Guardian
)