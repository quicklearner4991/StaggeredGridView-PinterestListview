package staggerdview.example.com.staggerdrecyclerview;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class StaggeredViewActivity extends AppCompatActivity {
   private ArrayList<Integer> imagesList = new ArrayList<>(Arrays.asList(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_view);
        // get the reference of RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
// set a StaggeredGridLayoutManager with 2 number of columns and vertical orientation
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        StaggerdAdapter staggerdAdapter = new StaggerdAdapter();
        recyclerView.setAdapter(staggerdAdapter);
    }

    public class StaggerdAdapter extends RecyclerView.Adapter<StaggerdAdapter.ViewHolder> {

        public StaggerdAdapter() {
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView image;

            public ViewHolder(View v) {
                super(v);
                image = v.findViewById(R.id.image);
            }
        }

        @Override
        public StaggerdAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // Create a new View
            View v = LayoutInflater.from(StaggeredViewActivity.this).inflate(R.layout.rowlayout, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.image.setImageResource(imagesList.get(position));
        }

        @Override
        public int getItemCount() {
            return imagesList.size();
        }
    }
}
