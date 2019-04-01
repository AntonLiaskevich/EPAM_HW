package com.example.user.epam_hw;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.user.epam_hw.backend.entities.Student;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder> {

    private OnItemDismissListener itemDismissListener;
    private OnItemEditListener itemEditListener;
    private final LayoutInflater inflater;
    private final List<Student> students = new ArrayList<>();

    StudentsAdapter(final Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemDismissListener = (OnItemDismissListener) context;
        itemEditListener = (OnItemEditListener) context;
    }

    void addItems(final Collection<Student> items) {
        students.addAll(items);
        notifyDataSetChanged();
    }

    void updateItems(final Collection<Student> items) {
        students.clear();
        students.addAll(items);
        notifyDataSetChanged();
    }

    private void deleteByIndex(final int index) {
        students.remove(index);
        notifyItemRemoved(index);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.students_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(students.get(position));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    void onItemDismiss(int adapterPosition) {
        deleteByIndex(adapterPosition);
        itemDismissListener.itemDismissed(adapterPosition);
    }

    void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(students, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(students, i, i - 1);
            }
        }

        notifyItemMoved(fromPosition, toPosition);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView studentImageView;
        private TextView nameTextView;
        private TextView hwCountTextView;

        private long id;

        ViewHolder(View view) {
            super(view);

            studentImageView = view.findViewById(R.id.student_image_view);
            nameTextView = view.findViewById(R.id.name_text_view);
            hwCountTextView = view.findViewById(R.id.hw_count_text_view);

            view.findViewById(R.id.edit_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemEditListener.ItemEditClick(id);
                }
            });
        }

        void bind(Student student) {
            id = student.getId();
            nameTextView.setText(student.getName());
            hwCountTextView.setText(Integer.toString(student.getHomeworkCount()));
        }
    }

    public interface OnItemDismissListener {
        void itemDismissed(long id);
    }

    public interface OnItemEditListener {
        void ItemEditClick(long id);
    }
}