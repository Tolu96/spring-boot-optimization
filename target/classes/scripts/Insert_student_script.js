import axios from "axios";

function getRandomBirthDate(startDate, endDate) {
  const start = new Date(startDate).getTime();
  const end = new Date(endDate).getTime();
  const randomBirthDate = new Date(start + Math.random() * (end - start));
  return randomBirthDate.toISOString().split("T", 1)[0];
}

async function insertStudents() {
  for (let i = 1; i < 300001; i++) {
    try {
      await axios.post(
        "http://localhost:8080/api/v1/student/",
        {
          firstName: `Mustervorname ${i}`,
          lastName: `Musternachname ${i}`,
          birthDate: getRandomBirthDate("1980-01-01", "2006-01-01"),
          ectsPoints: Math.floor(Math.random() * 120),
          malusPoints: Math.floor(Math.random() * 90),
          semesterFeesPaid: Math.random() >= 0.5,
          semester: Math.floor(Math.random() * 11) + 1,
          degreeProgram: {
            degreeProgramId: Math.floor(Math.random() * 26) + 1,
          },
        },
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
      console.log(`Successfully inserted student ${i}`);
    } catch (error) {
      console.error(`Error while inserting student ${i}`, error);
    }
  }
}

insertStudents();
