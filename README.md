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

- 4/21: (78% Completed)
    - Turned off spring security and implemented admin pages
  ######
- 4/22 (80% completed)
  - Implementation of sessions with logging in
  - Finished implementation of pulling the logged in user information and gardens that are tied with them
  - Connected the user and gardens that they created
  ######
- 4/20 (76% Completed)
  - Troubleshooting issues with a CRUD function not working with Spring Security
######
- 4/19: (75% completed)
    - Troubleshooting GitHub issues with branches not merged properly to master before branching again
#####
- 4/18: (70% completed)
    - Implementation of Spring Security
    - Troubleshooting issues with Spring Security with JS and CSS
    - Troubleshooting issues with Spring Security Registration Page
#####
- 4/15: (55-60% completed)
    - Completion of CRUD operations
  #####
- 4/1-4/14: (50% completed)
    - Implementation of CRUD operations on Registration and Create Garden


    


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

- Implementation of user to check if they had tried to create this garden in their environment
- Implementation of user to have a description/review of the garden that they have tried
- Implementation of Mobile option 
- Implementation of Mobile Application
- Implement vue/react etc so that navigation bar is not duplicated among all of the html pages
- 