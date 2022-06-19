package com.zsy.xyapp;

import java.util.Scanner;

public class test {
    static String str = "";        //待测试语句
    static int index = 0;//记录当前读到的序号
    static  int kh=0;
    /**
     * 与：&
     * 或：|
     * 非：!
     * 定义下列文法
     * （1）E->iGE1
     * （2）E1->GE1|ε
     * （3）G->&FG | |FG| !FG|ε
     * （4）F->(E)|i
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(1==1){
            System.out.println("请输入一个符号串:");
            str = input.nextLine();
            str=str+"#";

            int getis = getis(str);
            if (getis==0){
                System.out.println("语法错误,该表达式错误");
                continue;
            }
            index = 0;
            int t = E();                      //文法
            if(t == 1) {
                if (kh!=0){
                    System.out.println("非法字符串！！括号不匹配！"+kh);
                }else {
                    System.out.println(str+" 为合法符号串.");}
            }
            else {
                System.out.println(str+" 为非法符号串！");
            }
            kh=0;
        }

    }

    /**
     * 读取下一个字符
     * @return 返回下一个字符，长度超出返回' '字符
     */
    static char getchar() {
        if(index < str.length()) {
            index++;
            return str.charAt(index - 1);
        }
        return ' ';
    }

    /**
     * 调用文法1
     * @return 返回0或1，0表示错误
     */
    static int E() {
        char ch = getchar();
        int jump = jump(ch);
        if (jump!=0){
            ch = getchar();
        }
        if(ch != 'i') {
            if (ch==' '){
                index=index-2;
                char getchar = getchar();
                System.out.println("错误：符号'"+getchar+"'后没有数字数字");
            }
            else {
                System.out.println("错误:以" + ch + "开头");
            }
            return  0;
        }
        return  G() * E1();
    }



    /**
     * 调用文法5
     * @return 回0或1，0表示错误
     */
    static int F() {
        char ch = getchar();
        //跳过括号
        int jump = jump(ch);
        if (jump!=0){
            ch = getchar();
        }

        if(ch == 'i') {
            return 1;
        }
        return E();
    }

    /**
     * 调用文法3
     * @return 回0或1，0表示错误
     */
    static int G() {
        char ch = getchar();
        //跳过括号
        int jump = jump(ch);
        if (jump!=0){
            ch = getchar();
        }
        if(ch == '&'|ch == '|') {
            return F()  * G();
        }else if(ch == 'i') {
            return 0;
        }
        return 1;
    }

    /**
     * 调用文法2
     * @return 返回0或1，0表示错误
     */
    static int E1() {
        char ch = getchar();

        //跳过括号
        int jump = jump(ch);
        if (jump!=0){
            ch = getchar();
        }

        if(ch == 'i') {
            return 0;
        }
        if(ch == ' ') {
            return 1;
        }

        return  G() * E1();
    }



    static  int jump(char x){
        if (x=='('){

            kh++;
            //  System.out.println("左括号");
            return 1;
        }
        if (x==')'){
            kh--;
            // System.out.println("右括号");
            return 1;
        }
        if (x=='!'){
            return 1;
        }
        return 0;
    }
    public static int getis(String s){
        int x=s.length();
        if (s.length()<2) {
            return 0;
        }
        for (int i=0;i<s.length()-2;i++) {
            char a= s.charAt(i);
            char b=s.charAt(i+1);

            if (a==b){
                return 0;
            }
        }
        return 1;

    }
}
