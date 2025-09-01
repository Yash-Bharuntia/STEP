package week3.assignmentProblems;

import java.util.*;
class Student{
    String id;
    String name;
    String className;
    String[] subjects;
    double[][] marks;
    double percentage;
    static int totalStudents=0;
    static String schoolName="Simple School";
    static String[] gradeScale=new String[]{"A","B","C","D","F"};
    static double passMark=40.0;
    public Student(String id,String name,String className,String[] subjects){
        this.id=id;
        this.name=name;
        this.className=className;
        this.subjects=subjects;
        this.marks=new double[subjects.length][3];
        this.percentage=0;
        totalStudents++;
    }
    public void addMarks(int subjectIndex,double t1,double t2,double exam){
        marks[subjectIndex][0]=t1;
        marks[subjectIndex][1]=t2;
        marks[subjectIndex][2]=exam;
    }
    public void computePercentage(){
        double sum=0;
        for(int i=0;i<subjects.length;i++){
            sum+=marks[i][0]*0.2+marks[i][1]*0.3+marks[i][2]*0.5;
        }
        percentage=sum/subjects.length;
    }
    public String grade(){
        if(percentage>=85) return "A";
        if(percentage>=70) return "B";
        if(percentage>=55) return "C";
        if(percentage>=40) return "D";
        return "F";
    }
    public String summary(){
        return schoolName+" "+name+" "+className+" "+percentage+"% Grade:"+grade();
    }
    public static double averageForSubject(List<Student> list,int subjectIndex){
        double sum=0;
        for(Student s:list) sum+=s.marks[subjectIndex][0]*0.2+s.marks[subjectIndex][1]*0.3+s.marks[subjectIndex][2]*0.5;
        return sum/list.size();
    }
    public static Student topStudent(List<Student> list){
        Student best=null;
        for(Student s:list){
            s.computePercentage();
            if(best==null || s.percentage>best.percentage) best=s;
        }
        return best;
    }
    public static Map<String,Integer> gradeDistribution(List<Student> list){
        Map<String,Integer> m=new LinkedHashMap<>();
        for(String g:gradeScale) m.put(g,0);
        for(Student s:list){
            s.computePercentage();
            String g=s.grade();
            m.put(g,m.get(g)+1);
        }
        return m;
    }
    public static void compareClasses(Map<String,List<Student>> classes){
        for(String c:classes.keySet()){
            List<Student> list=classes.get(c);
            double sum=0;
            for(Student s:list){
                s.computePercentage();
                sum+=s.percentage;
            }
            double avg=sum/list.size();
            System.out.println(c+" Avg:"+avg);
        }
    }
}
public class Assignment4{
    public static void main(String[] args){
        String[] subs=new String[]{"Math","Science","English"};
        Student s1=new Student("S1","Aman","X-A",subs);
        Student s2=new Student("S2","Bina","X-A",subs);
        Student s3=new Student("S3","Charu","X-B",subs);
        s1.addMarks(0,18,24,76);
        s1.addMarks(1,16,22,70);
        s1.addMarks(2,20,25,80);
        s2.addMarks(0,15,20,60);
        s2.addMarks(1,14,19,55);
        s2.addMarks(2,18,21,65);
        s3.addMarks(0,19,26,78);
        s3.addMarks(1,17,24,72);
        s3.addMarks(2,21,26,82);
        List<Student> all=new ArrayList<>();
        all.add(s1);all.add(s2);all.add(s3);
        for(Student s:all){ s.computePercentage(); System.out.println(s.summary()); }
        System.out.println("Top: "+Student.topStudent(all).name);
        System.out.println("Subject0 Avg: "+Student.averageForSubject(all,0));
        System.out.println(Student.gradeDistribution(all));
        Map<String,List<Student>> classes=new LinkedHashMap<>();
        classes.put("X-A",Arrays.asList(s1,s2));
        classes.put("X-B",Arrays.asList(s3));
        Student.compareClasses(classes);
    }
}