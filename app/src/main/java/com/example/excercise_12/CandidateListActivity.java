package com.example.excercise_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.excercise_12.databinding.ActivityCandidateListBinding;

public class CandidateListActivity extends AppCompatActivity {

    private ActivityCandidateListBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCandidateListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        String[] stringArray =getResources().getStringArray(R.array.candidates);
        List<String> candidateArray = new ArrayList<String>(Arrays.asList(stringArray));
        candidateArray.remove(0);

        binding.candidateOneTV.setText(getVoteObject(candidateArray.get(0)));
        binding.candidateTwoTV.setText(getVoteObject(candidateArray.get(1)));
        binding.candidateThreeTV.setText(getVoteObject(candidateArray.get(2)));
        binding.candidateFourTV.setText(getVoteObject(candidateArray.get(3)));
        binding.candidateFiveTV.setText(getVoteObject(candidateArray.get(4)));
        binding.candidateSixTV.setText(getVoteObject(candidateArray.get(5)));
        binding.candidateSevenTV.setText(getVoteObject(candidateArray.get(6)));
        binding.candidateEightTV.setText(getVoteObject(candidateArray.get(7)));
        binding.candidateNineTV.setText(getVoteObject(candidateArray.get(8)));
        binding.candidateTenTV.setText(getVoteObject(candidateArray.get(9)));

        binding.candidateOneTV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String candidate = candidateArray.get(0);
                loadVoteData(candidate);
            }
        });

        binding.candidateTwoTV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String candidate = candidateArray.get(1);
                loadVoteData(candidate);
            }
        });
        binding.candidateThreeTV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String candidate = candidateArray.get(2);
                loadVoteData(candidate);
            }
        });

        binding.candidateFourTV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String candidate = candidateArray.get(3);
                loadVoteData(candidate);
            }
        });
        binding.candidateFiveTV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String candidate = candidateArray.get(4);
                loadVoteData(candidate);
            }
        });

        binding.candidateSixTV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String candidate = candidateArray.get(5);
                loadVoteData(candidate);
            }
        });
        binding.candidateSevenTV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String candidate = candidateArray.get(6);
                loadVoteData(candidate);
            }
        });

        binding.candidateEightTV.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String candidate = candidateArray.get(7);
                loadVoteData(candidate);
            }
        });
        binding.candidateNineTV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String candidate = candidateArray.get(8);
                loadVoteData(candidate);
            }
        });

        binding.candidateTenTV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String candidate = candidateArray.get(9);
                loadVoteData(candidate);
            }
        });
    }

    private String getVoteObject(String candidate){
        ArrayList<Vote> result = new ArrayList<>();
        for (Vote vote : Vote.voteList) {
            if (vote.getCandidate().equalsIgnoreCase(candidate)) {
                result.add(vote);
            }
        }
        return "Candidate Name : " + candidate + '\n' +
                " Vote Count : " + result.size() ;
    }

    private void loadVoteData(String candidate){
        Intent intent = new Intent(getApplicationContext(), VoteListActivity.class);
        intent.putExtra("candidate", candidate);
        startActivity(intent);
    }
}