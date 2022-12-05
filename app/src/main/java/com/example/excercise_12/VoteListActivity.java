package com.example.excercise_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

import com.example.excercise_12.databinding.ActivityVoteListBinding;

public class VoteListActivity extends AppCompatActivity {
    private ActivityVoteListBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVoteListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        String candidate = intent.getStringExtra("candidate");

        binding.nameTV.setText(candidate);
        VoteAdapter adapter = new VoteAdapter(this, R.layout.row_candidate_layout,getVoteObject(candidate));
        binding.list.setAdapter(adapter);
    }

    private ArrayList<Vote> getVoteObject(String candidate){
        ArrayList<Vote> result = new ArrayList<>();
        for (Vote vote : Vote.voteList) {
            if (vote.getCandidate().equalsIgnoreCase(candidate)) {
                result.add(vote);
            }
        }
        return result ;
    }
}