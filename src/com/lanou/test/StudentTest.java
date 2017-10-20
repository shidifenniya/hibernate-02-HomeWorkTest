package com.lanou.test;

import com.lanou.domain.Grade;
import com.lanou.domain.StudentNexus;
import com.lanou.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * Created by dllo on 17/10/18.
 */
public class StudentTest {

    private Session session;

    private Transaction transaction;

    @Before
    public void init(){

        session = HibernateUtil.getSession();

        transaction = session.beginTransaction();

    }

    @After
    public void destroy(){

        transaction.commit();

        HibernateUtil.closeSession();

    }

    /* 保存班级级联保存学生 */
    @Test
    public void saveInfo(){

        StudentNexus nexus = new StudentNexus("XiaoHei");

        Grade grade = new Grade("三年E班");

        nexus.setGrade(grade);

        grade.getStudentNexusSet().add(nexus);

        session.save(nexus);

    }

    /* 保存班级级联更新学生 */
    @Test
    public void saveGrade(){

        Grade grade = new Grade("五年二班");

        StudentNexus studentNexus = session.get(StudentNexus.class,1);

        studentNexus.setGrade(grade);

        grade.getStudentNexusSet().add(studentNexus);

        session.save(grade);

    }

    /* 更新班级级联保存学生 */
    @Test
    public void addStudent(){

        Grade grade = session.get(Grade.class,1);

        StudentNexus studentNexus = new StudentNexus("2号B型人造人");

        grade.getStudentNexusSet().add(studentNexus);

        studentNexus.setGrade(grade);

    }

    /* 更新班级级联更新学生 */
    @Test
    public void updateStudent(){

        Grade grade = session.get(Grade.class,1);

        Set<StudentNexus> set = grade.getStudentNexusSet();

        for (StudentNexus studentNexus : set) {

            studentNexus.setStudentName("二皮丘");

        }

    }

    /* 删除班级级联删除学生 */
    @Test
    public void delete(){

        Grade grade = session.get(Grade.class,1);

        session.delete(grade);

    }

    /* B:保存班级级联保存学生(班级已经存在) */
    @Test
    public void saveStudent(){

        StudentNexus nexus = new StudentNexus("yayoi");

        Grade grade = session.get(Grade.class,1);

        grade.getStudentNexusSet().add(nexus);

        nexus.setGrade(grade);

    }

    /* B:已经存在一个学生, 把一个学生从另一个班级cid=2转入该班级cid=1*/
    @Test
    public void StudentToGrade(){

        StudentNexus studentNexus = session.get(StudentNexus.class,1);

        Grade grade = session.get(Grade.class,4);

        studentNexus.setGrade(grade);

        grade.getStudentNexusSet().add(studentNexus);

    }

    /* B:已经存在一个学生, 新建一个班级, 把学生加入到该班级 */
    @Test
    public void StudentToNewGrade(){



    }

}
