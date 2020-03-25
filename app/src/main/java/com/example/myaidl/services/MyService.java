package com.example.myaidl.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.myaidl.IZJHAidl;
import com.example.myaidl.bean.Book;

import java.util.ArrayList;
import java.util.List;


public class MyService extends Service {
    private List<Book> bookList = new ArrayList<>();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();

    }

    class MyBinder extends IZJHAidl.Stub{

        @Override
        public boolean addBook(Book book) throws RemoteException {
            bookList.add(book);
            return true;
        }

        @Override
        public List<Book> getBookList() throws RemoteException {

            return bookList;
        }
    }
}
