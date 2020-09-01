package com.twu;

import java.util.*;

public class Search extends Content{
    public TreeMap<Integer, Content> getSearch() {
        return search;
    }

    public void setSearch(TreeMap<Integer, Content> search) {
        this.search = search;
    }

    public int getNowTicked() {
        return nowTicked;
    }

    public void setNowTicked(int nowTicked) {
        this.nowTicked = nowTicked;
    }

    public int getUserTicked() {
        return userTicked;
    }

    public void setUserTicked(int userTicked) {
        this.userTicked = userTicked;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTh() {
        return th;
    }

    public void setTh(int th) {
        this.th = th;
    }

    TreeMap<Integer,Content> search = new TreeMap<Integer,Content>();
//    new Comparator<Integer>() {
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return o2 - o1;
//        }
//    }
    int nowTicked = 0;
    int userTicked = 10;
    int count,price = 0;
    int th = 1;
    Integer num1,num2;



    public void showSearchs(int flag){

//        for (Map.Entry<Integer, Content> entry : search.entrySet()) {
//            //th = search.size() +1 +nowTieck -entry.getKey();
////            System.out.println("热搜排行"+th+"： " + entry.getValue()+"  "+entry.getKey());
////            th++;
//            System.out.println("热搜排行"+entry.getKey()+"： " + entry.getValue().content+"  "+entry.getValue().ticket);
//        }
//        th = 1;

        List<Map.Entry<Integer, Content>> list = new ArrayList<Map.Entry<Integer, Content>>(search.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<Integer,Content>>() {
            //降序排序
            public int compare(Map.Entry<Integer,Content> o1, Map.Entry<Integer,Content> o2) {
                num1 = o1.getValue().ticket;
                num2 = o2.getValue().ticket;
                return num2.compareTo(num1);
            }
        });
        Collections.sort(list,new Comparator<Map.Entry<Integer,Content>>() {
            //升序排序
            public int compare(Map.Entry<Integer,Content> o1, Map.Entry<Integer,Content> o2) {
                num1 = o1.getValue().rank;
                num2 = o2.getValue().rank;
                return num1.compareTo(num2);
            }
        });
        if (flag == 1){
            for (Map.Entry<Integer,Content> e: list) {
                //search.put(th,e.getValue());
                System.out.println("热搜排行"+th+":"+e.getValue().content+" "+e.getValue().ticket);
                th++;
            }
            th = 1;
        }else{
            for (Map.Entry<Integer,Content> e: list) {
                System.out.println("热搜编号"+e.getKey()+":"+e.getValue().content+" "+e.getValue().ticket);
            }
        }

        if (search == null){
            System.out.println("目前还没有热搜");
        }
    }
    public void voteSearch(){
        if (count == 0){
            System.out.println("目前还没有热搜");
        }else {
                System.out.println("请输入所需要投票的热搜编号");
                showSearchs(2);
                Scanner sc = new Scanner(System.in);
                int serial = sc.nextInt();



                if (search.containsKey(serial)){
                    //User user = new User();
                    System.out.println("请输入投票数(您目前还有"+userTicked+")票");
                    int useTickes = sc.nextInt();
                    if(useTickes > userTicked){
                        System.out.println("您目前还有："+userTicked+"票,投票失败");
                    }else {
                        userTicked = userTicked - useTickes;
                        System.out.println("您目前还有："+userTicked+"票,成功！");
                        Content value=search.get(serial);
                        if (value.super_moderator == 1){
                            useTickes = 2*useTickes;
                        }
                        nowTicked = value.ticket + useTickes;
                        value.ticket = nowTicked;
                        search.put(serial,value);
                    }
                }else {
                    System.out.println("您的输入有误！");
                }

        }

    }
    public void buySearch(){
        System.out.println("请输入所需要购买的热搜：");
        showSearchs(2);
        Scanner sc = new Scanner(System.in);
        //String content = sc.next();
        int serial = sc.nextInt();
        System.out.println("请输入所需要购买的热搜（热度）排名：");
        int rank = sc.nextInt();
        System.out.println("请输入所需要购买热搜的拍卖金额(起拍价:"+price+")：");
        int money = sc.nextInt();


        //contents.content = content;
        if(search.containsKey(serial)){
            if (money > price){
                price = money;
                Content contents = search.get(serial);
                contents.rank = rank-1;
                search.put(serial,contents);
                System.out.println("购买成功，起拍价变为："+price);
            }
        }

    }
    public void addSearch(){
        System.out.println("请输入所需要添加的热搜：");
        Scanner sc = new Scanner(System.in);
        String content = sc.next();
        Content contenth = new Content();
        contenth.content = content;
        count++;
        search.put(count,contenth);
        System.out.println("热搜添加成功！");
    }

    public void addSuperSearch(){
        System.out.println("请输入所需要添加的超级热搜：");
        Scanner sc = new Scanner(System.in);
        String content = sc.next();
        Content contenth = new Content();
        contenth.content = content;
        contenth.super_moderator = 1;
        count++;
        search.put(count,contenth);
        System.out.println("热搜添加成功！");
    }




}
