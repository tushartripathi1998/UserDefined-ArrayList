import java.util.*;

class Student{
  String name;
  int contact;
  int age;
Student(String name,int contact,int age){
  this.name=name;
  this.contact=contact;
  this.age=age;
}
}

public class javacoll{
  public static void main(String[] args){
  Student s1=new Student("Tushar",88885,21);
  Student s2=new Student("Sandeep",96885,22);
  Student s3=new Student("ashu",7057,20);
  Student s4=new Student("abhinav",6995,23);

  ArrayList<Student> al=new  ArrayList<Student>();
  al.add(s1);
  al.add(s2);
  al.add(s3);
  al.add(s4);

  for(Student s:al){
    System.out.println(s.name+" "+s.contact+" "+s.age);
  }
}
}
