CREATE INDEX idx_exam_id ON EXAM(exam_id);
CREATE INDEX idx_exam_student_id ON EXAM(student_id);
CREATE INDEX idx_student_id ON STUDENT(student_id);
CREATE INDEX idx_student_number ON STUDENT(student_number);
CREATE INDEX idx_student_degree_program_id ON STUDENT(degree_program_id);
CREATE INDEX idx_student_semester_degree_program ON STUDENT(semester, degree_program_id);