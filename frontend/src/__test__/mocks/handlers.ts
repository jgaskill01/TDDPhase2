import { http, HttpResponse } from 'msw'

export const handlers = [
  http.get('/api/course', () => {
    return HttpResponse.json([])
  }),
]
