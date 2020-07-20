package com.example.rebootapps.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.example.rebootapps.BucketList;
import com.example.rebootapps.CardSlide;
import com.example.rebootapps.CardStackAdapter;
import com.example.rebootapps.CardStackCallback;
import com.example.rebootapps.ItemModel;
import com.example.rebootapps.R;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragCardSlider#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragCardSlider extends Fragment {
    private static final String TAG = "CardSlide";
    private CardStackLayoutManager manager;
    private CardStackAdapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragCardSlider() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragCardSlider.
     */
    // TODO: Rename and change types and number of parameters
    public static FragCardSlider newInstance(String param1, String param2) {
        FragCardSlider fragment = new FragCardSlider();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_frag_card_slider, container, false);

        TextView buttonFinish = v.findViewById(R.id.btnfinishCard);

        CardStackView cardStackView = v.findViewById(R.id.card_stack_view);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), BucketList.class);
//                startActivity(intent);
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.navigation_card_slider, new FragBucketList(), "Bucket List");
                ft.commit();
                ft.addToBackStack(null);
            }
        });
        manager = new CardStackLayoutManager(getActivity(), new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) {
                Log.d(TAG, "onCardDragging: d=" + direction.name() + " ratio=" + ratio);
            }

            @Override
            public void onCardSwiped(Direction direction) {
                Log.d(TAG, "onCardSwiped: p=" + manager.getTopPosition() + " d=" + direction);
                if (direction == Direction.Right){
//                    Toast.makeText(MainActivity.this, "Direction Right", Toast.LENGTH_SHORT).show();
                }
                if (direction == Direction.Top){
//                    Toast.makeText(MainActivity.this, "Direction Top", Toast.LENGTH_SHORT).show();
                }
                if (direction == Direction.Left){
//                    Toast.makeText(MainActivity.this, "Direction Left", Toast.LENGTH_SHORT).show();
                }
                if (direction == Direction.Bottom){
//                    Toast.makeText(MainActivity.this, "Direction Bottom", Toast.LENGTH_SHORT).show();
                }

                // Paginating
                if (manager.getTopPosition() == adapter.getItemCount() - 5){
                    paginate();
                }

            }

            @Override
            public void onCardRewound() {
                Log.d(TAG, "onCardRewound: " + manager.getTopPosition());
            }

            @Override
            public void onCardCanceled() {
                Log.d(TAG, "onCardRewound: " + manager.getTopPosition());
            }

            @Override
            public void onCardAppeared(View view, int position) {
                TextView tv = view.findViewById(R.id.title_card_slide);
                Log.d(TAG, "onCardAppeared: " + position + ", nama: " + tv.getText());
            }

            @Override
            public void onCardDisappeared(View view, int position) {
                TextView tv = view.findViewById(R.id.title_card_slide);
                Log.d(TAG, "onCardAppeared: " + position + ", nama: " + tv.getText());
            }
        });
        manager.setStackFrom(StackFrom.None);
        manager.setVisibleCount(5);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.FREEDOM);
        manager.setCanScrollHorizontal(true);
        manager.setSwipeableMethod(SwipeableMethod.Manual);
        manager.setOverlayInterpolator(new LinearInterpolator());

        adapter = new CardStackAdapter(addList());
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);
        cardStackView.setItemAnimator(new DefaultItemAnimator());
        // Inflate the layout for this fragment
        return v;
    }

    private void paginate() {
        List<ItemModel> old = adapter.getItems();
        List<ItemModel> baru = new ArrayList<>(addList());
        CardStackCallback callback = new CardStackCallback(old, baru);
        DiffUtil.DiffResult hasil = DiffUtil.calculateDiff(callback);
        adapter.setItems(baru);
        hasil.dispatchUpdatesTo(adapter);
    }

    private List<ItemModel> addList() {
        List<ItemModel> items = new ArrayList<>();
        items.add(new ItemModel(R.drawable.card_calm_music, "Listen to calm music for a relaxing morning" ));
        items.add(new ItemModel(R.drawable.card_exercise, "Exercise from home with Lululemon"));
        items.add(new ItemModel(R.drawable.card_carbonara, "Try 5-step Spaghetti Carbonara for din din"));
        items.add(new ItemModel(R.drawable.card_lunch, "Menu for lunch? Try some recipes here "));
        items.add(new ItemModel(R.drawable.card_calm_music, "Listen to calm music for a relaxing morning" ));
        items.add(new ItemModel(R.drawable.card_exercise, "Exercise from home with Lululemon"));
        items.add(new ItemModel(R.drawable.card_carbonara, "Try 5-step Spaghetti Carbonara for din din"));
        items.add(new ItemModel(R.drawable.card_lunch, "Menu for lunch? Try some recipes here "));
        items.add(new ItemModel(R.drawable.card_calm_music, "Listen to calm music for a relaxing morning" ));
        items.add(new ItemModel(R.drawable.card_exercise, "Exercise from home with Lululemon"));
        items.add(new ItemModel(R.drawable.card_carbonara, "Try 5-step Spaghetti Carbonara for din din"));
        items.add(new ItemModel(R.drawable.card_lunch, "Menu for lunch? Try some recipes here "));
        return items;
    }
}