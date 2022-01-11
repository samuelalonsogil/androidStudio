package com.example.recyclerview01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private final Context context;

    //always initialize
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view01 = LayoutInflater.from(parent.getContext() ).inflate(R.layout.contacts_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view01);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textviewName.setText(contacts.get(position).getName() );
        holder.textviewEmail.setText(contacts.get(position).getEmail() );

        //onClickListener
        holder.parentCard.setOnClickListener(v -> Toast.makeText(context, contacts.get(position).getName() + " Selected", Toast.LENGTH_SHORT).show());

        Glide.with(context).asBitmap().load(contacts.get(position).getImageUrl()).into(holder.image01 );
    }

    //number of items in the recycler
    @Override
    public int getItemCount() {
        return contacts.size();
    }

    //arraylist is private so we have to create a setter
    @SuppressLint("NotifyDataSetChanged")
    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;

        //refresh the data in the recyclerView
        notifyDataSetChanged();
    }

    //holds the view of every item of the recycler view
    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView textviewName;
        private final TextView textviewEmail;
        private ImageView image01;

        private final CardView parentCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textviewName = itemView.findViewById(R.id.textView01);
            textviewEmail = itemView.findViewById(R.id.textView02);
            image01 = itemView.findViewById(R.id.image01);

            parentCard = itemView.findViewById(R.id.parentCardView);
        }
    }

}
