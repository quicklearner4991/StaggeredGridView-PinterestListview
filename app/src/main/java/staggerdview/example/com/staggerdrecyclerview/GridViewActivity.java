package staggerdview.example.com.staggerdrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class GridViewActivity extends AppCompatActivity {
    private ArrayList<Integer> imagesList = new ArrayList<>(Arrays.asList(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
// set a StaggeredGridLayoutManager with 3 number of columns and vertical orientation
        GridLayoutManager gridLayoutManager = new GridLayoutManager(GridViewActivity.this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        GridViewAdapter staggerdAdapter = new GridViewAdapter();
        recyclerView.setAdapter(staggerdAdapter);
        
    }
    public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder> {

        public GridViewAdapter() {
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView image;

            public ViewHolder(View v) {
                super(v);
                image = v.findViewById(R.id.image);
            }
        }

        @Override
        public GridViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // Create a new View
            View v = LayoutInflater.from(GridViewActivity.this).inflate(R.layout.gridview_item, parent, false);
            GridViewAdapter.ViewHolder vh = new GridViewAdapter.ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(GridViewAdapter.ViewHolder holder, int position) {
            holder.image.setImageResource(imagesList.get(position));
        }

        @Override
        public int getItemCount() {
            return imagesList.size();
        }
    }
}
