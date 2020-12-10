package com.example.playing_with_dialogs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.zip.Inflater;

public class Dialog1 extends DialogFragment {

    Button yes, no;
    communicator comm;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        comm= (communicator) context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.dialog_1,null);

        yes=view.findViewById(R.id.yes);
        no=view.findViewById(R.id.no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"YES button cliked",Toast.LENGTH_SHORT);
                comm.communicate("YES dabaya tha..!!");
                dismiss();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"NO button cliked",Toast.LENGTH_SHORT);
                comm.communicate("NO dabaya tha..!!");
                dismiss();
            }
        });

        return view;

    }

}

interface communicator{
    public void communicate(String string);
}


