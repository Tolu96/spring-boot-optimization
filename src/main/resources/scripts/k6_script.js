import http from 'k6/http';
import { check } from 'k6';

export default function () {

  let res1 = http.get('http://localhost:8080/api/v1/exam');
  console.log(`Request 1 duration: ${(res1.timings.duration / 1000).toFixed(3)} s`);
  check(res1, {
    'Abruf aller Prüfungen erfolgreich': (r) => r.status === 200,
  });

  let res2 = http.get('http://localhost:8080/api/v1/exam/00AB5143-0A9F-4971-BEC3-B15469455EE7');
  console.log(`Request 2 duration: ${(res2.timings.duration / 1000).toFixed(3)} s`);
  check(res2, {
    'Abruf der spezifischen Prüfung erfolgreich': (r) => r.status === 200,
  });

  let res3 = http.get('http://localhost:8080/api/v1/exam/findByStudent/AD9D8027-8609-41AA-ADBA-40A79F7074BE');
  console.log(`Request 3 duration: ${(res3.timings.duration / 1000).toFixed(3)} s`);
  check(res3, {
    'Abruf der Prüfungen nach Student erfolgreich': (r) => r.status === 200,
  });

  let res4 = http.get('http://localhost:8080/api/v1/student');
  console.log(`Request 4 duration: ${(res4.timings.duration / 1000).toFixed(3)} s`);
  check(res4, {
    'Abruf aller Studenten erfolgreich': (r) => r.status === 200,
  });

  let res5 = http.get('http://localhost:8080/api/v1/student/findbyStudentNumber/320120');
  console.log(`Request 5 duration: ${(res5.timings.duration / 1000).toFixed(3)} s`);
  check(res5, {
    'Abruf des Studenten nach Matrikelnummer erfolgreich': (r) => r.status === 200,
  });

  let res6 = http.get('http://localhost:8080/api/v1/student/findbyDegreeProgram/2');
  console.log(`Request 6 duration: ${(res6.timings.duration / 1000).toFixed(3)} s`);
  check(res6, {
    'Abruf der Studenten nach Studiengang erfolgreich': (r) => r.status === 200,
  });

  let res7 = http.get('http://localhost:8080/api/v1/student/findbySemesterAndDegreeProgram/2/3');
  console.log(`Request 7 duration: ${(res7.timings.duration / 1000).toFixed(3)} s`);
  check(res7, {
    'Abruf der Studenten nach Semester und Studiengang erfolgreich': (r) => r.status === 200,
  });

}
