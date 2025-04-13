import java.util.Objects;
import java.util.Scanner;


public class TA extends student {
    Scanner sc=new Scanner(System.in);
    course cs;
    public String ta_id;
    private String ta_pass;

    public TA(String ta_id,String ta_pass,course cs){
        super(ta_id,ta_pass);
        this.cs=cs;
    }

    public TA(int in) throws invalidlogin {
        super(in);
        String ta_id1;
        if (in == 1) {
            while (true) {
                System.out.println("Enter your TA id: ");
                ta_id1 = sc.next();
                System.out.println("Enter your password: ");
                String ta_pass = sc.next();
                try {
                    int i1 = ta_ids.indexOf(ta_id1);
                    int i2 = ta_passwords.indexOf(ta_pass);
                    if ((i1 == i2) && i1 != -1) {
                        System.out.println("Congratulation You are logged in");
                        break;
                    } else {
                        throw new invalidlogin("Invalid login credentials");
                    }
                } catch (invalidlogin e) {
                    System.out.println(e.getMessage());
                    System.out.println("Enter 1 to try again\nEnter 2 to quit");
                    int id = sc.nextInt();
                    if (id == 2) {
                        entry = false;
                        break;
                    }
                }
            }
        } else {
            System.out.println("Create a TA id: ");
            ta_id1 = sc.next();
            System.out.println("Create a strong password: ");
            String ta_password = sc.next();
            ta_ids.add(ta_id1);
            ta_passwords.add(ta_password);
            TA t1=new TA(ta_id1,ta_password,null);
            TA_ls.add(t1);
            System.out.println("Congratulation You are logged in");
        }

        while (true && entry == true) {
            System.out.println("Enter one of the following commands\n1.View available courses\n2.Register for course\n3.View Schedule\n4.Track academic progress\n5. Drop course\n6.Submit complaints\n7.Give feedback\n8.View TA role\n9.Logout");
            int command = sc.nextInt();
            if (command == 1) {
                veiwavailablecourse();
            } else if (command == 2) {
                registerforcourse(ta_id1);
            } else if (command == 3) {
                viewschedule(ta_id1);
            } else if (command == 4) {
                System.out.println("1");
            } else if (command == 5) {
                dropcourse(ta_id1);
            } else if (command == 6) {
                System.out.println("1.Submit a complaint\n2.View status of complaints");
                int it = sc.nextInt();
                if (it == 1) submitcomplaints(ta_id1);
                else if (it == 2) gets_status(ta_id1);
            } else if (command == 7) {
                givefeedback();
            } else if (command == 8) {
                TArole(ta_id1);
            } else {
                System.out.println("Successfully logged out.");
                break;
            }
        }
    }


    public void TArole(String ta_id1){
        System.out.println("Enter one of the following commands\n1.View Course details\n2.View student grades\n3.Update student grades");
        int input = sc.nextInt();
        if(input==1){
            viewcoursedetails(ta_id1);
        }
        else if (input==2) {
            view_student_grades();
        }
        else if(input==3){
            update_student_grade();
        }
    }

    public void viewcoursedetails(String ta_id1){
        for(course temp:course_catalog){
            if(Objects.equals(temp.ta_course, ta_id1)){
                System.out.println("Course code: "+temp.course_code+"\n   Course title: "+ temp.coursetitle+ "\n   Course professor: "+ temp.prof + "\n   Course credits: "+ temp.credits+ "\n   Course prerequisites: "+ temp.prerequisites+"\n   Course class timings: "+ temp.classtiming+"\n   Class strength: "+ temp.enrolledstudents);
                break;
            }
        }
    }

    void view_student_grades(){
        System.out.println("Enter student id: ");
        String st_inp=sc.next();
        for(student st:students_ls){
            if(Objects.equals(st.st_id, st_inp)){
                System.out.println("CGPA of the student is: "+st.grades);
                break;
            }
        }
    }

    void update_student_grade(){
        System.out.println("Enter student id: ");
        String st_inp=sc.next();
        System.out.println("Enter new grade: ");
        int ini=sc.nextInt();
        for(student st:students_ls){
            if(Objects.equals(st.st_id, st_inp)){
                st.course_grades.add(ini);
                break;
            }
        }
        System.out.println("Student grades updates");
    }


}
