package com.example.hello.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hello.R;
import com.example.hello.model.Student;

import java.util.List;

public class ListStudentAdapter extends BaseAdapter {
    private  List<Student> listStudent;
    private  Context context;
    private  int layout;

    public ListStudentAdapter(Context context , int layout ,List<Student> listStudent ) {
        this.listStudent = listStudent;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return listStudent.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private  class ViewHolder{
        private  TextView txtName,txtAge,txtGender;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            viewHolder = new ViewHolder();
            viewHolder.txtName=convertView.findViewById(R.id.txtName);
            viewHolder.txtAge=convertView.findViewById(R.id.txtAge);
            viewHolder.txtGender=convertView.findViewById(R.id.txtGender);
            convertView.setTag(viewHolder);
        }
        else viewHolder =(ViewHolder) convertView.getTag();

        viewHolder.txtName.setText(listStudent.get(position).getName());
        viewHolder.txtAge.setText(listStudent.get(position).getAge() );
        viewHolder.txtGender.setText(listStudent.get(position).getGender());
        return convertView;
    }
}
