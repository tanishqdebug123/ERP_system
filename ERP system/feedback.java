import java.util.ArrayList;

public class feedback<T> {
    private  ArrayList<T> feedback;
    public feedback(){
        feedback=new ArrayList<T>();
    }

    public void add_comment(T comment){
        feedback.add(comment);
    }
    public void get(){
        System.out.println(feedback);
    }
}
