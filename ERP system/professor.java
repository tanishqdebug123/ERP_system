import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class professor extends Main{
    Scanner sc=new Scanner(System.in);
    boolean entry=true;
    String proff_id;
    ArrayList<course> assignedcourses=new ArrayList<>();

    public professor(String proff_id,ArrayList<course> assignedcourses){
        this.proff_id=proff_id;
        this.assignedcourses=assignedcourses;
    }

    public professor() throws invalidlogin{
        System.out.println("1.Login or 2.Signup");
        int in=sc.nextInt();
        String prof_id;
        if(in==1) {
            while (true) {
                System.out.println("Enter your Professor id: ");
                prof_id = sc.next();
                System.out.println("Enter your password: ");
                String prof_pass = sc.next();

                try{
                    int i1 = professor_id.indexOf(prof_id);
                    int i2 = professor_pass.indexOf(prof_pass);
                    if ((i1 == i2) && i1 != -1) {
                        System.out.println("Congratulation You are logged in");
                        break;
                    }
                    else{
                        throw new invalidlogin("Invalid login credentials");
                    }
                }
                catch (invalidlogin e){
                    System.out.println(e.getMessage());
                    System.out.println("Enter 1 to try again\nEnter 2 to quit");
                    int id=sc.nextInt();
                    if(id==2){
                        entry=false;
                        break;
                    }
                }

            }
        }
        else{
            System.out.println("Create a professor id: ");
            prof_id = sc.next();
            System.out.println("Create a strong password: ");
            String prof_pass = sc.next();
            professor_id.add(prof_id);
            professor_pass.add(prof_pass);
            ArrayList<course> temp1 = new ArrayList<>(Arrays.asList());
            professor ptemp=new professor(prof_id,temp1);
            System.out.println("Congratulation You are logged in");

        }

        while(true && entry==true) {
            System.out.println("Enter one of the following commands\n1.View your courses\n2.Update your course details\n3.View enrolled students\n4.View course feedback\n9.Logout");
            int int1 = sc.nextInt();
            if (int1 == 1) {
                viewcourse(prof_id);
            }
            else if (int1 == 2) {
                System.out.println("Enter the course code of course which needs to be updated");
                String cd=sc.next();
                for (course temp : course_catalog) {
                    if (Objects.equals(cd, temp.course_code)) {
                        updatecourse(temp);
                        break;
                    }
                }
            }
            else if(int1==3){
                System.out.println("Enter the course code of course whose student list needs to be displayed");
                String cd=sc.next();
                for (course temp : course_catalog) {
                    if (Objects.equals(cd, temp.course_code)) {
                        System.out.println(temp.student_id);
                        break;
                    }
                }
            }
            else if (int1==4){
                viewfeedback();

            }
            else if(int1==9){
                break;
            }
        }
    }

    public void viewcourse(String prof_id){
        for (course temp : course_catalog) {
            if (Objects.equals(prof_id, temp.prof)) {
                System.out.println(temp.course_code+" "+temp.syllabus);
            }
        }
    }

    public void updatecourse(course cd){
        System.out.println("Enter one of the following commands\n1.Update syllabus\n2.Update class timings\n3.Update credits\n4.Update prerequisites\n5.Update enrollment limit\n6.Update office hours");
        int in2=sc.nextInt();
        if(in2==1){
            System.out.println("Enter new syllabus");
            String st=sc.next();
            cd.syllabus=st;
        }
        else if(in2==2){
            System.out.println("Enter new class timings");
            String st=sc.next();
            cd.classtiming=st;

        }
        else if(in2==3){
            System.out.println("Enter updated credits");
            int st=sc.nextInt();
            cd.credits=st;
        }
        else if(in2==4){
            System.out.println("Enter new prerequisite course code");
            String st=sc.next();
            for(course temp:course_catalog){
                if(temp.course_code==st){
                    cd.prerequisites.add(temp);
                    break;
                }
            }

        }
        else if(in2==5){
            System.out.println("Enter updated enrollment limit");
            int st=sc.nextInt();
            cd.enrollmentlimit=st;
        }
        else if(in2==6){
            System.out.println("Enter updated office hours");
            String st=sc.next();
            cd.officehours=st;
        }
    }

    public void viewfeedback(){
        System.out.println("Enter the course code to view feedback");
        String cd=sc.next();
        for (course temp : course_catalog) {
            if (Objects.equals(cd, temp.course_code)){
                System.out.println("Feedbacks given by the students are ");
                temp.f_string.get();
                temp.f_int.get();
            }
        }


    }


}
