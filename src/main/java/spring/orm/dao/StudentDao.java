package spring.orm.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import spring.orm.entities.Student;

import java.util.List;

public class StudentDao {

   private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public int insert(Student student){
       Integer i=(Integer) this.hibernateTemplate.save(student);
       return i;
   }


   // get Single data(object)
   public Student getStudent(int studentId){
        Student student =this.hibernateTemplate.get(Student.class,studentId);
        return student;
   }

   //get Multiple entry
    public List<Student> getAllStudents(){
        List<Student> students=this.hibernateTemplate.loadAll(Student.class);
        return students;

    }

    // Delete entry
    @Transactional
    public void deleteStudent(int studentID){
        Student student=this.hibernateTemplate.get(Student.class,studentID);
        this.hibernateTemplate.delete(student);
    }

    //updating data
    @Transactional
    public  void updateStudent(Student student){
        this.hibernateTemplate.update(student);
    }






}
