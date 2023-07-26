/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_association;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Student
 */
class Student{
    private int stidentId;
    private String studentName;
    private double studentCGPA;
    
    Student(){
        
    }
    Student(int sid, String name, double cg){
        this.stidentId = sid;
        this.studentCGPA = cg;
        this.studentName = name;   
    }
    
    public int getSid(){
        return this.stidentId;
    }
    
    public String getSname(){
        return this.studentName;
    }
    
    public void setName(String name){
        this.studentName = name;
    }
    public String to_String(){
        return "Name : "+this.studentName + " Id: "+ this.stidentId + " CG : " + this.studentCGPA;
    }
}

class Faculty{
    private int facultyId;
    private String facultyName;
    private String facultyPosition;
    
    Faculty(){
        
    }
    Faculty(int fid, String name, String fp){
        this.facultyId = fid;
        this.facultyName = name;
        this.facultyPosition = fp;
    }
    
    public int getFid(){
        return this.facultyId;
    }
    
    public void setName(String name){
        this.facultyName = name;
    }
    
    public String to_String(){
        return "Name : "+this.facultyName + " Id: "+ this.facultyId + " Position : " + this.facultyPosition;
    }
       
}

class Course{
    private String courseId;
    private String courseTitle;
    private double credit;
    private int numberOfStudent = 0;
    private ArrayList<Student> studentList = new ArrayList<Student>(); 
    private Faculty faculty;
    
    Course(){
        
    }
    Course(String cid, String ctitle, double cr){
        this.courseId = cid;
        this.courseTitle = ctitle;
        this.credit = cr;
    }
    
    public String to_String(){
        return "Course Title : "+this.courseTitle + " Id: "+ this.courseId + " Credit : " + this.credit;
    }
    
    public String getCid(){
        return this.courseId;
    }
    
    public void addStudent(Student s){
        studentList.add(s);
        this.numberOfStudent++;
    }
    
    public void dropStudent(int sid){
        int ind = -1, f = 0;
        
        for(int i = 0; i < studentList.size(); ++i){
            
            if(this.studentList.get(i).getSid() == sid){
                ind = i;
                f = 1;
                break;
            }
                
        }
        if(f == 1){
            studentList.remove(ind);
            this.numberOfStudent--;
        }
        
    }
    
    public void addFaculty(Faculty f){
        this.faculty = f;
    }
    
    public void dropFaculty(){
        this.faculty = null;
    }
    
    public void printStudentList(){
        for(int i = 0; i < studentList.size(); ++i){ 
            System.out.println("Name: " + studentList.get(i).getSname() + " ID: " + studentList.get(i).getSid() + "" );       
        }
    } 
    
}
public class Main {
    public  static void main(String[] args){
        ArrayList<Student> sList = new ArrayList<Student>(); 
        ArrayList<Course> cList = new ArrayList<Course>();
        ArrayList<Faculty> fList = new ArrayList<Faculty>();
        
        Scanner inp = new Scanner(System.in);
        
        while(true){
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("3. Update");
            System.out.println("4. Print");
            System.out.println("6. Search");
            int n;
            n = inp.nextInt(); 
            
            if(n == 1){
                System.out.println("11. Add a Student");
                System.out.println("12. Add a Course");
                System.out.println("13. Add a Faculty");
                
                n = inp.nextInt(); 
                
                if(n == 11){
                    String sname;
                    double cg; int id;
                    System.out.println("Enter Student Id: ");
                    id = inp.nextInt();
                    inp.nextLine();
                    System.out.println("Enter Student Name: ");
                    sname = inp.nextLine();
                    System.out.println("Enter Student CGPA: ");
                    cg = inp.nextDouble();
                    
                    Student s1 = new Student(id, sname, cg);
                    sList.add(s1);   
                    System.out.println(s1.to_String());
                    
                }else if(n == 12){
                    
                    String sname,pos;
                     int id;
                    inp.nextLine();
                    System.out.println("Enter Faculty Name: ");
                    sname = inp.nextLine();
                    inp.nextLine();
                    System.out.println("Enter Student Position: ");
                    pos = inp.nextLine();
                    System.out.println("Enter Student id: ");
                    id  = inp.nextInt();
                    
                    Faculty f1 = new Faculty(id, sname, pos);
                    fList.add(f1);   
                    System.out.println(f1.to_String());
                    
                }else if(n == 13){
                    String sname,id;double cr;
                    
                    inp.nextLine();
                    System.out.println("Enter Course Name: ");
                    sname = inp.nextLine();
                    inp.nextLine();
                    System.out.println("Enter Course Code: ");
                    id = inp.nextLine();
                    System.out.println("Enter Course credits: ");
                    cr  = inp.nextDouble();
                    
                    Course c1 = new Course(id, sname, cr);
                    cList.add(c1);   
                    System.out.println(c1.to_String());
                }else{
                    System.out.println("Enterd wrong input ");
                    
                }              
            }else if(n == 2){
                System.out.println("21. Delete a Student");
                System.out.println("22. Delete a Course");
                System.out.println("23. Delete a Faculty");
                
                n = inp.nextInt(); 
                
                if(n == 21){
                    int id;
                    System.out.println("Enter Student Id: ");
                    id = inp.nextInt();
                    
                    int ind = -1, f = 0;
        
                    for(int i = 0; i < sList.size(); ++i){

                        if(sList.get(i).getSid() == id){
                            ind = i;
                            f = 1;
                            break;
                        }
                    }
                    if(f == 1){
                        sList.remove(ind);
                    }else{  
                        System.out.println("Stduent Id didn't matched");
                    }
                }else if(n == 22){
                    
                    String id;
                    System.out.println("Enter Course Id: ");
                    id = inp.nextLine();
                    
                    int ind = -1, f = 0;
        
                    for(int i = 0; i < cList.size(); ++i){

                        if(cList.get(i).getCid().equals(id)){
                            ind = i;
                            f = 1;
                            break;
                        }
                    }
                    if(f == 1){
                        cList.remove(ind);
                    }else{  
                        System.out.println("Course Id didn't matched");
                    }
                    
                }else if(n == 23){
                   int id;
                    System.out.println("Enter Faculty Id: ");
                    id = inp.nextInt();
                    
                    int ind = -1, f = 0;
        
                    for(int i = 0; i < fList.size(); ++i){

                        if(fList.get(i).getFid() == id){
                            ind = i;
                            f = 1;
                            break;
                        }
                    }
                    if(f == 1){
                        fList.remove(ind);
                    }else{  
                        System.out.println("Faculty Id didn't matched");
                    }
                }else{
                    System.out.println("Enterd wrong input ");
                    
                }   
            }else if(n == 3){
                
                System.out.println("31. Update a Student");
                System.out.println("32. Update a Course");
                System.out.println("33. Update a Faculty");
                
                n = inp.nextInt(); 
                
                if(n == 31){
                    int id;
                    System.out.println("Enter Student Id: ");
                    id = inp.nextInt();
                    
                    int ind = -1, f = 0;
        
                    for(int i = 0; i < sList.size(); ++i){

                        if(sList.get(i).getSid() == id){
                            ind = i;
                            f = 1;
                            break;
                        }
                    }
                    if(f == 1){
                        String name;
                        inp.nextLine();
                        System.out.println("Enter Student new Name: ");
                        name = inp.nextLine();
                        sList.get(ind).setName(name);
                        
                    }else{  
                        System.out.println("Stduent Id didn't matched");
                    }
                }else if(n == 32){
                    
                    String id;
                    System.out.println("Enter Course Id: ");
                    id = inp.nextLine();
                    
                    int ind = -1, f = 0;
        
                    for(int i = 0; i < cList.size(); ++i){

                        if(cList.get(i).getCid().equals(id)){
                            ind = i;
                            f = 1;
                            break;
                        }
                    }
                    if(f == 1){
                        cList.remove(ind);
                    }else{  
                        System.out.println("Course Id didn't matched");
                    }
                    
                }else if(n == 33){
                   int id;
                    System.out.println("Enter Faculty Id: ");
                    id = inp.nextInt();
                    
                    int ind = -1, f = 0;
        
                    for(int i = 0; i < fList.size(); ++i){

                        if(fList.get(i).getFid() == id){
                            ind = i;
                            f = 1;
                            break;
                        }
                    }
                    if(f == 1){
                        String name;
                        inp.nextLine();
                        System.out.println("Enter Faculty new Name: ");
                        name = inp.nextLine();
                        fList.get(ind).setName(name);
                        
                    }else{  
                        System.out.println("Faculty Id didn't matched");
                    }
                }else{
                    System.out.println("Enterd wrong input ");    
                } 
                
            }else if(n == 4){
                
                System.out.println("41. Print all Student");
                System.out.println("42. Print all Course");
                System.out.println("43. Print all Faculty");
                System.out.println("44. Print information of a Student");
                System.out.println("45. Print information of a Course");
                System.out.println("46. Print information of a faculty");
                
                System.out.println("47. Print student list and faculty takes a course");
                System.out.println("48. Print course taken by a student");
                
                n = inp.nextInt();
                
                switch(n)
                {
                    case(41):
                    {
                        for(int i = 0; i < sList.size(); ++i){
                           System.out.println(sList.get(i).to_String());
                        }  
                        break;
                    }
                    case(42):
                    {
                        for(int i = 0; i < fList.size(); ++i){
                           System.out.println(fList.get(i).to_String());
                        }   
                        break;
                    }
                    case(43):
                    {
                        for(int i = 0; i < cList.size(); ++i){
                           System.out.println(cList.get(i).to_String());
                        } 
                        break;
                        
                    }
                    case(44):
                    {
                        int id;
                        id = inp.nextInt();
                        for(int i = 0; i < sList.size(); ++i){
                            if(sList.get(i).getSid() == (id)){
                                System.out.println(sList.get(i).toString());                          
                            }
                        }  
                        break;
                    }
                    case(45):
                    {
                        inp.nextLine();
                        String id;
                        id = inp.nextLine();
                        for(int i = 0; i < cList.size(); ++i){
                            if(cList.get(i).getCid().equals(id)){
                                System.out.println(cList.get(i).toString());                          
                            }
                        }  
                        break;
                    }
                    case(46):
                    {
                        int id;
                        id = inp.nextInt();
                        for(int i = 0; i < fList.size(); ++i){
                            if(fList.get(i).getFid() == (id)){
                                System.out.println(fList.get(i).toString());                          
                            }
                        }  
                        break;
                    }
                    case(47):
                    {
                        
                    }
                    default:
                    {
                                
                    }
                    
                }
                      
                
            }else if(n == 5){
                
            }else{
                
            }
           
        }
        
        
        
        
        
    }
}
