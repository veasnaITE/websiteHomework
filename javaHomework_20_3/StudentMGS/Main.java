package StudentMGS;

import java.util.ArrayList;
import java.util.Scanner;

//Student Management Console Application
//        Select/Insert/Update/Remove Student
//        Data Validation
class Student{
    String name;
    String gender;
    int id;
    int age;
    String className;
    float score;
    String address;
    Student(){}
    Student(String name, String gender, int id,int age,String className,float score, String address ){
        this.name=name;
        this.gender=gender;
        this.id= id;
        this.age=age;
        this.className=className;
        this.score=score;
        this.address=address;
    }
    void input(Scanner input){
        System.out.println("---------------Input Student Info------------------");
        boolean isIdValid= false;
        do{
            try{
                System.out.println("Enter ID: ");
                String strId;
                strId=input.next();
                this.id=Integer.parseInt(strId);
                isIdValid=true;
            }catch (Exception e){
                System.out.println("You Input the Invalid ID:");
            }
        }while (!isIdValid);
        input.nextLine();
        System.out.println("Enter Name: ");
        this.name=input.nextLine();
        boolean isAgeValid=false;
        do{
            try{
                System.out.println("Enter Age: ");
                String strAge;
                strAge=input.next();
                this.age=Integer.parseInt(strAge);
                isAgeValid=true;
            }catch (Exception e){
                System.out.println("You Input the Invalid Age:");
            }
        }while (!isAgeValid);
        input.nextLine();
        System.out.println("Enter Gender:");
        this.gender=input.nextLine();
        System.out.println("Enter Class Name:");
        this.className=input.nextLine();
        boolean isScoreValid=false;
        do{
            try{
                System.out.println("Enter Score: ");
                String strScore;
                strScore=input.next();
                this.score=Integer.parseInt(strScore);
                isScoreValid=true;
            }catch (Exception e){
                System.out.println("You Input the Invalid Score:");
            }
        }while (!isScoreValid);
        input.nextLine();
        System.out.println("Enter Current address: ");
        this.address=input.nextLine();
    }
    void output(){
        System.out.print("{ ID:"+id);
        System.out.print(",Name:"+name);
        System.out.print(",Age:"+age);
        System.out.print(",Gender:"+gender);
        System.out.print(",Class Name:"+className);
        System.out.print(",Score:"+score);
        System.out.print(" ,Address: "+address+" }");
        System.out.println();
    }


}
public class Main {
    static  void presEnter(){
        System.out.println("===========Press Enter Key to continous =====");
        Scanner scanner =new Scanner(System.in);
        scanner.nextLine();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList <Student> students = new ArrayList<>();
        int option =0 ;
        do {
            System.out.println("--------------Student Management System--------------");
            System.out.println("1.Insert Student");
            System.out.println("2.Select Student");
            System.out.println("3.Update Student Information");
            System.out.println("4.Show Student Info");
            System.out.println("5.Remove Student");
            System.out.println("6.Exit!!!!");
            boolean isOptionValid=false;
            do {
                try {
                    System.out.println("Enter One Option: ");
                    String strOption= input.next();
                    option=Integer.parseInt(strOption);
                    isOptionValid=true;
                }catch (Exception e){
                    System.out.println("Please input Option From (1-5) Plz");
                }
            }while (!isOptionValid);
            switch (option){
                case 1:
                    System.out.println("------Please Fill the information Below---------");
                    Student newStudent = new Student();
                    newStudent.input(input);
                    students.add(newStudent);
                    System.out.println("---------Insert Student Successfully----------");
                    break;

                case 2:
                if(students.size()>0)
                {
                    int sOption=0;
                    do {
                        System.out.println("---------Search Option----------");
                        System.out.println("1.Select By Student ID: ");
                        System.out.println("2.Select By Student Name: ");
                        System.out.println("3.Select By Student Gender: ");
                        System.out.println("4.Select By Student Score: ");
                        System.out.println("5.Exit From Select Option");
                        try {
                            System.out.println("Enter One Option: ");
                            String strSOption= input.next();
                            sOption=Integer.parseInt(strSOption);
                        }catch (Exception e){
                            System.out.println("Please input Option From (1-5) Plz");
                        }
                        switch (sOption){
                            case 1:
                               int searchId=0;
                                boolean isIdSearch= false;
                                do{
                                    try{
                                        System.out.println("--------Input ID to Select-------");
                                        String strId;
                                        strId=input.next();
                                        searchId=Integer.parseInt(strId);
                                        isIdSearch=true;
                                    }catch (Exception e){
                                        System.out.println("You Input the Invalid ID:");
                                    }
                                }while (!isIdSearch);
                                boolean isValueSearch =false;
                                if( isIdSearch){
                                    for (int i =0; i<students.size();i++) {
                                        if(searchId==students.get(i).id){
                                            students.get(i).output();
                                            isValueSearch=true;
                                        }
                                    }
                                }
                                if(!isValueSearch){
                                    System.out.println("This "+searchId+" does not exis.....");
                                }
                                presEnter();
                                break;
                            case 2:
                                input.nextLine();
                                System.out.println("--------Input Name to Select--------");
                                String searchName =input.nextLine();
                                boolean isNameExit =false;
                                for (int i =0; i<students.size();i++) {
                                    if(students.get(i).name.equals(searchName)){
                                        students.get(i).output();
                                        isNameExit=true;
                                    }
                                }
                                if(!isNameExit){
                                    System.out.println("This Name does not exit!!!");
                                }
                                presEnter();
                                break;
                            case 3:
                                input.nextLine();
                                System.out.println("-------Input Gender to Select------");
                                String searchGender = input.nextLine();
                                boolean isGenderExit =false;
                                for (int i=0 ;i<students.size();i++){
                                    if(students.get(i).gender.equalsIgnoreCase(searchGender)){
                                        students.get(i).output();
                                        isGenderExit=true;
                                    }
                                }
                                if(!isGenderExit){
                                    System.out.println("This Gender is not exit..!");
                                }
                                presEnter();
                                break;

                            case 4:
                                input.nextLine();
                                boolean isScoreValid =false;
                                float searchScore = 0;
                                do{
                                    try {
                                        System.out.println("---------Input Score to Select-------");
                                        String strSearchScore=input.nextLine();
                                        searchScore= Float.parseFloat(strSearchScore);
                                        isScoreValid=true;
                                    }catch (Exception e){
                                        System.out.println("You Enter the Invalid Score");
                                    }

                                }while (!isScoreValid);
                                boolean isScoreExit=false;
                                if(isScoreValid){
                                for(int i=0;i<students.size();i++){
                                    if(searchScore==students.get(i).score){
                                        students.get(i).output();
                                        isScoreExit=true;
                                        }
                                    }
                                }
                                if(!isScoreExit){
                                    System.out.println("This "+searchScore+" is not exit... ");
                                }
                                presEnter();
                                break;
                        }
                    }while (sOption !=5);
                }else {
                    System.out.println("-----------There is No Student To Search-----------");
                    presEnter();
                }
                break;

                case 3:
                    System.out.println("--------Update Student Information----------");
                    int searchId=0;
                    boolean isIdSearch= false;
                    do{
                        try{
                            System.out.println("--------Input ID to Select-------");
                            String strId;
                            strId=input.next();
                            searchId=Integer.parseInt(strId);
                            isIdSearch=true;
                        }catch (Exception e){
                            System.out.println("You Input the Invalid ID:");
                        }
                    }while (!isIdSearch);
                    boolean isValueSearch =false;
                    if( isIdSearch){
                        for (int i =0; i<students.size();i++) {
                            if(searchId==students.get(i).id){
                                students.get(i).input(input);
                                isValueSearch=true;
                            }
                        }
                    }
                    if(!isValueSearch){
                        System.out.println("This "+searchId+" does not exit.....");
                    }else {
                        System.out.println("Update Student Info successfully");
                    }
                    presEnter();
                break;
                case 4:
                    System.out.println("---------------Show Student Information----------------");
                    for (int i=0 ;i<students.size();i++){
                        students.get(i).output();
                    }
                    presEnter();
                break;

                case 5:
                    input.nextLine();
                    int removeId=0;
                    boolean isRemoveExit= false;
                    do{
                        try{
                            System.out.println("--------Input ID to Select-------");
                            String strId;
                            strId=input.next();
                            removeId=Integer.parseInt(strId);
                            isRemoveExit=true;
                        }catch (Exception e){
                            System.out.println("You Input the Invalid ID:");
                        }
                    }while (!isRemoveExit);
                    boolean isValueRemove =false;
                    if( isRemoveExit){
                        for (int i =0; i<students.size();i++) {
                            if(removeId==students.get(i).id){
                                students.remove(i);
                                isValueRemove=true;
                            }
                        }
                    }
                    if(!isValueRemove){
                        System.out.println("This "+removeId+" does not exit.....");
                    }else {
                        System.out.println("Remove Student Info successfully");
                    }
                    presEnter();
                break;
            }
        }while (option!=6);
    }
}
