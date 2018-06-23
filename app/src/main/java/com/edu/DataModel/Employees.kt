package com.edu.DataModel


data class Employee(
    val id: Int,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val nationality: String,
    val gender: String,
    val dob: String,
    val bloodGroup: String,
    val maritalStatus: String,
    val qualification: String,
    val occupation: String,
    val jobType: String,
    val employeeType: Any,
    val dateOfJoining: String,
    val aadharCardNumber: String,
    val emailId: String,
    val phoneNumber: String,
    val alternatePhoneNumber: String,
    val permanentAddress: String,
    val correspondenceAddress: String,
    val city: String,
    val state: String,
    val postalCode: String,
    val userRole: Any
)

data class Employees (val total_count: Int, val incomplete_results: Boolean, val items: List<Employee>)