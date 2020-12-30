package com.company.service;

import com.company.entity.Store;
import com.company.entity.Teacher;

import java.io.*;
import java.util.Scanner;

public class TeacherService {

    public static Teacher[] teacherList = new Teacher[1000];

    private int Lastindex = 0;

    public void Add(Teacher teacher) {
        teacherList[Lastindex] = teacher;
        teacher.setId(++Lastindex);
        Store store = new Store();
        store.setListteacher(teacherList);
        writeIntoFileIO(store);
    }

    public void Remove(Teacher teacher) {
        for (int i=0;i< teacherList.length;i++){
            if (teacherList[i] != null && teacherList[i].getId().equals(teacher.getId())){
                teacherList[i]=null;
                Store store = new Store();
                store.setListteacher(teacherList);
                writeIntoFileIO(store);
                break;
            }
        }
    }

    public Teacher FindById(int id) {
        for (int i = 0; i < teacherList.length; i++) {
            if (teacherList[i] != null && teacherList[i].getId() == id) {
                return teacherList[i];
            }
        }
        return null;
    }

    public void regist() {
        Teacher teacher = new Teacher();

        System.out.print("Enter the Teacher Name: = ");
        teacher.setName(new Scanner(System.in).nextLine());
        System.out.print("Enter the Teacher Surname: = ");
        teacher.setSurname(new Scanner(System.in).nextLine());
        System.out.print("Enter the Teacher Age: = ");
        teacher.setAge(new Scanner(System.in).nextInt());
        System.out.println("Please choose a Chair: ( Informatics / Math / Azerbaijan Language / Geography / " +
                "Physicist / Chemisrty )");
        System.out.print("Enter the Teacher Chair: = ");
        teacher.setChair(new Scanner(System.in).nextLine());

        if (teacher.getChair().equalsIgnoreCase("Informatics")){
            teacher.setSalary(500);
        }
        else if (teacher.getChair().equalsIgnoreCase("Math")){
            teacher.setSalary(400);
        }
        else if (teacher.getChair().equalsIgnoreCase("Azerbaijan Language")){
            teacher.setSalary(300);
        }
        else if (teacher.getChair().equalsIgnoreCase("Geography")){
            teacher.setSalary(250);
        }
        else if (teacher.getChair().equalsIgnoreCase("Physicist")){
            teacher.setSalary(350);
        }
        else if (teacher.getChair().equalsIgnoreCase("Chemistry")){
            teacher.setSalary(450);
        }
        else {
            teacher.setSalary(0);
        }

        System.out.println("Relationship:   1. Married  2.Single");
        System.out.print("Enter the Relationship: = ");
        int relationship = new Scanner(System.in).nextInt();
        if (relationship == 1) {
            teacher.setRelationship("Married");
        }
        else if (relationship == 2) {
            teacher.setRelationship("Single");
        }
        else {
            teacher.setRelationship(null);
        }

        Add(teacher);
        System.out.println("");
        System.out.println("*********************************************");
        System.out.println("       Teacher successfully registered");
        System.out.println("********************************************* ");
        System.out.println("Id:= " + teacher.getId() + ", Name:= " + teacher.getName() + ", Surname:= " + teacher.getSurname() +
                ", Age:= " + teacher.getAge() + ", Salary:= " + teacher.getSalary() + ", Chair:= " + teacher.getChair() +
                ", Relationship:= " + teacher.getRelationship());
        System.out.println("");
    }

    public void Delete() {
        System.out.print("Enter the Teacher id: = ");
        int id= new Scanner(System.in).nextInt();
        Teacher t=FindById(id);
        if (t != null){
            Remove(t);
            System.out.println("*********************************************");
            System.out.println("        Teacher successfully deleted");
            System.out.println("********************************************* ");
        }
        else {
            System.out.println("There is no such Teacher:");
        }
    }

    public void Search(){
        System.out.print("Enter the Teacher name: = ");
        String name=new Scanner(System.in).nextLine();

        System.out.print("Enter the Teacher surname: = ");
        String surname=new Scanner(System.in).nextLine();

        Teacher tt=null;
        for (int i=0;i< teacherList.length;i++){
            if (teacherList[i]==null) continue;
            if (teacherList[i].getName().equalsIgnoreCase(name) &&
                    teacherList[i].getSurname().equalsIgnoreCase(surname)){
                tt=teacherList[i];
                System.out.println(tt);
            }
        }
        if (tt==null){
            System.out.println("There is no such Teacher:");
        }
    }

    public void ShowAll(){
        for (int i=0;i< teacherList.length;i++){
            if (teacherList[i]==null) continue;
            System.out.println(teacherList[i].toString());
        }
    }

    public void Update(){
        System.out.print("Enter the Teacher id: = ");
        int id = new Scanner(System.in).nextInt();
        Teacher tt=FindById(id);

        if (tt==null){
            System.out.println("There is no such Student");
            return;
        }

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println(teacherList[id-1].toString());
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.print("Which field do you want to Update: = ");
        String field = new Scanner(System.in).nextLine();

        if (field.equalsIgnoreCase("name")){
            System.out.print("Enter the Teacher name: = ");
            tt.setName(new Scanner(System.in).nextLine());
        }
        else if (field.equalsIgnoreCase("surname")){
            System.out.print("Enter the Teacher surname: = ");
            tt.setSurname(new Scanner(System.in).nextLine());
        }
        else if (field.equalsIgnoreCase("age")){
            System.out.print("Enter the Teacher age: = ");
            tt.setAge(new Scanner(System.in).nextInt());
        }
        else if (field.equalsIgnoreCase("salary")){
            System.out.print("Enter the Teacher salary: = ");
            tt.setSalary(new Scanner(System.in).nextDouble());
        }
        else if (field.equalsIgnoreCase("chair")){
            System.out.println("Please choose an Chair: ( Informatics / Math / Azerbaijan Language / Geography / " +
                    "Physicist / Chemisrty )");
            System.out.print("Enter the Teacher Chair: = ");
            tt.setChair(new Scanner(System.in).nextLine());

            if (tt.getChair().equalsIgnoreCase("Informatics")){
                tt.setSalary(500);
            }
            else if (tt.getChair().equalsIgnoreCase("Math")){
                tt.setSalary(400);
            }
            else if (tt.getChair().equalsIgnoreCase("Azerbaijan Language")){
                tt.setSalary(300);
            }
            else if (tt.getChair().equalsIgnoreCase("Geography")){
                tt.setSalary(250);
            }
            else if (tt.getChair().equalsIgnoreCase("Physicist")){
                tt.setSalary(350);
            }
            else if (tt.getChair().equalsIgnoreCase("Chemistry")){
                tt.setSalary(450);
            }
            else {
                tt.setSalary(0);
            }

        }
        else if (field.equalsIgnoreCase("relationship")){
            System.out.println("Please Choose a Relationship:   1. Married  2. Single");
            System.out.print("Relationship: = ");
            int relationship =new Scanner(System.in).nextInt();
            if (relationship==1){
                tt.setRelationship("Married");
            }
            else if (relationship==2){
                tt.setRelationship("Single");
            }
            else {
                System.out.println("Operation is wrong:");
            }
        }
        else {
            System.out.println("Operation is wrong:");
        }

        Store store = new Store();
        store.setListteacher(teacherList);
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
            return new Store();
        }
    }


}
