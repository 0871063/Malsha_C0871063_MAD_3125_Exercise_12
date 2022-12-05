package com.example.excercise_12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.excercise_12.databinding.RowCandidateLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class VoteAdapter extends ArrayAdapter<Vote> {

    private Context context;
    int resLayout;
    List<Vote> voteList;

    public VoteAdapter(@NonNull Context context, int resource, @NonNull List<Vote> voteList) {
        super(context, resource, voteList);
        this.context = context;
        this.resLayout = resource;
       this.voteList = voteList;
    }


//    public VoteAdapter(@NonNull Context context, int resource) {
//        super(context, resource);
//        this.context = context;
//        this.resLayout = resource;
//    }

    @Override
    public int getCount() {
        return voteList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        RowCandidateLayoutBinding binding = RowCandidateLayoutBinding.inflate(LayoutInflater.from(context));

        Vote vote = voteList.get(position);
        if (vote != null) {
            binding.nameTV.setText(vote.getVoterName());
            binding.idTV.setText(vote.getVoterId());
        }
        return binding.getRoot();

    }
}
