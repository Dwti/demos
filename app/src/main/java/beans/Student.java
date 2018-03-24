package beans;

import org.litepal.crud.DataSupport;

/**
 * Created by sunpeng on 2018/3/23.
 * Litepal在进行表的操作的时候，不需要跟模型类有继承的结构
 * 但是在进行CRUD的时候需要有继承DataSupport
 * 原因不知道？
 */

public class Student extends DataSupport {
    private int id;
    private  String name;
    private  String sex;
    private  int age;
    private String school;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getSchool() {
        return school;
    }
}
