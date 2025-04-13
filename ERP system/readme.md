# Readme File

## OOPS CONCEPT USED
1) Generic Programming- I have made a generic class of feedback.
This class can be used to store feedback of different students of different data types. 
This class is designed to store responses from different students, allowing for flexibility in data handling.
In the feedback generic class you can write feedback of different type such as integer and string for
course rating and textual message respectively.

2) Object classes - TA class is inheriting from student class all its functionality in 
addition to functions limited to only TA. Inheritance allows one class to derive properties and behaviors from another, promoting code reuse.


3) Exception handling - Exception handling is simply the use of exception class where a runtime error can occur. 
To prevent such error exception handling is used to make sure that no such fault occur in the code.
3 such exception classes are made to handle course drop deadline , course limit reached and avoid Invalid login.


## Assumptions
I have made the following assumptions-
1) Drop course deadline is 150 seconds from the start of code till drop course functionality used 
assuming each second to be one day.
2) Some Data is hardcoded in Main clas for smooth testing of the code and avoid entering the data again and again.
3) Feedback can take input in String and Integer format.
4) TA can be assigned by the administrator for the specidied course.
5) TA can use all the functionality of the students.

## DEMONSTRATIONS 
1) Feedback systems-Allows students to provide feedback on courses they have completed.
   Students can submit a numeric rating (1–5) and/or textual comments about their courses.
   Feedback is stored in a generic class, which can handle different data types.

2) TA functionality- TA can view the course for which they are the assigned TA and also can see class timings, credits etc.
They can update student grades or view student grades but cannot update the course details like professor.

3) Exception handling-Custom exceptions handle various error scenarios during course registration like course strength full or course drop failure or
in handle failure in login.

Cases where exception handling is used-:
1) Course drop deadline passed
2) Invalid Login credentials
3) Course registration failure when course is already full


