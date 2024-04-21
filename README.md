# Virtual classroom(Object Oriented Programming Project)


The Virtual Classroom Platform has been meticulously designed to create a dynamic learning environment that caters to the needs of both students and instructors. Leveraging robust principles of object-oriented programming in Java, our system architecture revolves around six core classes, each playing a pivotal role in facilitating seamless interactions and efficient management of educational resources.

## Core Classes

1. **Person Class**
   - The cornerstone for user management and authentication.
   - Encapsulates essential functionalities for user identification and access control.
   - Provides a solid foundation for specialized roles such as Student and Instructor.
   - Exception handling ensures secure and reliable interactions.
   - Password restrictions: At least 8 characters, including one capital letter and one special character.

2. **Student Class**
   - Extends the Person class.
   - Offers students a comprehensive suite of tools for course enrollment and assignment submission.
   - Seamless navigation through available courses and enrollment in desired subjects.

3. **Instructor Class**
   - Also a subclass of Person.
   - Empowers instructors to:
     - Add and delete courses.
     - Set assignment deadlines.
     - Review student submissions.
   - Fosters collaborative learning environments.

4. **Course Class**
   - Central to curriculum management.
   - Each course instance encapsulates:
     - Course schedule.
     - Instructor information.
     - Enrolled students.
     - Maximum capacity.
     - Repository of assignments.
   - Efficient organization and delivery of course content.

5. **Assignment Class**
   - Complements course management.
   - Provides a structured framework for:
     - Assignment creation.
     - Submission.
     - Grading.
   - Instructors define parameters, set deadlines, and review submissions.

6. **Deadline Class**
   - Defines submission deadlines for assignments.
   - Specifies start and end times.
   - Ensures students are aware of timeframes for completion.

Defines submission deadlines for assignments.
Specifies start and end times.
Ensures students are aware of timeframes for completion.
