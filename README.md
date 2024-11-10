# Community Forum

This project is a community forum with a Spring Boot backend and a frontend in HTML, CSS, and JavaScript. Users can register, create posts, and add comments. Each post displays its content along with comments from various users.

## Features
- Register a new user
- View all posts or individual post details
- Create a new post (requires username and password)
- Add comments to a post (requires username and password)

## Color Palette
- **Primary**: #006953
- **Secondary**: #A9C7B8
- **Background**: #F7F6F2

## API Endpoints

Below is a list of available API endpoints and their usage.

### User Endpoints

| Method | Endpoint              | Description            | Request JSON                                          | Response          |
|--------|------------------------|------------------------|-------------------------------------------------------|--------------------|
| GET    | `/api/users`          | Get all users          | None                                                  | List of users      |
| GET    | `/api/users/{id}`     | Get user by ID         | None                                                  | User details       |
| POST   | `/api/users/register` | Register a new user    | `{ "username": "string", "password": "string" }`      | Status message     |

### Post Endpoints

| Method | Endpoint           | Description          | Request JSON                                         | Response          |
|--------|---------------------|----------------------|------------------------------------------------------|--------------------|
| GET    | `/api/posts`       | Get all posts        | None                                                 | List of posts      |
| GET    | `/api/posts/{id}`  | Get post by ID       | None                                                 | Post details       |
| POST   | `/api/posts`       | Create a new post    | `{ "username": "string", "password": "string", "title": "string", "content": "string" }` | Status message |

### Comment Endpoints

| Method | Endpoint                    | Description              | Request JSON                                           | Response          |
|--------|------------------------------|--------------------------|--------------------------------------------------------|--------------------|
| POST   | `/api/posts/{id}/comments`   | Add a comment to a post  | `{ "username": "string", "password": "string", "content": "string" }` | Status message     |

## Running the Project

1. **Backend**:
   - Set up and start the Spring Boot application to serve API requests.

2. **Frontend**:
   - Open the `index.html` file in a browser to interact with the forum’s UI.

