//
// Created by zjh on 2020/9/8.
//

#include <iostream>
using namespace std;

int main(){
     int year;

        cout << "输入年份: ";
        cin >> year;

        if (year % 4 == 0)
        {
            if (year % 100 == 0)
            {
                // // 这里如果被 400 整数是闰年
                if (year % 400 == 0)
                    cout << year << " 是闰年";
                else
                    cout << year << " 不是闰年";
            }
            else
                cout << year << " 是闰年";
        }
        else
            cout << year << " 不是闰年";

        return 0;
}