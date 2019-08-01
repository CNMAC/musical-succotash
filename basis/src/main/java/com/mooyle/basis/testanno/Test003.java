package com.mooyle.basis.testanno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface Table{
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Property{
    String name();
    int lenth() default 0;
}

@Table("mooyle_student")
class Student{
    @Property(name = "student_id", lenth = 10)
    private String studentId;
    @Property(name = "student_name")
    private String studentName;
    @Property(name = "student_age")
    private String studentAge;
}

public class Test003 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> forName = Class.forName("com.mooyle.basis.testanno.Student");
        Table table = forName.getDeclaredAnnotation(Table.class);
        Field[] fields = forName.getDeclaredFields();
        StringBuffer sf = new StringBuffer();
        sf.append("select ");
        for(int i = 0; i <fields.length; i ++){
            Field field = fields[i];
            Property property = field.getDeclaredAnnotation(Property.class);
            sf.append(property.name());
            if(i < fields.length -1){
                sf.append(", ");
            }

        }
        sf.append(" from " + table.value());
        System.out.println(sf.toString());
    }
}
