package com.example.mydoctor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class doctrArrayAdapter extends ArrayAdapter<doctorCard> {

    public doctrArrayAdapter(@NonNull Context context, int resource, @NonNull List<doctorCard> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.doctorcard, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.image);
        TextView nameView = convertView.findViewById(R.id.name);
        TextView hospitalView = convertView.findViewById(R.id.hospital);
        TextView phoneView = convertView.findViewById(R.id.phone);
        TextView cityView = convertView.findViewById(R.id.city);
        TextView placeView = convertView.findViewById(R.id.place);


        doctorCard currentMovie = getItem(position);

        nameView.setText(currentMovie.getName());
        hospitalView.setText(currentMovie.getHospital());
        phoneView.setText(currentMovie.getPhone());
        cityView.setText(currentMovie.getCity());
        placeView.setText(currentMovie.getPlace());


        return convertView;
    }

}
