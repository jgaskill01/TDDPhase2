import {render, screen} from '@testing-library/react'
import '@testing-library/jest-dom'
import App from "../app.tsx";

describe('App', () => {
  it('should render the app', () => {
    render(<App/>)
    expect(screen.getByRole('heading', { name: /courses/i })).toBeVisible()
    expect(screen.getByRole('heading', {name: /create course/i})).toBeVisible()
  });



});