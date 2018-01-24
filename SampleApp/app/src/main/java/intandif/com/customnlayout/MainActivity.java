package intandif.com.customnlayout;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import intandif.icontags.IconTags;
import intandif.icontags.TagItem;
import intandif.icontags.TagsClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<TagItem> items = new ArrayList<>();
        items.add(new TagItem("https://d30y9cdsu7xlg0.cloudfront.net/png/25961-200.png", "Apple"));
        items.add(new TagItem(R.drawable.almandinegarnet, "Programming"));
        items.add(new TagItem(R.drawable.angelite, "Java"));
        items.add(new TagItem(R.drawable.anhydrite, "Opp"));
        items.add(new TagItem(R.drawable.apatite_blue_, "I Love Programming"));
        items.add(new TagItem("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/C_plus_plus.svg/2000px-C_plus_plus.svg.png", "C++"));
        items.add(new TagItem(R.drawable.amazonite, "iOS Development"));
        items.add(new TagItem(R.drawable.apophyllite_green_, "Android"));


        RelativeLayout parentView = (RelativeLayout) findViewById(R.id.parent);
        IconTags.getInstance().init(this, parentView).withBackground(R.drawable.my_bg).withCustomText(Color.parseColor("#000000"), 14)

                .drawTags(items, new TagsClickListener() {
            @Override
            public void onTagClick(int pos, TagItem item) {
                Toast.makeText(MainActivity.this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTagLongClick(int pos, TagItem item) {
                Toast.makeText(MainActivity.this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}
