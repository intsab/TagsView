package intandif.icontags;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by intsab on 22/01/2018.
 */

public class IconTags {
    private static final IconTags newInstance = new IconTags();

    int _textSize;
    int _textColor;
    int _backgroundResource;
    RelativeLayout _parentLo;
    Context _context;
    public static IconTags getInstance() {
        return newInstance;
    }

    private IconTags() {
       _textColor= Color.BLUE;
       _textSize= 14;
        _backgroundResource= R.drawable.round_corner;
    }

    public IconTags init(Context context, RelativeLayout parentLayout){
        _context= context;
        _parentLo= parentLayout;
        return newInstance;
    }
    public IconTags withCustomText(int textColor, int textSize){
        _textColor= textColor;
        _textSize= textSize;
        return newInstance;
    }
    public IconTags withBackground(int bg){
        _backgroundResource= bg;
        return newInstance;
    }
    public void drawTags(ArrayList<TagItem> items) {
        drawTags(items, null);
    }
    public void drawTags(final ArrayList<TagItem> items, final TagsClickListener listener) {
        int breakIndex = 0;
        ArrayList<LinearLayout> layouts = new ArrayList<>();
        LayoutInflater inflater;
        inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity)_context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;



        for ( int x = 0; x < items.size(); x++) {
            LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.tag_layout, null);
            layout.setId(x+1);
            TextView ttl= (TextView)layout.findViewById(R.id.title) ;
            ImageView icn= (ImageView) layout.findViewById(R.id.icon) ;
            LinearLayout main= (LinearLayout) layout.findViewById(R.id.main) ;
            ttl.setTextColor(_textColor);
            ttl.setTextSize(_textSize);
            ttl.setText(items.get(x)._title);
            if (items.get(x)._iconUrl!=null && !(items.get(x)._iconUrl.equals(""))){
                Picasso.with(_context).load(items.get(x)._iconUrl).into(icn);
            }else{
                icn.setImageResource(items.get(x)._resource);
            }

            main.setBackgroundResource(_backgroundResource);
            main.setTag(""+x);
            main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(listener!=null)
                    listener.onTagLongClick(Integer.parseInt(v.getTag().toString()), items.get(Integer.parseInt(v.getTag().toString())));
                }
            });
            main.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if(listener!=null)
                        listener.onTagLongClick(Integer.parseInt(v.getTag().toString()), items.get(Integer.parseInt(v.getTag().toString())));
                    return false;
                }
            });
            layouts.add(layout);
        }

        for (int x = 0; x < items.size(); x++) {

            RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

            if (x == 0) {
                int id= layouts.get(x).getId();
                relativeParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                relativeParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                _parentLo.addView(layouts.get(x), relativeParams);

            } else {
                layouts.get(x).measure(0, 0);
                int myCurrentLayoutWidth = layouts.get(x).getMeasuredWidth();
                int totalWidth=0;
                for (int x1=breakIndex;x1<x;x1++){
                    layouts.get(x1).measure(0, 0);
                    totalWidth= totalWidth+layouts.get(x1).getMeasuredWidth() ;
                }
                if ((totalWidth+myCurrentLayoutWidth)>screenWidth){

                    relativeParams.addRule(RelativeLayout.BELOW, layouts.get(breakIndex).getId());
                    relativeParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                    breakIndex= x;

                }else{

                    relativeParams.addRule(RelativeLayout.RIGHT_OF, layouts.get(x - 1).getId());
                    if (breakIndex>0){
                        relativeParams.addRule(RelativeLayout.BELOW, layouts.get(breakIndex-1).getId());
                    }
                }

                _parentLo.addView(layouts.get(x), relativeParams);
            }
        }
    }
}
