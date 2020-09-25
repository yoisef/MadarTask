package com.example.madarsofttask.ShowModule.Adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madarsofttask.R;
import com.example.madarsofttask.RoomDatabase.UserModel;
import com.example.madarsofttask.Utils.GenderEnum;

import java.util.List;




public class UserAdapter extends RecyclerView.Adapter<UserAdapter.viewholder> {

    Context context;
    List<UserModel> Users;

    public UserAdapter(Context context, List<UserModel> Users)
    {
        this.context=context;
        this.Users=Users;

    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_user,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewholder holder, int position) {

        holder.name.setText(Users.get(position).getUserName());
        holder.job.setText(Users.get(position).getUserJobTitle());
        holder.age.setText(Users.get(position).getUserAge());

        if (Users.get(position).getUseGender()== GenderEnum.MALE.getIntValue())
        {
            holder.gender.setText(GenderEnum.MALE.toString());
        }else
        {
            holder.gender.setText(GenderEnum.FEMALE.toString());

        }


    }

    @Override
    public int getItemCount() {
        return Users.size();
    }





    class viewholder extends RecyclerView.ViewHolder{

     TextView name ,age ,job, gender;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            name= itemView.findViewById(R.id.row_name);
            age=  itemView.findViewById(R.id.row_age);
            job= itemView.findViewById(R.id.row_job);
            gender= itemView.findViewById(R.id.row_gender);



        }
    }
}
