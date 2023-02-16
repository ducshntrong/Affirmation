package com.example.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.sadf.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Tạo một thực thể của Datasource và gọi phương thức loadAffirmations() trên thực thể đó.
        // Lưu danh sách lời tự động viên được trả về trong một biến val có tên myDataset.
        val myDataset = Datasource().loadAffirmations()
        //Tạo biến có tên recyclerView và sử dụng phương thức findViewById() để tìm tham
        // chiếu đến RecyclerView trong bố cục.
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        // Sử dụng cài đặt này để cải thiện hiệu suất nếu bạn biết rằng các thay đổi
        // trong nội dung không thay đổi kích thước bố cục của RecyClerview
        recyclerView.setHasFixedSize(true)
    }
}