# SecondServlet

A Java Servlet login example using PostgreSQL and JDBC.

## How it works

1. Open `login.html`.
2. Enter a username and password.
3. The form sends a `POST` request to `/login`.
4. `LoginServlet` checks the credentials against the PostgreSQL `users` table.
5. Valid credentials are forwarded to `WelcomeServlet`, which displays a greeting.

## Project structure

```text
src/
└── main/
    ├── java/
    │   └── com/adityabhosale/
    │       ├── LoginServlet.java
    │       └── WelcomeServlet.java
    └── webapp/
        ├── login.html
        └── WEB-INF/
            └── web.xml
