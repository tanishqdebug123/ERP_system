import java.util.*;
//import java.util/


public class Main {
    // ALL HARDCODED DATA
    public ArrayList<String> student_ids = new ArrayList<>(Arrays.asList("Btech23001@gmail.com", "Btech23002@gmail.com", "Btech23003@gmail.com"));
    public ArrayList<String> student_passwords = new ArrayList<>(Arrays.asList("23001@123", "23002@123", "23003@123"));

    public  ArrayList<String> ta_ids=new ArrayList<>(Arrays.asList("ta1@123","ta2@123")) ;
    public  ArrayList<String> ta_passwords=new ArrayList<>(Arrays.asList("pass1@123","pass2@123")) ;


    public ArrayList<String> professor_id = new ArrayList<>(Arrays.asList("P1@gmail.com","P2@gmail.com","P3@gmail.com"));
    public ArrayList<String> professor_pass = new ArrayList<>(Arrays.asList("P1@123","P2@123","P3@123"));

    public ArrayList<String> admin_id = new ArrayList<>(Arrays.asList("A1@gmail.com"));
    public ArrayList<String> admin_pass = new ArrayList<>(Arrays.asList("Admin123"));


    public static ArrayList<course> course_catalog = new ArrayList<>();
    public static ArrayList<complaints> complaints_list=new ArrayList<>();
    public static ArrayList<student> students_ls=new ArrayList<>();

    public static ArrayList<student> TA_ls=new ArrayList<>();

    long startTime = System.currentTimeMillis();
    public int deadline_limt=150;


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        ArrayList<course> temp1= new ArrayList<>();
        course c1=new course("MTH101",4,"P1@gmail.com",temp1,"3PM-4.30PM","LinearAlgebra","C101",1,3,3);
        course c2=new course("CSE101",4,"P2@gmail.com",temp1,"9.30AM-11.00AM","Introduction to programming","C01",1,3,5);
        course c3=new course("CSE201",4,"P2@gmail.com",temp1,"11.30AM-12.30PM","DSA","C102",1,3,5);
        course c4=new course("COM101",4,"P3@gmail.com",temp1,"1.30PM-3.00PM","Communication skills","C201",1,3,5);
        course c5=new course("ECO101",2,"P3@gmail.com",temp1,"4.00PM-5.30PM","Money and banking","C201",1,3,5);
        ArrayList<course> t1= new ArrayList<>(Arrays.asList(c1,c2,c3,c4,c5));
        course_catalog.add(c1);
        course_catalog.add(c2);
        course_catalog.add(c3);
        course_catalog.add(c4);
        course_catalog.add(c5);


        ArrayList<course> temp1_completedcourse= new ArrayList<>();
        student s1=new student("Btech23001@gmail.com","23001@123",1,t1,temp1_completedcourse,0);
        student s2=new student("Btech23002@gmail.com","23002@123",1,t1,temp1_completedcourse,0);
        student s3=new student("Btech23003@gmail.com","23001@123",1,t1,temp1_completedcourse,8.6);
        //students_ls=(Arrays.asList(s1,s2,s3));
        students_ls.add(s1);
        students_ls.add(s2);
        students_ls.add(s3);

        student ta1=new TA("ta1@123","pass1@123",c1);
        student ta2=new TA("ta2@123","pass2@123",c2);
        students_ls.add(s1);
        students_ls.add(s2);
        students_ls.add(s3);
        students_ls.add(ta1);
        students_ls.add(ta2);

        TA_ls.add(ta1);
        TA_ls.add(ta2);



        complaints cl1=new complaints("IP classes clashes with LA",false,"18/09/2024");
        complaints cl2=new complaints("User cannot see results",false,"18/09/2024");
        complaints_list.add(cl1);
        complaints_list.add(cl2);


        while (true) {
            System.out.println("Welcome to university course registration System");
            System.out.print("Enter your input (1:Enter/2:Exit) ");
            int input = sc.nextInt();
            if (input == 1) {
                System.out.print("Enter your role\n1:Student\n2:Professor\n3:Administrator\n4:Teaching assistant\n");
                int role = sc.nextInt();
                if (role == 1) {
                    student st = new student();
                } else if (role == 2) {
                    professor p1 = new professor();
                } else if (role == 3) {
                    Administrator a1 = new Administrator();
                }else if(role==4){
                    System.out.println("1.Login or 2.Signup");
                    int in = sc.nextInt();
                    TA ta_temp=new TA(in);
                }
                else {
                    System.out.println("Invalid credentials\nEnter 1 to try again\nEnter 2 to quit");
                    int id=sc.nextInt();
                    if(id==2){
                        break;
                    }
                }
            } else if (input == 2) {
                System.out.println("Successfully logged out.");
                break;
            }
        }
    }

}



