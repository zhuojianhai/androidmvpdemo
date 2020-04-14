package com.example.myaidl.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.example.myaidl.R;

import java.util.ArrayList;

public class CoordinatLayout2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinat_layout2);

        RecyclerView recyclerView = new RecyclerView(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

    }

    /**
     * 从Recycler的scrap，cache，RecyclerViewPool,或者直接create创建，这里我们也看到了我们最熟悉的**mAdapter.createViewHolder(RecyclerView.this, type); **方法！
     *
     * 作者：被代码淹没的小伙子
     * 链接：https://www.jianshu.com/p/c52b947fe064
     * 来源：简书
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private ArrayList<String> dataSource = new ArrayList<>();



        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return dataSource.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
