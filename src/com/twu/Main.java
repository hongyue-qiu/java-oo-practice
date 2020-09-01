package com.twu;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public boolean userflag;
    public boolean managerflag;
    public boolean bodyflag = true;
    int choice;

    public void body(){
        Search srh = new Search();
        TreeMap<Integer,Content> searchs = srh.getSearch();
        Scanner sc = new Scanner(System.in);
        while (bodyflag){
            System.out.println("欢迎来到热搜排行榜！请选择所登录的角色：");
            System.out.println("1.用户 2.管理员 3.退出");

            choice = sc.nextInt();
            //bodyflag = false;

            //TreeMap<Integer,Content> searchs = srh.getSearch();
            if (choice == 3){
                bodyflag = false;
            }else if(choice == 1){
                bodyflag = false;
                userflag = true;
                System.out.println("请输入你的用户名：");
                String name = sc.next();
                while (userflag){

                    System.out.println("尊敬的"+name+":您好!请您根据提示进行操作：");
                    System.out.println("1.查看热搜排行榜。 2.给热搜事件投票。 3.购买热搜。 4.添加热搜。 5.退出...");
                    int userChoice = sc.nextInt();
                    //Search search = new Search();
                    switch (userChoice){
                        case 1:
                            srh.showSearchs(1);
                            break;
                        case 2:
                            //ticked = 10;
                            srh.voteSearch();
                            break;
                        case 3:
                            srh.buySearch();
                            break;
                        case 4:
                            srh.addSearch();
                            break;
                        case 5:
                            userflag = false;
                            bodyflag = true;
                            break;
                        default:
                            System.out.println("您的输入有误");
                            break;
                    }
                }

            }else if (choice == 2){
                bodyflag = false;
                bodyflag = false;
                System.out.println("请输入你的用户名：");
                String name = sc.next();
                System.out.println("请输入您的密码：");
                String managerPassword = sc.next().toString();
                Manager manager = new Manager();
                if (!name.equals(manager.name) || !managerPassword.equals(manager.password)){
                    System.out.println("您的用户名或密码错误");
                    //srh.body();
                }else {
                    managerflag = true;
                    while (managerflag){
                        System.out.println("尊敬的"+name+":您好!请您根据提示进行操作：");
                        System.out.println("1.查看热搜排行榜。 2.添加热搜。 3.添加超级热搜。 4.退出...");
                        int userChoice = sc.nextInt();
                        //Search search = new Search();
                        switch (userChoice){
                            case 1:
                                srh.showSearchs(1);
                                break;
                            case 2:
                                srh.addSearch();
                                break;
                            case 3:
                                srh.addSuperSearch();
                                break;
                            case 4:
                                managerflag = false;
                                bodyflag = true;
                                break;
                            default:
                                System.out.println("您的输入有误");
                                break;
                        }
                    }

                }
            }


        }



    }

    public static void main(String[] args) {
        Main main = new Main();
        main.body();

    }
}
