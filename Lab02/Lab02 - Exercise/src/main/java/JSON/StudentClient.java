package JSON;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import com.google.gson.Gson;

/*
Student send to University through socket its own data.
University receive the message and prints the stats;
Use JSON
 */

public class StudentClient {
    public static void main(String argv[]) throws Exception {

        //Student object creation
        ArrayList<Exam> exams = new ArrayList<Exam>();
        exams.add(new Exam("Calculus", "2018/07/20", 18));
        exams.add(new Exam("Calculus 2", "2020/07/20", 18));
        exams.add(new Exam("Calculus 3", "2022/01/20", 18));
        Student student = new Student("Federico", "Scaramelli", 1997,
                new Residence("Milano", "Via Prato Nuovo 2", "20036"), exams);

        //Client code
        int portNumber = 6789;
        String address = "localhost";
        DataOutputStream outToServer;

        Socket clientSocket = new Socket(address, portNumber);
        outToServer = new DataOutputStream(clientSocket.getOutputStream());

        //Serialization
        Gson gson = new Gson();
        String studentString = gson.toJson(student);

        //Send
        outToServer.writeBytes(studentString + "\n");
    }
}

class Student {
    String name;
    String surname;
    int birthYear;
    Residence residence;
    ArrayList<Exam> exams;

    public Student(String n, String s, int b, Residence r, ArrayList<Exam> e){
        name = n;
        surname = s;
        birthYear = b;
        residence = r;
        exams = e;
    }

    public String print(){
        String s = "";
        s += "Name: " + this.name + ";\n";
        s += "Surname: " + this.surname + ";\n";
        s += "Year of birth: " + this.birthYear + ";\n";
        s += residence.print();
        s += "Registered exams: \n";
        for (Exam e : exams){
            s += e.print();
        }
        return s;
    }
}

class Residence {
    private String city, address, cap;

    public Residence(String c, String a, String ca){
        city = c;
        address = a;
        cap = ca;
    }

    public String print(){
        String s = "";
        s += "City: " + city + ";\n" +
                "Address: " + address + ";\n" +
                "Postal code: " + cap + ";\n";
        return s;
    }
}

class Exam {
    private String name, date;
    private int mark;

    public Exam(String n, String d, int m){
        name = n;
        date = d;
        mark = m;
    }

    public String print(){
        String s = "";
        s += "->Name: " + name + ";\n";
        s += "->Date: " + date + ";\n";
        s += "->Mark: " + mark + ";\n";
        return s;
    }
}

