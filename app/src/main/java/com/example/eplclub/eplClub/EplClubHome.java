package com.example.eplclub.eplClub;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.eplclub.R;
import com.example.eplclub.databinding.FragmentEplClubHomeBinding;
import com.example.eplclub.model.EplClubModel;
import com.example.eplclub.model.Players;

import java.util.ArrayList;
import java.util.List;


public class EplClubHome extends Fragment {

    private FragmentEplClubHomeBinding binding;
    private EplClubHomeViewModel viewModel;


    public EplClubHome() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        List<EplClubModel> eplClubList = new ArrayList<>();



//        Manchester United
        List<Players> mu = new ArrayList<>();
        mu.add(new Players("David de Gea", "GoalKeeper", "1"));
        mu.add(new Players("Dean Henderson", "GoalKeeper", "26"));
        mu.add(new Players("Luke Shaw", "Defender", "23"));
        mu.add(new Players("Alex Telles", "Defender", "27"));
        mu.add(new Players("Teden Mengi", "Defender", "43"));
        mu.add(new Players("Paul Pogba", "MidFielder", "6"));
        mu.add(new Players("Juan Mata", "Midfielder", "8"));
        mu.add(new Players("Jesse Lingard", "Midfielder", "14"));
        mu.add(new Players("Marcus RashFord", "Forward", "10"));
        mu.add(new Players("Anthony Martial", "Forward", "9"));
        mu.add(new Players("Edison Cavani", "Forward", "7"));
        eplClubList.add(new EplClubModel("Manchester United", mu, R.drawable.manchester_united));

//        Arsenal
        List<Players> ars = new ArrayList<>();
        ars.add(new Players("Bernd Leno", "GoalKeeper", "1"));
        ars.add(new Players("Matt Macey", "GoalKeeper", "33"));
        ars.add(new Players("Hector Bellerin", "Defender", "2"));
        ars.add(new Players("David Luiz", "Defender", "23"));
        ars.add(new Players("Rob Holding", "Defender", "16"));
        ars.add(new Players("Mezut Ozil", "Midfielder", "10"));
        ars.add(new Players("Granit Xhaka", "Midfielder", "34"));
        ars.add(new Players("Bukayo Saka", "Midfielder", "7"));
        ars.add(new Players("Pierre-Emerick Aubameyang", "Forward", "14"));
        ars.add(new Players("Alexandre Lacazette", "Forward", "9"));
        ars.add(new Players("Dani Ceballos", "Forward", "8"));
        eplClubList.add(new EplClubModel("Arsenal", ars, R.drawable.arsenal));

//      Chelsea
        List<Players> chls = new ArrayList<>();
         chls.add(new Players("Edouard Mendy", "GoalKeeper", "16"));
         chls.add(new Players("Willy Caballero", "GoalKeeper", "13"));
         chls.add(new Players("Kurt Zouma", "Defender", "15"));
         chls.add(new Players("Reece James", "Defender", "24"));
        chls.add(new Players("Thiago Silva", "Defender", "6"));
        chls.add(new Players("Mason Mount", "Midfielder", "19"));
        chls.add(new Players("N'Golo Kante", "Midfielder", "7"));
        chls.add(new Players("Mateo Kovacic", "Midfielder", "17"));
        chls.add(new Players("Timo Werner", "Forward", "11"));
        chls.add(new Players("Tammy Abraham", "Forward", "9"));
        chls.add(new Players("Oliver Giroud", "Forward", "18"));
        eplClubList.add(new EplClubModel("Chelsea", chls, R.drawable.chelsea));

//       Liverpool
        List<Players> liverpool = new ArrayList<>();
        liverpool.add(new Players("Alisson", "GoalKeeper", "1"));
        liverpool.add(new Players("Adrian", "GoalKeeper", "13"));
        liverpool.add(new Players("Virgil Van Dijk", "Defender", "4"));
        liverpool.add(new Players("Andrew Robertson", "Defender", "26"));
        liverpool.add(new Players("Trent Alexander-Arnold", "Defender", "66"));
        liverpool.add(new Players("Georginio Wijnaldum", "Midfielder", "5"));
        liverpool.add(new Players("Jordan Henderson", "Midfielder", "14"));
        liverpool.add(new Players("Naby Keita", "Midfielder", "8"));
        liverpool.add(new Players("Roberto Firmino", "Forward", "9"));
        liverpool.add(new Players("Sadio Mane", "Forward", "10"));
        liverpool.add(new Players("Mohammed Salah", "Forward", "11"));
        eplClubList.add(new EplClubModel("Liverpool", liverpool, R.drawable.liverpool));


//      Man City
        List<Players> mancity = new ArrayList<>();
        mancity.add(new Players("Ederson", "GoalKeeper", "31"));
        mancity.add(new Players("James Trafford", "GoalKeeper", "85"));
        mancity.add(new Players("Kyle Walker", "Defender", "2"));
        mancity.add(new Players("Nathan Ake", "Defender", "6"));
        mancity.add(new Players("Ruben Dias", "Defender", "3"));
        mancity.add(new Players("Kevin De Bryune", "Midfielder", "17"));
        mancity.add(new Players("Phil Foden", "Midfielder", "47"));
        mancity.add(new Players("Rodrigo", "Midfielder", "16"));
        mancity.add(new Players("Raheem Sterling", "Forward", "7"));
        mancity.add(new Players("Riyad Mahrez", "Forward", "26"));
        mancity.add(new Players("Sergio Aguero", "Forward", "10"));
        eplClubList.add(new EplClubModel("Manchester City", mancity, R.drawable.mancity1));


//

//

        EplClubHomeViewModelFactory eplClubHomeViewModelFactory = new EplClubHomeViewModelFactory(eplClubList);
        viewModel = new ViewModelProvider(this,eplClubHomeViewModelFactory).get(EplClubHomeViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_epl_club_home, container,false);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupClub();
    }

    public void setupClub(){
        RecyclerView recyclerView = binding.reyclerView;
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        ClubAdapter adapter = new ClubAdapter(new OnItemClubListener() {
            @Override
            public void onImageClicked(EplClubModel eplClubModel) {
                viewModel.onImageClicked(eplClubModel);
            }
        });
        recyclerView.setAdapter(adapter);
        viewModel.listLiveData().observe(getViewLifecycleOwner(), new Observer<List<EplClubModel>>() {
            @Override
            public void onChanged(List<EplClubModel> eplClubModels) {
                adapter.setEplClubModels(eplClubModels);
            }
        });


        viewModel.Navigatedetail().observe(getViewLifecycleOwner(), new Observer<EplClubModel>() {
            @Override
            public void onChanged(EplClubModel eplClubModel) {
                if(eplClubModel!=null){
                    NavDirections action = EplClubHomeDirections.actionEplClubHomeToDetails(eplClubModel);
                    Navigation.findNavController(requireView()).navigate(action);
                    viewModel.detailNavigated();
                }
            }
        });

    }
}