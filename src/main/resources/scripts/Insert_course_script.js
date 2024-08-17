import axios from "axios";

let semesterHoursScale = [
  2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0,
];

async function insertCourses() {
  for (let i = 1; i < 1001; i++) {
    try {
      await axios.post(
        "http://localhost:8080/api/v1/course/",
        {
          courseName: `Kurs ${i}`,
          semesterHours:
            semesterHoursScale[
              Math.floor(Math.random() * semesterHoursScale.length)
            ],
          courseType: Math.floor(Math.random() * 6),
          lecturer: {
            lecturerId: Math.floor(Math.random() * 45) + 1,
          },
        },
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
      console.log(`Successfully inserted course ${i}`);
    } catch (error) {
      console.error(`Error while inserting course ${i}`, error);
    }
  }
}
insertCourses();
