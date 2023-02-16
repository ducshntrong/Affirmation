package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.sadf.modelc.Affirmation
/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
 */
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    // cung cấp một tham chiếu đến các chế độ xem cho từng mục dữ liệu
    // Các mục dữ liệu phức tạp có thể cần nhiều hơn một chế độ xem cho mỗi mục và
    // Bạn cung cấp quyền truy cập vào tất cả các chế độ xem cho một mục dữ liệu trong phần giữ chế độ xem.
    // Mỗi mục dữ liệu chỉ là một đối tượng khẳng định
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        // Tạo chế độ xem mới
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }
    //Trả về kích thước của bộ dữ liệu của bạn (được gọi bởi Trình quản lý bố cục)
    override fun getItemCount(): Int {
        return dataset.size
    }
    /** * Thay thế nội dung của chế độ xem (được gọi bởi trình quản lý bố cục) */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }
}