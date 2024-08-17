import axios from "axios";

let gradeScale = [1.0, 1.3, 1.7, 2.0, 2.3, 2.7, 3.0, 3.3, 3.7, 4.0, 5.0];

async function fetchStudentIds() {
  try {
    const response = await axios.get("http://localhost:8080/api/v1/student", {
      headers: {
        "Content-Type": "application/json",
      },
    });
    return response.data.map((student) => student.studentId);
  } catch (error) {
    console.error("Error fetching student IDs", error);
    return [];
  }
}

async function insertExams() {
  const studentIds = await fetchStudentIds();

  for (let i = 1; i < 500001; i++) {
    try {
      await axios.post(
        "http://localhost:8080/api/v1/exam/",
        {
          attempt: Math.floor(Math.random() * 12),
          grade: gradeScale[Math.floor(Math.random() * gradeScale)],
          annotation: Math.floor(Math.random() * 5),
          student: {
            studentId:
              studentIds[Math.floor(Math.random() * studentIds.length)],
          },
          course: {
            courseId: Math.floor(Math.random() * 1000) + 1,
          },
        },
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
      console.log(`Successfully inserted exam ${i}`);
    } catch (error) {
      console.error(`Error while inserting exam ${i}`, error);
    }
  }
}
insertExams();