import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class student extends Main{ // using Inheritance

    public ArrayList<String> student_ids = new ArrayList<>(Arrays.asList("Btech23001@gmail.com", "Btech23002@gmail.com", "Btech23003@gmail.com"));
    public ArrayList<String> student_passwords = new ArrayList<>(Arrays.asList("23001@123", "23002@123", "23003@123"));
    boolean flag=false;
    Scanner sc=new Scanner(System.in);
    boolean entry =true;
    public String st_id;
    private String password;
    public int current_semester;
    private ArrayList<course> registeredCourses;
    private ArrayList<course> completedcourse;
    double grades;
    ArrayList<Integer> course_grades;

    public student(String st_id,String password){
        this.st_id=st_id;
        this.password=password;
    }


    public student(String st_id,String password,int current_semester,ArrayList<course> registeredCourses,ArrayList<course> completedcourse,double grades){
        this.st_id=st_id;
        this.password=password;
        this.current_semester=current_semester;
        this.registeredCourses=registeredCourses;
        this.completedcourse=completedcourse;
        this.grades=grades;
    }


    public student() throws invalidlogin{
        System.out.println("1.Login or 2.Signup");
        int in=sc.nextInt();
        String student_id1;
        if(in==1) {
            while(true) {
                System.out.println("Enter your Student id: ");
                student_id1 = sc.next();
                System.out.println("Enter your password: ");
                String student_password = sc.next();

                try {
                    for (student st : students_ls) {
                        if (Objects.equals(st.st_id, student_id1) && Objects.equals(st.password, student_password)) {
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        throw new invalidlogin("Invalid login credentials");
                    }
                    else{
                        System.out.println("Congratulation You are logged in");
                        break;
                    }
                }

                catch (invalidlogin e){
                    System.out.println(e.getMessage());
                    System.out.println("Enter 1 to try again\nEnter 2 to quit");
                    int id = sc.nextInt();
                    if (id == 2) {
                        entry = false;
                        break;
                    }
                }
            }
        }

        else{
            System.out.println("Create a student id: ");
            student_id1 = sc.next();
            System.out.println("Create a strong password: ");
            String std_pass = sc.next();

            student_ids.add(student_id1);
            student_passwords.add(std_pass);
            System.out.println("Enter your current semester: ");
            int sem=sc.nextInt();

            ArrayList<course> t1=new ArrayList<>();
            ArrayList<course> t2=new ArrayList<>();
            student stt=new student(student_id1,std_pass,sem,t1,t2,0);
            students_ls.add(stt);
            System.out.println("Congratulation You are logged in");

        }


        while(true && entry==true){
            System.out.println("Enter one of the following commands\n1.View available courses\n2.Register for course\n3.View Schedule\n4.Track academic progress\n5. Drop course\n6.Submit complaints\n7.Give feedback\n9.Logout");
            int command=sc.nextInt();
            if(command==1){
                veiwavailablecourse();
            }
            else if(command==2){
                registerforcourse(student_id1);
            }
            else if(command==3){
                viewschedule(student_id1);
            }
            else if(command==4){
                System.out.println("Your current cgpa is: "+this.grades);
            }

            else if(command==5){
                long endTime = System.currentTimeMillis();
                long elapsedTimeInSeconds = (endTime - startTime) / 1000;
                try{
                    if(elapsedTimeInSeconds<deadline_limt){
                        dropcourse(student_id1);
                    }
                    else{
                        throw new coursedropfailure("Sorry Deadline Passed: You can no longer drop the course");
                    }
                }
                catch (coursedropfailure e){
                    System.out.println(e.getMessage());
                }

            }


            else if(command==6){
                System.out.println("1.Submit a complaint\n2.View status of complaints");
                int it=sc.nextInt();
                if(it==1) submitcomplaints(student_id1);
                else if(it==2) gets_status(student_id1);
            }
            else if(command==7){
                givefeedback();
            }

            else if(command==9) {
                System.out.println("Successfully logged out.");
                break;
            }
        }

    }



    public void veiwavailablecourse(){
        for (course temp : course_catalog) {
            System.out.println("Course code: "+temp.course_code+"\n   Course title: "+ temp.coursetitle+ "\n   Course professor: "+ temp.prof + "\n   Course credits: "+ temp.credits+ "\n   Course prerequisites: "+ temp.prerequisites+"\n   Course class timings: "+ temp.classtiming+"\n   Class strength: "+ temp.enrolledstudents);
        }
    }

    public void submitcomplaints(String student_id1){
        System.out.println("Enter the description of the complaint: ");
        String st=sc.next();
        System.out.println("Enter the current date: ");
        String date=sc.next();
        complaints cl=new complaints(st,student_id1,false,date);
        complaints_list.add(cl);
    }


    public void gets_status(String student_id1){
        for(complaints temp:complaints_list){
            if(temp.student_id==student_id1){
                System.out.println( temp.issue + "   " + temp.status);
                break;
            }
        }
    }

    public student(int in){
        return;
    }

    public void viewschedule(String student_id1){
        for(student st:students_ls){
            if(Objects.equals(st.st_id, student_id1)){
                for(course cs:st.registeredCourses){
                    System.out.println(cs.course_code+" "+ cs.prof +" "+cs.classtiming+" "+cs.classroom);
                }
                break;
            }
        }
    }


    public void dropcourse(String student_id1) throws coursedropfailure{
        System.out.println("Enter the course to drop");
        String str=sc.next();
        course t1=null;
        for (course temp : course_catalog) {
            if (Objects.equals(temp.course_code, str)) {
                t1 = temp;
            }
        }
        if(t1==null) System.out.println("Invalid course code try again");
        else {
            for (student st : students_ls) {
                if (Objects.equals(st.st_id, student_id1)) {
                    st.registeredCourses.remove(t1);
                    if (t1 != null) t1.enrolledstudents -= 1;
                }
                break;
            }
            System.out.println("Course dropped successfully\n");
        }
    }

    public void registerforcourse(String student_id1) throws Coursefullexception{
        System.out.println("Enter your semester: ");
        int sem=sc.nextInt();
        int sumcredits=0;

        student st1=null;
        for(student st:students_ls) {
            if (Objects.equals(st.st_id, student_id1)) {
                st1 = st;
                break;
            }
        }

        for (course temp : course_catalog){
            boolean flag=true;
            if(temp.semester==sem) {
                System.out.println("Course code: " + temp.course_code + " Course credits: " + temp.credits);
                System.out.println("Enter 1 to select this course or 2 to see next");
                int inp = sc.nextInt();
                try {
                    if (inp == 1 && temp.enrolledstudents == temp.enrollmentlimit) {
                        throw new Coursefullexception("Enrolled students limits for course reached. Try another course");
                    } else if (inp == 1 && st1 != null && sumcredits <= 20) {
                        for (course c1 : temp.prerequisites) {
                            if (!st1.completedcourse.contains(c1)) {
                                System.out.println("You cannot select this course because you have not completed the prerequisites");
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            (st1.registeredCourses).add(temp);
                            sumcredits += temp.credits;
                            temp.enrolledstudents += 1;
                        }
                    }

                    if (sumcredits > 20) {
                        System.out.println("Credits limits exceeded \n Your all registered courses are removed do it again");
                        st1.registeredCourses.clear();
                        break;

                    }
                }

                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void givefeedback(){
        System.out.println("Enter the course code");
        String str=sc.next();
        course t1=null;
        for (course temp : registeredCourses) {
            if (Objects.equals(temp.course_code, str)) {
                t1 = temp;
            }
        }
        if(t1==null) System.out.println("Invalid course code Try again");
        else {
            System.out.println("Enter your type of feedback\n1.Enter a textual feedback\n2.Enter Numeric Rating");
            int inp = sc.nextInt();
            sc.nextLine();
            if (inp == 1) {
                System.out.println("Enter your feedback for the selected course: ");
                String st = sc.nextLine();
                t1.f_string.add_comment(st);
            }

            else if (inp == 2) {
                System.out.println("Enter your Rating for the selected course: ");
                int ini1 = sc.nextInt();
                t1.f_int.add_comment(ini1);
            }
        }
    }
}

