package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.orm.dao.StudentDao;
import spring.orm.entities.Student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class console_main {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        boolean go=true;
        while (go){
            System.out.println("Press 1 for add new student");
            System.out.println("Press 2 for display all student");
            System.out.println("Press 3 for get details of single student");
            System.out.println("Press 4 for delete student");
            System.out.println("Press 5 for update student");
            System.out.println("Press 6 for EXIT");

            try{
                int input =Integer.parseInt(br.readLine());
                switch (input){
                    case 1:
                        // add Student
                        System.out.println("Enter User Id : ");
                        int uId =Integer.parseInt(br.readLine());

                        System.out.println("Enter User Name : ");
                        String  uName  =br.readLine();

                        System.out.println("Enter User City : ");
                        String uCity= br.readLine();

                        Student student=new Student();
                        student.setStudentId(uId);
                        student.setStudentName(uName);
                        student.setStudentCity(uCity);
                        int r= studentDao.insert(student);
                        System.out.println(r + "student added");
                        System.out.println("********************************************************");
                        System.out.println();

                        break;
                    case 2:
                        // Display all Student

                        List<Student> allStudents= studentDao.getAllStudents();
                        System.out.println("********************************************************");
                        for(Student s:allStudents){
                            System.out.println(s);
                            System.out.println("----------------------------------------------------");
                        }
                        System.out.println("********************************************************");
                        break;
                    case 3:

                        System.out.println("Enter User Id details need to be fetched : ");
                        int sId =Integer.parseInt(br.readLine());
                        Student s=studentDao.getStudent(sId);
                        System.out.println("********************************************************");
                        System.out.println(s);
                        System.out.println("********************************************************");
                        break;

                    case 4:
                        System.out.println("Enter User Id details need to be Deleted : ");
                        int dId =Integer.parseInt(br.readLine());
                        studentDao.deleteStudent(dId);
                        System.out.println(dId + "details are deleted");

                        break;
                    case 5:
                        System.out.println("Enter User Id : ");
                        int rId =Integer.parseInt(br.readLine());

                        System.out.println("Enter User Name : ");
                        String  rName  =br.readLine();

                        System.out.println("Enter User City : ");
                        String rCity= br.readLine();

                        Student str=new Student();
                        str.setStudentId(rId);
                        str.setStudentName(rName);
                        str.setStudentCity(rCity);
                        studentDao.updateStudent(str);
                        System.out.println("student updated");
                        System.out.println("********************************************************");
                        System.out.println();

                        break;
                    case 6:
                        go=false;
                        break;



                }


            }
            catch (Exception e){
                System.out.println("Invalid Input try with another one !!");
                System.out.println(e.getMessage());
            }

        }




    }
}
