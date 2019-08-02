package com.example.heartattack;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.heartattack.fragment.QuestionFragment;

public class FragmentListener extends FragmentStatePagerAdapter {
    public FragmentListener(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        QuestionFragment questionFragment = new QuestionFragment();
        Bundle bundle = new Bundle();
        position = position+1;
        bundle.putInt("position", position);
        questionFragment.setArguments(bundle);
        return questionFragment;
    }

    @Override
    public int getCount() {
        return 15;
    }
}
