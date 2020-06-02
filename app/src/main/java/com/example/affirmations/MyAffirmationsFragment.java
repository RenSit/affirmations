package com.example.affirmations;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyAffirmationsFragment extends Fragment {

    private String[] affirmations = new String[]{
            "Я разрешаю себе быть счастливым.",
            "Я разрешаю себе быть уверенным.",
            "Я действую в своём круге влияния, постепенно расширяя его.",
            "Я развиваю внутреннее лидерство, способность ставить себе цели, видеть общую картину, объединять свои творческое и логическое полушария для достижения синергии.",
            "Я обладаю характером, который помогает мне принимать верные решения, основанные на моих принципах. В любой ситуации мой характер позволяет мне оставаться спокойным и уравновешенным.",
            "Я обладаю силой делать и говорить то, что нужно делать и говорить.",
            "Успех приходит к тем, кто после каждой неудачи пробует ещё раз.",
            "Моя цель состоит в том, чтобы жить в согласии с моей совестью.",
            "Мотивация приходит, когда я действую.",
            "Я обладаю крепким здоровьем, сильным иммунитетом, я быстрой регенерацией.",
            "Я люблю свою жену, родственнеков, друзей, помогаю им, уделаю им время.",
            "Я понимаю свою жену, принимаю её точку зрения, её чувства, дарю ей счастье, поддержку, заботу.",
            "Я зарабатываю большие деньги для содержания своей семьи, помощи родным, близким и для путешествий по миру.",
            "В мире всего достаточно для всех, в мире много знаний, денег, любви, счатья, здоровья, возможностей, я вижу это изобилие и могу использовать его для своего блага и блага моей семьи.",
            "Я живу, основываясь на вышеизложенных принципах, они помогают мне принимать решения, поддерживают мою внутреннюю уверенность и даюи мне силы действовать."};

    public MyAffirmationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_affirmations, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new RecyclerViewAdapter(affirmations));
        return view;
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
        String[] mAffirmationsArray;

        class MyViewHolder extends RecyclerView.ViewHolder{

            TextView textView;
           // ImageView imageView;

            MyViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.affirmationTextView);
               /* imageView = itemView.findViewById(R.id.hideaffirmationImageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    }
                });*/
            }
        }

        RecyclerViewAdapter(String[] affirmations) {
            this.mAffirmationsArray = affirmations;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view =  LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.affirmation_list_view, parent, false);
            MyViewHolder vh = new MyViewHolder(view);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.textView.setText(mAffirmationsArray[position]);
        }

        @Override
        public int getItemCount() {
            return mAffirmationsArray.length;
        }
    }
}
