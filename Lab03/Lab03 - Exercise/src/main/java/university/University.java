package university;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import it.ewlab.student.StudentOuterClass.Student;

public class University {
    public static void main(String argv[]) throws Exception {

        BufferedReader inFromClient;

        int portNumber = 6789;

        Gson gson = new Gson();

        try {
            ServerSocket welcomeSocket = new ServerSocket(portNumber);

            while (true) {
                Socket connectionSocket = welcomeSocket.accept();

//                Student student = Student.newBuilder()
//                        .setName("")
//                        .setSurname("")
//                        .setBirthYear(0)
//                        .setResidence(Student.Residence.newBuilder()
//                                .setCity("")
//                                .setAddress("")
//                                .setCap(""))
//                        .addExams(Student.Exam.newBuilder()
//                                .setName("")
//                                .setDate("")
//                                .setMark(0))
//                        .build();

                Student student = Student.parseFrom(connectionSocket.getInputStream());

                System.out.println(student);
//                System.out.print(
//                        "Name: " + student.getName() + "\n"
//                        + "Surname: " + student.getSurname() + "\n"
//                        + "Year of birth: " + student.getBirthYear() + "\n"
//                        + "Residence city: " + student.getResidence().getCity() + "\n"
//                        + "Residence address: " + student.getResidence().getAddress() + "\n"
//                        + "Residence cap: " + student.getResidence().getCap() + "\n"
//                        + "Exams list: " + "\n"
//                );
//                for (int i = 0; i < student.getExamsCount(); i++) {
//                    System.out.print(
//                            "-> " + student.getExams(i).getName() + " <-" + "\n"
//                            + "Date: " + student.getExams(i).getDate() + "\n"
//                            + "Mark: " + student.getExams(i).getMark() + "\n"
//                    );
//                }
//                System.out.println();
            }
        } catch(Exception e) {
            System.out.println("\nEXCEPTION!");
            e.printStackTrace();
        }
    }
}
