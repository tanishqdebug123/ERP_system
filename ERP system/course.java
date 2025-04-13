import java.util.Scanner;
import java.util.ArrayList;

public class course {
    String course_code;
    int credits;
    String prof;
    ArrayList<String> student_id;
    String syllabus;
    String classtiming;
    ArrayList<course> prerequisites;
    int enrollmentlimit;
    String officehours;
    String coursetitle;
    String classroom;
    int semester;
    int enrolledstudents;
    feedback<String> f_string;
    feedback<Integer> f_int;
    student ta_course;


    course(String course_code,int credits,String prof,ArrayList<String> student_id,String syllabus,String classtiming,ArrayList<course> prerequisites,int enrollmentlimit,String officehours){
        this.course_code=course_code;
        this.credits=credits;
        this.student_id=student_id;
        this.prof=prof;
        this.syllabus=syllabus;
        this.classtiming=classtiming;
        this.prerequisites=prerequisites;
        this.enrollmentlimit=enrollmentlimit;
        this.officehours=officehours;

    }

    course(String course_code,int credits,String prof,ArrayList<course> prerequisites,String classtiming,String coursetitle,String classroom,int semester,int enrolledstudents,int enrollmentlimit){
        this.course_code=course_code;
        this.credits=credits;
        this.prof=prof;
        this.prerequisites=prerequisites;
        this.classtiming=classtiming;
        this.coursetitle=coursetitle;
        this.classroom=classroom;
        this.semester=semester;
        this.enrolledstudents=enrolledstudents;
        this.enrollmentlimit=enrollmentlimit;
        this.f_string=new feedback<>();
        this.f_int=new feedback<>();

    }

    course(String course_code,int credits,String prof){
        this.course_code=course_code;
        this.credits=credits;
        this.prof=prof;
    }
}
