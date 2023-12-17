package com.example.lab8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup
            container, Bundle saveInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    public void setSelectedItem(String selectedItem) {
        TextView desc = getView().findViewById(R.id.detailsText);
        ImageView photo = getView().findViewById(R.id.photo);
        if (selectedItem == "BMW") {
            desc.setText(R.string.bmw);
            photo.setImageResource(R.drawable.bmw);
        }
        if (selectedItem == "Mercedes-Benz") {
            desc.setText(R.string.mercedes_benz);
            photo.setImageResource(R.drawable.mercedes_benz);
        }
        if (selectedItem == "KIA") {
            desc.setText(R.string.kia);
            photo.setImageResource(R.drawable.kia);
        }
        if (selectedItem == "Hyundai") {
            desc.setText(R.string.hyundai);
            photo.setImageResource(R.drawable.hyundai);
        }
        if (selectedItem == "Lada") {
            desc.setText(R.string.lada);
            photo.setImageResource(R.drawable.lada);
        }
        if (selectedItem == "Land Rover") {
            desc.setText(R.string.land_rover);
            photo.setImageResource(R.drawable.land_rover);
        }
    }
}
