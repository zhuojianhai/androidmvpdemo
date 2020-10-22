//
// Created by zjh on 2020/9/18.
//
#include <stdio.h>
enum color{red,yellow,green}
void f(enum color c);
struct date{
    int month;
    int day;
    int year;
};

int main(){
enum color t = red;
f(t);
struct date today;
return 0;
}


