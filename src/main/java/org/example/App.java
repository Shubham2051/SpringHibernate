package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.orm.dao.StudentDao;
import spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context =new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
         Student student=new Student(234,"Shubham upadhyay","Lucknow");
        int r=studentDao.insert(student);

        System.out.println( "done"+r);

    }
}
