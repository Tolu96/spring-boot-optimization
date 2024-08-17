#!/bin/bash

npm install axios

npx esbuild ./src/main/resources/scripts/Insert_student_script.js --bundle --platform=node --outfile=student_out.js && node student_out.js
npx esbuild ./src/main/resources/scripts/Insert_course_script.js --bundle --platform=node --outfile=course_out.js && node course_out.js
npx esbuild ./src/main/resources/scripts/Insert_exam_script.js --bundle --platform=node --outfile=exam_out.js && node exam_out.js

rm -rf node_modules package-lock.json student_out.js course_out.js exam_out.js
