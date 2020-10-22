package com.example.myaidl.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myaidl.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e(TAG, "PlaceholderFragment setUserVisibleHint: " +isVisibleToUser );
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e(TAG, "PlaceholderFragment onAttach: " );
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);

        Log.e(TAG, "PlaceholderFragment onCreate: " );
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        Log.e(TAG, "PlaceholderFragment onCreateView: " );
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "PlaceholderFragment onViewCreated: " );
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "PlaceholderFragment onActivityCreated: >>>>>>>" );
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "PlaceholderFragment onStart: >>>>>>>" );
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "PlaceholderFragment onResume: >>>>>>>" );
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "PlaceholderFragment onPause: >>>>>>>" );
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "PlaceholderFragment onStop: >>>>>>>" );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "PlaceholderFragment onResume: >>>>>>>" );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "PlaceholderFragment onDestroy: >>>>>>>" );
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "PlaceholderFragment onDetach: >>>>>>>" );
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "PlaceholderFragment onSaveInstanceState: >>>>>>>" );
    }
}
