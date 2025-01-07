# Coding Blox: Online Coding Platform

## Overview
Coding Blox is an online coding platform that allows users to create accounts, host coding contests, and participate in contests hosted by others. The platform supports:

- User management
- Question and contest creation
- Contest participation and scoring
- Leaderboard display
- Additional features like contest history and withdrawal

---

## Features

### User Management
- **Command:** `CreateUser <user_name>`
  - Registers a user with a default score of 1500.
  - Example:
    ```
    CreateUser Ross
    CreateUser Monica
    ```

### Question Management
- **Command:** `CreateQuestion <difficulty_level> <score>`
  - Creates a question with a specified difficulty level (`LOW`, `MEDIUM`, `HIGH`) and score.
  - Questions are assigned an auto-incrementing `QuestionId` starting from 1.
  - Example:
    ```
    CreateQuestion LOW 10
    CreateQuestion HIGH 50
    ```

- **Command:** `ListQuestion <difficulty_level>`
  - Lists all questions or filters questions by difficulty level.
  - Example:
    ```
    ListQuestion LOW
    ListQuestion
    ```

### Contest Management
- **Command:** `CreateContest <contest_name> <contest_level> <contest_creator_user_name>`
  - Creates a contest with the specified name, level (`LOW`, `MEDIUM`, `HIGH`), and creator. The creator is automatically added as a participant.
  - Contests are assigned an auto-incrementing `ContestId` starting from 1.
  - Example:
    ```
    CreateContest diwali_contest LOW Ross
    ```

- **Command:** `ListContest <difficulty_level>`
  - Lists all contests or filters contests by difficulty level.
  - Example:
    ```
    ListContest LOW
    ListContest
    ```

### Contest Participation
- **Command:** `AttendContest <contest_id> <user_name>`
  - Registers a user for a contest.
  - Example:
    ```
    AttendContest 1 Monica
    AttendContest 1 Joey
    ```

- **Command:** `RunContest <contest_id> <contest_creator_user_name>`
  - Starts the contest. Only the contest creator can execute this command.
  - Automatically generates random questions solved by users based on the contest level.
  - Updates user scores based on:
    - **LOW:** `newScore = currentScore + (currentContestPoints - 50)`
    - **MEDIUM:** `newScore = currentScore + (currentContestPoints - 30)`
    - **HIGH:** `newScore = currentScore + (currentContestPoints)`
  - Example:
    ```
    RunContest 1 Ross
    ```

### Leaderboard
- **Command:** `LeaderBoard <sorting_order>`
  - Displays the leaderboard sorted by scores in ascending (`asc`) or descending (`desc`) order.
  - Example:
    ```
    LeaderBoard score desc
    ```

### Bonus Features
- **Command:** `ContestHistory <contest_id>`
  - Displays the leaderboard for a specific contest, showing usernames, points secured, and questions solved.
  - Example:
    ```
    ContestHistory 1
    ```

- **Command:** `WithdrawContest <contest_id> <user_name>`
  - Allows users to withdraw from a contest before it starts. Contest creators cannot withdraw.
  - Example:
    ```
    WithdrawContest 1 Joey
    ```

---

## Expectations
1. **Sample Data:** Add sample users, questions, and contests in the main driver program or test cases.
2. **Code Structure:** Follow modular and object-oriented design principles.
3. **Extensibility:** Use interfaces and contracts to facilitate easy addition/removal of functionality.
4. **Error Handling:** Handle edge cases gracefully.
5. **Readability:** Ensure the code is readable, maintainable, and adheres to DRY principles.

---

## Example Workflow
1. Create users:
   ```
   CreateUser Ross
   CreateUser Monica
   ```

2. Add questions:
   ```
   CreateQuestion LOW 10
   CreateQuestion HIGH 50
   ```

3. Create a contest:
   ```
   CreateContest diwali_contest LOW Ross
   ```

4. Attend the contest:
   ```
   AttendContest 1 Monica
   AttendContest 1 Joey
   ```

5. Run the contest:
   ```
   RunContest 1 Ross
   ```

6. Display the leaderboard:
   ```
   LeaderBoard score desc
   ```

7. View contest history:
   ```
   ContestHistory 1
   ```

---

## Notes
- The platform supports auto-incrementing IDs for questions and contests.
- Users start with a default score of 1500.
- Contest questions are selected based on the difficulty level of the contest.

---

## Running the Program
To run the program, include all commands in the main driver file or test case file. Execute the file and interact with the platform using the supported commands.

---

## License
This project is open-source and can be used for educational and non-commercial purposes.

