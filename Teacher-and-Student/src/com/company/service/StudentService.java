package com.company.service;

import com.company.entity.Store;
import com.company.entity.Student;
import com.company.entity.Teacher;

import java.io.*;
import java.util.Scanner;

public class StudentService{

    public static Student[] studentList = new Student[1000];

    public static int getLastIndex(){
        for (int i = 0;i < studentList.length;i++ ){
            if (studentList[i]==null){
                return i;
            }
        }
        return -1;
    }

    public void Add(Student student) {
        int lastIndex = getLastIndex();
        studentList[lastIndex] = student;
        student.setId(++lastIndex);
    }

    public void remove(Student student) {
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null && studentList[i].getId().equals(student.getId())) {
                studentList[i] = null;
                break;
            }
        }
    }

    public Student FindById(int id) {
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null && studentList[i].getId() == id) {
                return studentList[i];
            }
        }
        return null;
    }

    public void regstr()  {
        Student student= new Student();

        System.out.print("Enter the Student Name: = ");
        student.setName(new Scanner(System.in).nextLine());
        System.out.print("Enter the Student Surname: = ");
        student.setSurname(new Scanner(System.in).nextLine());
        System.out.print("Enter the Student Age: = ");
        student.setAge(new Scanner(System.in).nextInt());
        System.out.print("Enter the Student Gpa: = ");
        student.setGpa(new Scanner(System.in).nextDouble());
        if (student.getGpa()>=8){
            student.setScholarship(147);
        }
        else if (student.getGpa()>=5){
            student.setScholarship(99);
        }
        else if (student.getGpa()>=3){
            student.setScholarship(45);
        }
        else if (student.getGpa()<3){
            student.setScholarship(0);
        }

        System.out.println("Relationship: 1. Married  2.Single");
        System.out.print("Enter the Relationship: = ");
        int relationship = new Scanner(System.in).nextInt();
        if (relationship==1){
            student.setRelationship("Married");
        }
        else if (relationship==2){
            student.setRelationship("Single");
        }
        else {
            student.setRelationship(null);
        }

        Add(student);
        System.out.println("");
        System.out.println("*********************************************");
        System.out.println("       Student successfully registered");
        System.out.println("********************************************* ");
        System.out.println("Id:= "+student.getId()+", Name:= "+student.getName()+", Surname:= "+student.getSurname()+
                ", Age:= "+student.getAge()+", Scholarship:= "+student.getScholarship()+", Gpa:= "+student.getGpa()+
                 ", Relationship:= "+student.getRelationship());
        System.out.println("");
    }

    public void Delete() throws Exception{
        System.out.print("Enter the Student id: = ");
        int id = new Scanner(System.in).nextInt();
        Student s=FindById(id);
        if (s!=null){
            remove(s);
            System.out.println("*********************************************");
            System.out.println("        Student successfully deleted");
            System.out.println("********************************************* ");
        }
        else  {
            System.out.println("There is no such Student:");
        }
    }

    public void ShowAll() throws Exception{
        for (int i=0;i< studentList.length;i++){
            if (studentList[i]==null) continue;
            System.out.println(studentList[i].toString());
        }
    }

    public void Search(){
        System.out.print("Enter the Sutudent name: = ");
        String name=new Scanner(System.in).nextLine();

        System.out.print("Enter the Student surname: = ");
        String surname=new Scanner(System.in).nextLine();

        Student ss=null;
        for (int i=0;i<studentList.length;i++){
            if (studentList[i]==null) continue;
            if (studentList[i].getName().equalsIgnoreCase(name) &&
                     studentList[i].getSurname().equalsIgnoreCase(surname)){
                ss=studentList[i];
                System.out.println(ss);
            }
        }
        if (ss==null){
            System.out.println("There is no such Student:");
        }
    }

    public void Update(){
        System.out.print("Enter the Student id: = ");
        int id=new Scanner(System.in).nextInt();
        Student s=FindById(id);

        if (s==null){
            System.out.println("There is no such Student");
            return;
        }

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println(studentList[id-1].toString());
        System.out.println("----------------------------------------------------------------------------------------------------- \n");
        System.out.print("Which field do you want to update: = ");
        String field=new Scanner(System.in).nextLine();

        if (field.equalsIgnoreCase("name")){
            System.out.print("Enter the Student name: = ");
            s.setName(new Scanner(System.in).nextLine());
        }
        else if (field.equalsIgnoreCase("surname")){
            System.out.print("Enter the Student surname: = ");
            s.setSurname(new Scanner(System.in).nextLine());
        }
        else if (field.equalsIgnoreCase("age")){
            System.out.print("Enter the Student age: = ");
            s.setAge(new Scanner(System.in).nextInt());
        }
        else if (field.equalsIgnoreCase("scholarship")){
            System.out.print("Enter the Student scholarship: = ");
            s.setScholarship(new Scanner(System.in).nextDouble());
        }
        else if (field.equalsIgnoreCase("gpa")){
            System.out.print("Enter the Student Gpa: = ");
            s.setGpa(new Scanner(System.in).nextDouble());
        }
        else if (field.equalsIgnoreCase("relationship")){
            System.out.println("Relationship: 1. Married  2. Single");
            System.out.print("Enter the Relationship: = ");
            int relationship=new Scanner(System.in).nextInt();
            if (relationship==1){
                s.setRelationship("Married");
            }
            else if (relationship==2){
                s.setRelationship("Single");
            }
            else {
                System.out.println("Operation is wrong:");
            }
        }
        else {
            System.out.println("Operation is wrong:");
        }

        Store store = new Store();
        store.setList(studentList);
        writeIntoFileIO(store);
    }

    public static void writeIntoFileIO(Store store)  {

        try {
            File file= new File("Files/testTeacher.txt");
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(store);

            o.close();
            f.close();
            System.out.println("Successfully write to file");
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }

    }

    public static Store readFromFileIO() throws Exception {
       try {
           File file = new File("Files/testTeacher.txt");
           FileInputStream fi = new FileInputStream(file);
           ObjectInputStream oi = new ObjectInputStream(fi);

           // Read objects
           Store pr1 = (Store) oi.readObject();
           oi.close();
           fi.close();
           return pr1;
       } catch (Exception ex){
           Store s = new Store();
           s.setList(new Student[1000]);
           s.setListteacher(new Teacher[1000]);
           return s;
       }
    }

}
