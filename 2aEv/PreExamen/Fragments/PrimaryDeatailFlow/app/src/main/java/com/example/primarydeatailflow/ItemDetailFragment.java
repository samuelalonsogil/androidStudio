package com.example.primarydeatailflow;

import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.example.primarydeatailflow.placeholder.PlaceholderContent;
import com.example.primarydeatailflow.databinding.FragmentItemDetailBinding;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListFragment}
 * in two-pane mode (on larger screen devices) or self-contained
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The placeholder content this fragment is presenting.
     */
    private PlaceholderContent.PlaceholderItem mItem;
    private CollapsingToolbarLayout mToolbarLayout;
    private TextView mTextView;

    private FragmentItemDetailBinding binding;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the placeholder content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = PlaceholderContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate( R.layout.item_list_content, container, false );
        if (mItem!=null) {

            switch (mItem.fruitName){

                case "apple": ( (ImageView) rootView.findViewById(R.id.item_detail_image) ).setImageResource(R.drawable.apple);
                break;
                case "pera": ( (ImageView) rootView.findViewById(R.id.item_detail_image) ).setImageResource(R.drawable.pera);
                break;
                case "coco": ( (ImageView) rootView.findViewById(R.id.item_detail_image) ).setImageResource(R.drawable.coco);
                break;
                case "platano": ( (ImageView) rootView.findViewById(R.id.item_detail_image) ).setImageResource(R.drawable.platano);
                break;
            }

        }

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}