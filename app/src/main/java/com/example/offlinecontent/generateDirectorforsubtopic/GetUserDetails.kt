package com.example.offlinecontent.generateDirectorforsubtopic

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.offlinecontent.offlineContent.getSelfResponse

@RequiresApi(Build.VERSION_CODES.N)
fun main(){
    val tenantId = 2
    val subTenantId = 0
    val userId = 136683
    val tenantName = "srichaitanya"
    val gradeId = 7
    val examId = 2
    val subjectId = 5
    val chapterId = 42
    val topicId = 504
    val subTopicId = 5057

    val token = "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiJTVzAxIiwiUm9sZU5hbWUiOiJTdHVkZW50IiwiREJJZCI6IjEzNjY4MCIsIkZpcnN0TmFtZSI6IlN3YXBuYSIsIlRlbmFudENvZGUiOiJzcmljaGFpdGFueWEiLCJMYXN0TmFtZSI6IkciLCJleHAiOjE2NTY3NTE4MzQsImlhdCI6MTY1NjY2NTQzNH0.w0OhVsk4Hj2-6FY1SmRIMSOl0aUVPB-q_VHM0LKcbQ0"

    val user_gradesController = getSelfResponse(url = "https://api.infinitylearn.com/api/users/${userId}/grades", token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId)
    println("\ngetGradeDetails: $user_gradesController")

    val grade_examController = getSelfResponse(url = "https://api.infinitylearn.com/api/${gradeId}/exams", token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId)
    println("\ngetExamDetails: $grade_examController")

}
