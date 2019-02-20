package com.gargpiyush.android.litepaint.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gargpiyush.android.litepaint.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Piyush Garg on 2/20/2019.
 */

public class HelpFragment extends Fragment {

    @BindView(R.id.helpFragmentBackButton)
    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.help_fragment,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.helpFragmentBackButton)
    public void goBack(){
        getActivity().getSupportFragmentManager().popBackStack();
    }
}
