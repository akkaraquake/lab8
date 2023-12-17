package com.example.lab8;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {
    interface OnFragmentSendDataListener {
        void onSendData(String data);
    }
    private OnFragmentSendDataListener fragmentSendDataListener;
    String[] cars = {"BMW",
            "Mercedes-Benz",
            "KIA",
            "Hyundai",
            "Lada",
            "Land Rover"};

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " должен реализовывать интерфейс " +
                    "OnFragmentInteractionListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        // получаем элемент ListView
        ListView carList = view.findViewById(R.id.list);
        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, cars);
        // устанавливаем для списка адаптер
        carList.setAdapter(adapter);
        // добавляем для списка слушатель
        carList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // получаем выбранный элемент
                String selectedItem = (String) parent.getItemAtPosition(position);
                // Посылаем данные Activity
                fragmentSendDataListener.onSendData(selectedItem);
            }
        });
        return view;
    }
}
