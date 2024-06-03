import {render, screen} from "@testing-library/react";
import CourseForm from "../Course/course-form.tsx";
import {Course} from "../lib/course.ts";
import {userEvent} from "@testing-library/user-event";
//import services for mocking
import * as courseService from '../lib/course-service.ts'
import {expect} from "vitest";



describe('Course form', () => {
    it('should not call createCourse when form is empty', async () => {
        //spy on createCourse function and mock return value
        const mockCreateCourse = vi.spyOn(courseService, 'createCourse')
            .mockResolvedValue({} as Course)
        render(<CourseForm/>)

            //click on save button
        await userEvent.click(screen.getByRole('button', {name: /save/i}))
            //expect mock to have been called times 0
        expect(mockCreateCourse).toHaveBeenCalledTimes(0);
    });

    it('should call createCourse with values from form',  async () => {
        const mockCreateCourse = vi.spyOn(courseService, 'createCourse')
            .mockResolvedValue({} as Course)
        render(<CourseForm/>)

        const titleInput = screen.getByRole('textbox', {name: /Course Title/i})
        const descriptionInput = screen.getByRole('textbox', {name: /Course Description/i})
        const numberInput = screen.getByRole('textbox', {name: /Course Number/i})


        const user = userEvent.setup()
        await user.type(titleInput, 'title')
        await user.type(descriptionInput, 'description')
        await user.type(numberInput, 'number')

        await userEvent.click(screen.getByRole('button', {name: /save/i}))

        expect(mockCreateCourse).toHaveBeenCalledOnce()
        expect(mockCreateCourse).toHaveBeenCalledWith({
            title: 'title',
            description: 'description',
            number: 'number'
        })
    });
})