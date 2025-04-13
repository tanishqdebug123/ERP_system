import java.util.*;

public class complaints{
    String issue;
    boolean status;
    String resolve_details;
    String date;
    String student_id;
    public complaints(String issue,boolean status,String resolve_details,String date){
        this.issue=issue;
        this.status=status;
        this.resolve_details=resolve_details;
        this.date=date;
    }

    public complaints(String issue,boolean status,String date){
        this.issue=issue;
        this.status=status;
        this.date=date;
    }

    public complaints(String issue,String student_id,boolean status,String date){
        this.issue=issue;
        this.status=status;
        this.date=date;
        this.student_id=student_id;
    }




}
