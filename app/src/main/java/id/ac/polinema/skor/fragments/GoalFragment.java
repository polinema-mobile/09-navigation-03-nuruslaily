package id.ac.polinema.skor.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import id.ac.polinema.skor.R;
import id.ac.polinema.skor.databinding.FragmentGoalBinding;
import id.ac.polinema.skor.models.GoalScorer;

public class GoalFragment extends Fragment {

	private String requestKey;
	private GoalScorer goalScorer;


	public GoalFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.goalScorer = new GoalScorer();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		FragmentGoalBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_goal, container, false);
		View view = binding.getRoot();
		final GoalScorer goalScorer = requireArguments().getParcelable("GoalScorer");

		binding.buttonSave.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onSaveClicked(view);
			}
		});
		binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onCancelClicked(view);
			}
		});
		return view;

	}

	public void onSaveClicked(View view) {
		Bundle bundle = new Bundle();
		bundle.putParcelable("GoalScorer", goalScorer);

		Navigation.findNavController(view).navigate(R.id.goal_scorer_action, bundle);
	}

	public void onCancelClicked(View view) {
		Bundle bundle = new Bundle();
		bundle.putParcelable("GoalScorer", goalScorer);
		Navigation.findNavController(view).navigate(R.id.goal_scorer_action, bundle);
	}
}