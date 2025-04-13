import java.util.*;

public class Administrator extends Main {
    ArrayList<String> admin_id = new ArrayList<>(Arrays.asList("A1@gmail.com"));
    ArrayList<String> admin_pass = new ArrayList<>(Arrays.asList("Admin123"));
    Scanner sc = new Scanner(System.in);
    boolean entry=true;

    public Administrator() throws invalidlogin{
        while (true) {
            System.out.println("Enter your email id: ");
            String adminid = sc.next();
            System.out.println("Enter your password: ");
            String adminpass = sc.next();
            try{
                int i1 = admin_id.indexOf(adminid);
                int i2 = admin_pass.indexOf(adminpass);
                if ((i1 == i2) && i1 != -1) {
                    System.out.println("Congratulation You are logged in");
                    break;
                } else {
                    throw new invalidlogin("Invalid login credentials");
                }

            }
            catch (invalidlogin e){
                System.out.println(e.getMessage());
                System.out.println("Enter 1 to try again\nEnter 2 to quit");
                int id=sc.nextInt();
                if(id==2) {
                    entry = false;
                    break;
                }
            }
        }

        while (true && entry==true) {
            System.out.println("Enter one of the following commands\n1.Manage course catalog\n2.Manage student records\n3.Assign professors to courses\n4.Handle complaints\n5.Assign TA to courses\n9.Logout");
            int command = sc.nextInt();
            if (command == 1) {
                managecourse(course_catalog);
            } else if (command == 2) {
                manage_students_record(students_ls);
            } else if (command == 3) {
                assign_professors();
            } else if (command == 4) {
                handle_complaints();
            }
            else if (command == 5) {
                assign_ta();
            }
            else if(command==9){
                System.out.println("Successfully logged out.");
                break;
            }
        }
    }

        public void managecourse (ArrayList < course > course_catalog) {
            while (true) {
                System.out.println("Enter one of the following commands\n1.View course\n2.Add courses\n3.Delete courses\n4. Move to main menu");
                int command = sc.nextInt();
                if (command == 1) {
                    System.out.println("List of courses\n");
                    for (course temp : course_catalog) {
                        System.out.println(temp.course_code);
                    }
                } else if (command == 2) {
                    System.out.println("Enter the course code to add");
                    String coursecode = sc.next();
                    System.out.println("Enter the credits for the course");
                    int credits = sc.nextInt();
                    System.out.println("Enter the professor who will take this course");
                    String professor = sc.next();
                    course cnew = new course(coursecode, credits, professor);
                    course_catalog.add(cnew);
                } else if (command == 3) {
                    System.out.println("Enter the course code to delete");
                    String coursecode = sc.next();
                    for (course temp : course_catalog) {
                        if (Objects.equals(temp.course_code, coursecode)) {
                            course_catalog.remove(temp);
                            break;
                        }
                    }
                } else {
                    break;
                }
            }

        }

        public void assign_professors () {
            System.out.println("Enter the course for which proffesor needs to be assigned: ");
            String c = sc.next();
            System.out.println("Enter the professor id");
            String p = sc.next();
            for (course temp : course_catalog) {
                if (Objects.equals(temp.course_code, c)) {
                    temp.prof = p;
                    break;
                }
            }
        }

        public void handle_complaints () {
            System.out.println("Enter your response\n1.View complaints\n2.Filter complaints based on status");
            int r1 = sc.nextInt();
            if (r1 == 1) {
                for (complaints cl : complaints_list) {
                    System.out.println(cl.issue + " " + cl.date + " " + cl.status);
                    System.out.println("Enter your response\n1.Update status\n2.Vew another complaint");
                    int r = sc.nextInt();
                    if (r == 1) {
                        System.out.println("Enter the solution to the problem");
                        String st = sc.next();
                        cl.status = true;
                        cl.resolve_details = st;
                    } else if (r == 2) {
                        continue;
                    }
                }
            } else if (r1 == 2) {
                System.out.println("Printing all unresolved complaints");
                for (complaints cl : complaints_list) {
                    if (!cl.status) {
                        System.out.println(cl.issue + " " + cl.date);
                    }
                }
            }
        }

        void manage_students_record(ArrayList<student>students_ls){
            System.out.println("Enter your response\n1.View students record\n2.Change students grade");
            int r1 = sc.nextInt();
            if(r1==1){
                for(student st:students_ls){
                    System.out.println(st.st_id+" "+st.current_semester+" "+st.grades);
                }
            }
            else if(r1==2){
                    System.out.println("Enter the student id to change grade: ");
                    String st1=sc.next();
                    for(student sit:students_ls){
                        if(Objects.equals(sit.st_id, st1)){
                            System.out.println("Enter the new grade: ");
                            int gr=sc.nextInt();
                            sit.grades=gr;
                            System.out.println("Grades are updated");
                            break;
                        }
                    }
            }
        }

        void assign_ta(){
            System.out.println("Enter the course for which TA needs to be assigned: ");
            String c = sc.next();
            System.out.println("Enter the TA id");
            String p = sc.next();

            student st_temp=null;
            for (student st : TA_ls) {
                if (Objects.equals(st.st_id, p)) {
                    st_temp=st;
                    break;
                }
            }

            for (course temp : course_catalog) {
                if (Objects.equals(temp.course_code, c)) {
                    temp.ta_course=st_temp;
                    break;
                }
            }
        }
    }
