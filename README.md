## Anakainosis

Add some description of the app (one or two paragraph)

## Contents

- [Daily Progress](#Daily-Progess)
- [User Stories](#User-Stories)
    - [User](#User)
    - [Admin](#Admin)
- [Technical architecture](http://)
- [Technical challenegs addressed](#Technical-challenges)
- [Lessons learned from this project](#Lessons-learned)
- [Future improvements](#Future-improvements)
- [Wire frame](http://)
- [Schema diagram](http://)


## Daily Progress
- 4/1-4/14: (50% completed)
  - Implementation of CRUD operations on Registration and Create Garden
- 4/15: (55-60% completed)
  - Completion of CRUD operations

- 4/18: (70% completed)
    - Implementation of Spring Security
    - Troubleshooting issues with Spring Security with JS and CSS
    - Troubleshooting issues with Spring Security Registration Page
- 4/19: (75% completed)
  - Troubleshooting GitHub issues with branches not merged properly to master before branching again


### Login
- As an admin, I want to log in with an admin privilege so that I can edit/update the list of items (seeds, garden type, house type) in the table, check the list of users and their garden lists they have created, etc. 
    - Tasks:
        1. Create a database and a User table containing username, password and privilege.
        2. Login screen asking for username and password.
        3. Check if the username exists in the User table
        4. Check if the password matches the entry in the table
        5. Assign the privilege to the current user login session
        6. If login is successful, show the main screen with options according to login privilege.


- As a user, I want to log in with a user privilege so that I can do basic operations like entering information to create a user's garden.
    - Tasks:
        1. Same as for admin login a-e
        2. If login is successful, show the screen for their account page.

## User Stories

### User
- As a user, I want ..., so that ...

- As a user, I want ..., so that ...

#### Not implemented in this version:
- As a user, I want ..., so that ...

- As a user, I want ..., so that ...

### Admin
- As a admin, I want ..., so that ...

- As a admin, I want ..., so that ...
- 
#### Not implemented in this version:

- As a user, I want ..., so that ...

- As a user, I want ..., so that ...

- As a admin, I want ..., so that ...

- As a admin, I want ..., so that ...