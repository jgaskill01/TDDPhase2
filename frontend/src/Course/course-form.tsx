import {useState} from "react";
import {createCourse} from "../lib/course-service.ts";

const CourseForm = () => {

    const [title, setTitle] = useState<string>('')
    const [description, setDescription] = useState<string>('')
    const [number, setNumber] = useState<string>('')

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
       e.preventDefault();
       await createCourse({
           title, description, number
       })
    }

    return (
        <>
            <h1>Create Course</h1>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor={'course-title'}>Course Title</label>
                    <input id={'course-title'} type={"text"} value={title} onChange={(e) => setTitle(e.target.value)}/>
                </div>
                <div>
                    <label htmlFor={'course-description'}>Course Description</label>
                    <input id={'course-description'} type={"text"} value={description}
                           onChange={(e) => setDescription(e.target.value)}/>
                </div>
                <div>
                    <label htmlFor={'course-number'}>Course Number</label>
                    <input id={'course-number'} type={"text"} value={number}
                           onChange={(e) => setNumber(e.target.value)}/>
                </div>
                <div>

                    <button>
                        Save
                    </button>
                </div>
            </form>

        </>

    )
}

export default CourseForm