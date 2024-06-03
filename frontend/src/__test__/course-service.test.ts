import {describe, expect} from "vitest";
import {server} from "./mocks/node.ts";
import {http, HttpResponse} from "msw";
import {createCourse} from "../lib/course-service.ts";

describe('Course Service', () =>{
    it('should post new course to correct path', () => {

        //SET UP MOCKED ENDPOINT
        server.use(http.post('/api/course', () =>{
            return HttpResponse.json({title: 'some title'})
        }))

        //CALL FUNCTION
        const newCourse = {title: 'some title', description: 'description', number: 'number'}
        const savedCourse = await createCourse(newCourse)
        expect(savedCourse).toStrictEqual({title: 'some title'})


    });
})