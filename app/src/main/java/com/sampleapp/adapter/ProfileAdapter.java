package com.sampleapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sampleapp.R;
import com.sampleapp.model.ProfileModel;
import com.sampleapp.view.ProfileDetailActivity;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder> {
    private Context context;
    ArrayList<ProfileModel> profiles;
    private  ItemClickListner itemClickListner;


    public ProfileAdapter(Context context, ArrayList<ProfileModel> profiles,ItemClickListner itemClickListner) {
        this.context = context;
        this.profiles = profiles;
        this.itemClickListner = itemClickListner;

    }


    @NonNull
    @Override
    public ProfileAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recyclverview_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapter.MyViewHolder holder, int position) {

        holder.textViewName.setText(this.profiles.get(position).getName());
        holder.textViewId.setText(this.profiles.get(position).getEmpcode());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListner.onProfileClick(profiles.get(position));

                Intent intent = new Intent(context, ProfileDetailActivity.class);
                intent.putExtra("name",""+profiles.get(position).getName());
                intent.putExtra("contact",""+profiles.get(position).getContact());
                intent.putExtra("desc",""+profiles.get(position).getDescription());
                intent.putExtra("address",""+profiles.get(position).getAddress());
                context.startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {

        if (this.profiles != null)
            return this.profiles.size();
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewId;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewId = itemView.findViewById(R.id.textViewEmpCode);

        }
    }

    public interface ItemClickListner{
        public void onProfileClick(ProfileModel profileModel);
    }
}
