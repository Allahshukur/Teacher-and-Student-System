package com.company;

import com.company.entity.Store;
import com.company.service.StudentService;
import com.company.service.TeacherService;

import java.util.Scanner;

public class Main {

    private static StudentService studentService = new StudentService();
    private static TeacherService teacherService = new TeacherService();

    public static void main(String[] args) throws Exception{

        Store store = StudentService.readFromFileIO();
        StudentService.studentList= store.getList();
        TeacherService.teacherList=store.getListteacher();

        while (true){
            System.out.println("             Please choose an operation \n" +
                    "1. Registr the Student " + "              "+"2. Registr the Teacher \n" +
                    "3. Delete the Student " + "               "+"4. Delete the Teacher \n" +
                    "5. Search the Student " + "               "+"6. Search the Teacher \n" +
                    "7. Show All Students " + "                "+"8. Show All Teachers \n" +
                    "9. Update the Student " + "               "+"10.Update the Teacher \n");

            System.out.print("Choose an operation: = ");
            int operationNumer = new Scanner(System.in).nextInt();

            if (operationNumer==1){
                studentService.regstr();
            }
            else if (operationNumer==2){
                teacherService.regist();
            }
            else if (operationNumer==3){
                studentService.Delete();
            }
            else if (operationNumer==4){
                teacherService.Delete();
            }
            else if (operationNumer==5){
                studentService.Search();
            }
            else if (operationNumer==6){
                teacherService.Search();
            }
            else if (operationNumer==7){
                studentService.ShowAll();
            }
            else if (operationNumer==8){
                teacherService.ShowAll();
            }
            else if (operationNumer==9){
                studentService.Update();
            }
            else if (operationNumer==10){
                teacherService.Update();
            }
            else {
                System.out.println("Operation is not right");
            }


            store.setList(StudentService.studentList);
            store.setListteacher(TeacherService.teacherList);
            StudentService.writeIntoFileIO(store);
        }




    }


}
