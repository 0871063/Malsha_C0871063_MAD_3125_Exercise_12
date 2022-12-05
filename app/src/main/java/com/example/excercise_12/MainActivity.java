package com.example.excercise_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.excercise_12.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.voteBtn.setOnClickListener( v -> {
            voteCandidate();
        });
    }

    private void voteCandidate(){
        String name = binding.nameET.getText().toString().trim();
        String id = binding.idET.getText().toString().trim();
        String candidate = binding.candidateSpinner.getSelectedItem().toString();
        Boolean accept = binding.acceptBtn.isChecked();

        if(name.isEmpty()){
            binding.nameET.setError("Name field must be filled");
            return;
        }
        if(id.isEmpty()){
            binding.idET.setError("ID field must be filled");
            return;
        }
        if(candidate.equalsIgnoreCase("Choose Candidate")){
            Toast.makeText(getApplicationContext(),"Please choose the Candidate",Toast.LENGTH_SHORT).show();
            return;
        }

        if(!accept){
            Toast.makeText(getApplicationContext(),"Please accept to continue",Toast.LENGTH_SHORT).show();
            return;
        }
        if(alreadyVoted(id,candidate)){
            Toast.makeText(getApplicationContext(),"Already voted for the candidate",Toast.LENGTH_SHORT).show();
            return;
        }
        Vote vote = new Vote(name,id,candidate);
        Vote.voteList.add(vote);
        startActivity(new Intent(this, CandidateListActivity.class));
    }

    private boolean alreadyVoted(String id, String candidate){

        for (Vote vote : Vote.voteList) {
            if (vote.getCandidate().equalsIgnoreCase(candidate) && vote.getVoterId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        clearFields();
    }

    private void clearFields(){
        binding.nameET.setText("");
        binding.idET.setText("");
        binding.acceptBtn.setChecked(false);
        binding.candidateSpinner.setSelection(0);
    }
}