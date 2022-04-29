package university;

/*
Student send to University through socket its own data.
University receive the message and prints the stats;
Use Protocol Buffers
 */

import com.google.gson.Gson;

import java.io.DataOutputStream;
import java.net.Socket;
import it.ewlab.student.StudentOuterClass.Student;

public class StudentClient {
    public static void main(String argv[]) throws Exception {

        Student student = Student.newBuilder()
                .setName("Federico")
                .setSurname("Scaramelli")
                .setBirthYear(1997)
                .setResidence(Student.Residence.newBuilder()
                        .setCity("Milano")
                        .setAddress("Via Prato Nuovo 2")
                        .setCap("20036"))
                .addExams(Student.Exam.newBuilder()
                                .setName("Calculus I")
                                .setDate("2018/07/20")
                                .setMark(18))
                .addExams(Student.Exam.newBuilder()
                        .setName("Calculus II")
                        .setDate("2020/07/20")
                        .setMark(18))
                .addExams(Student.Exam.newBuilder()
                        .setName("Calculus III")
                        .setDate("2022/07/20")
                        .setMark(18))
                .build();

        //Client code
        int portNumber = 6789;
        String address = "localhost";

        Socket clientSocket = new Socket(address, portNumber);

        student.writeTo(clientSocket.getOutputStream());

        clientSocket.close();
    }
}
