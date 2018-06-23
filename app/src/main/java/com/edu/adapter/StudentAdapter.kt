package com.edu.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edu.DataModel.Student
import com.edu.R
import kotlinx.android.synthetic.main.attendance_record.view.*

/**
 * Created by ufewx4 on 4/30/2018.
 */
class StudentAdapter (val studentsList: List<Student>, val clickListener: (Student) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context);
        val view = inflater.inflate(R.layout.attendance_record, parent, false);
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as StudentViewHolder).bind(studentsList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return studentsList.size
    }

    class StudentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(students: Student, clickListener: (Student) -> Unit){
            itemView.tv_student_id.text = students.student_id.toString()
            itemView.tv_student_name.text = students.firstName
            itemView.cb_ispresent.isChecked = true
        }
    }
}