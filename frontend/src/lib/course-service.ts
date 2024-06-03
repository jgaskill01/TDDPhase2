import {Course} from "./course.ts";
import axios from "axios";

export const createCourse = (course: Course): Promise<Course> => axios
    .post('/api/course', course)
    .then(r => r.data)
