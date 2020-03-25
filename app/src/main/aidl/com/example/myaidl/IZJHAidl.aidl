// IZJHAidl.aidl
package com.example.myaidl;
import com.example.myaidl.bean.Book;
// Declare any non-default types here with import statements

interface IZJHAidl {

    boolean addBook(in Book book);
    List<Book> getBookList();

}
