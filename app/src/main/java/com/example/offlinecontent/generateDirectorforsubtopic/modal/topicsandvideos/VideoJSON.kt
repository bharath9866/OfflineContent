package com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandvideos

data class VideoJSON(
    var user: User? = User()
)

data class User(
    var userId: Int? = null,
    var grade: Grade? = Grade()
)

data class Grade(
    var gradeId: Int? = null,
    var exam: Exam? = Exam()
)

data class Exam(
    var examId: Int? = null,
    var subjects: ArrayList<Subject> = arrayListOf()
)

data class Subject(
    var subjectId: Int? = null,
    var chapters: ArrayList<Chapter> = arrayListOf()
)


data class Chapter(
    var chapterId: Int? = null,
    var videoNo: ArrayList<String>? = arrayListOf(),
    var topics: ArrayList<Topic>? = arrayListOf()
)

data class Topic(
    var topicId:Int? = null,
    var subTopics: ArrayList<Subtopic>? = arrayListOf()
)

data class Subtopic(
    var subTopicId:Int? = null,
    var imageNo: ArrayList<String>? = arrayListOf()
)

var temp = VideoJSON(
    User(
        2226481, Grade(
            3, Exam(
                2,
               subjects = arrayListOf(
                    Subject(
                        1,
                        chapters = arrayListOf(
                            Chapter(
                                99,
                                videoNo = arrayListOf("1643295762992.mp4", "1643295764120.mp4"),
                                topics = arrayListOf(
                                    Topic(
                                        1067, arrayListOf(
                                            Subtopic(
                                                2410,
                                                arrayListOf("1638252025112.jpg")
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
    )
)

