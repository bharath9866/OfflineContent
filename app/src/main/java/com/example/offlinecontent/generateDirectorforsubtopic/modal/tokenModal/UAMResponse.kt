package com.example.offlinecontent.generateDirectorforsubtopic.modal.tokenModal

import com.google.gson.annotations.SerializedName

data class UAMResponse(
    @SerializedName("accessToken") var accessToken: String? = null,
    @SerializedName("isWalkthrough") var isWalkthrough: Boolean? = null,
    @SerializedName("isdCode") var isdCode: String? = null,
    @SerializedName("phoneNumber") var phoneNumber: String? = null,
    @SerializedName("refreshToken") var refreshToken: String? = null,
    @SerializedName("tenantName") var tenantName: String? = null,
    @SerializedName("userDto") var userDto: UserDto? = UserDto(),
)

data class Board(
    @SerializedName("active") var active: Boolean? = null,
    @SerializedName("boardId") var boardId: Int? = null,
    @SerializedName("createdTime") var createdTime: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("name") var name: String? = null,
)


data class Campus(
    @SerializedName("active") var active: Boolean? = null,
    @SerializedName("address") var address: String? = null,
    @SerializedName("campusId") var campusId: Int? = null,
    @SerializedName("campusName") var campusName: String? = null,
    @SerializedName("city") var city: String? = null,
    @SerializedName("contact") var contact: String? = null,
    @SerializedName("createdBy") var createdBy: Int? = null,
    @SerializedName("createdTime") var createdTime: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("pincode") var pincode: String? = null,
    @SerializedName("state") var state: String? = null,
    @SerializedName("tenant_id") var tenantId: Int? = null,
)


data class Exams(
    @SerializedName("active") var active: Boolean? = null,
    @SerializedName("createdTime") var createdTime: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("examId") var examId: Int? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("name") var name: String? = null,
)

data class Grade(
    @SerializedName("active") var active: Boolean? = null,
    @SerializedName("createdTime") var createdTime: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("gradeId") var gradeId: Int? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("name") var name: String? = null,
)


data class Products(
    @SerializedName("active") var active: Boolean? = null,
    @SerializedName("createdTime") var createdTime: String? = null,
    @SerializedName("productId") var productId: Int? = null,
    @SerializedName("productName") var productName: String? = null,
)

data class Roles(
    @SerializedName("active") var active: Boolean? = null,
    @SerializedName("createdTime") var createdTime: String? = null,
    @SerializedName("displayName") var displayName: String? = null,
    @SerializedName("errorCode") var errorCode: Int? = null,
    @SerializedName("errorMessage") var errorMessage: String? = null,
    @SerializedName("roleCode") var roleCode: String? = null,
    @SerializedName("roleId") var roleId: Int? = null,
    @SerializedName("roleName") var roleName: String? = null,
    @SerializedName("success") var success: Boolean? = null,
)


data class Stream(
    @SerializedName("active") var active: Boolean? = null,
    @SerializedName("createdTime") var createdTime: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("streamId") var streamId: Int? = null,
    @SerializedName("tenantId") var tenantId: Int? = null,
)

data class Subjects(
    @SerializedName("boardId") var boardId: Int? = null,
    @SerializedName("gradeId") var gradeId: Int? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("subjectId") var subjectId: Int? = null,
    @SerializedName("subjectName") var subjectName: String? = null,
)

data class UserType(
    @SerializedName("active") var active: Boolean? = null,
    @SerializedName("createdTime") var createdTime: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("tenantId") var tenantId: Int? = null,
    @SerializedName("userTypeId") var userTypeId: Int? = null,
)


data class UserDto(
    @SerializedName("academicSection") var academicSection: String? = null,
    @SerializedName("activationtest") var activationtest: Boolean? = null,
    @SerializedName("active") var active: Boolean? = null,
    @SerializedName("admissionNumber") var admissionNumber: String? = null,
    @SerializedName("batch") var batch: String? = null,
    @SerializedName("board") var board: Board? = Board(),
    @SerializedName("campus") var campus: ArrayList<Campus> = arrayListOf(),
    @SerializedName("country") var country: String? = null,
    @SerializedName("createdTime") var createdTime: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("designation") var designation: String? = null,
    @SerializedName("dob") var dob: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("exams") var exams: ArrayList<Exams> = arrayListOf(),
    @SerializedName("firstName") var firstName: String? = null,
    @SerializedName("gender") var gender: String? = null,
    @SerializedName("grade") var grade: Grade? = Grade(),
    @SerializedName("guardianName") var guardianName: String? = null,
    @SerializedName("guardianPhone") var guardianPhone: String? = null,
    @SerializedName("isPassSet") var isPassSet: Boolean? = null,
    @SerializedName("isProfileComplete") var isProfileComplete: Boolean? = null,
    @SerializedName("isWalkthrough") var isWalkthrough: Boolean? = null,
    @SerializedName("isdCode") var isdCode: String? = null,
    @SerializedName("lastLoggedInTime") var lastLoggedInTime: String? = null,
    @SerializedName("lastName") var lastName: String? = null,
    @SerializedName("loginCount") var loginCount: Int? = null,
    @SerializedName("modifiedTime") var modifiedTime: String? = null,
    @SerializedName("password") var password: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("products") var products: ArrayList<Products> = arrayListOf(),
    @SerializedName("profilePhoto") var profilePhoto: String? = null,
    @SerializedName("roles") var roles: ArrayList<Roles> = arrayListOf(),
    @SerializedName("stream") var stream: Stream? = Stream(),
    @SerializedName("subTenant") var subTenant: Int? = null,
    @SerializedName("subjects") var subjects: ArrayList<Subjects> = arrayListOf(),
    @SerializedName("tenantId") var tenantId: Int? = null,
    @SerializedName("uid") var uid: String? = null,
    @SerializedName("userId") var userId: Int? = null,
    @SerializedName("userType") var userType: UserType? = UserType(),
    @SerializedName("whatsappConsent") var whatsappConsent: Boolean? = null,
)