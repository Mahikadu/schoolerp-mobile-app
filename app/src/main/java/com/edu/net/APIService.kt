package com.edu.net

import com.edu.DataModel.Divisions
import com.edu.DataModel.Employee
import com.edu.DataModel.Standards
import com.edu.DataModel.Student
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("students")
    fun getStudents(@Query("standardId") standarId: Int, @Query("divisionId")divisionId: Int): io.reactivex.Observable<List<Student>>

    @GET("employees")
    fun getEmployees(): io.reactivex.Observable<List<Employee>>

    @GET("divisions")
    fun getDivisions(): io.reactivex.Observable<List<Divisions>>

    @GET("standards")
    fun getStandards(): io.reactivex.Observable<List<Standards>>

    /**
     * companion object to create employee api service
     */
    companion object Factory{
        fun create(): APIService {
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://dev.cloudscripts.co.in:8081/schoolManagement/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(APIService::class.java);
        }
    }
}