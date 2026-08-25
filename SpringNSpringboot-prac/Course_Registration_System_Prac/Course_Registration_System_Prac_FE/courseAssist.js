function showAvailableCourses() {
    fetch("http://localhost:8080/courses")
    .then((res) => res.json())
    .then((courses) => {
        const dataTable = document.getElementById("availCoursesTBody");

        courses.forEach(course => {
            var row =  `<tr>
                            <td>${course.courseId}</td>
                            <td>${course.courseName}</td>
                            <td>${course.courseInstructor}</td>
                            <td>${course.courseDuration}</td>
                        </tr>`

            dataTable.innerHTML += row;
        })
    });
}

function showEnrolledStudents() {
    fetch("http://localhost:8080/courses/getEnrolled")
    .then((res) => res.json())
    .then((enrolled) => {
        const enrolTable = document.getElementById("enrolledStudentsTBody");

        enrolled.forEach(enrol => {
            var row =  `<tr>
                            <td>${enrol.rno}</td>
                            <td>${enrol.Name}</td>
                            <td>${enrol.email}</td>
                            <td>${enrol.courseName}</td>
                        </tr>`

            enrolTable.innerHTML += row;
        })
    });
}