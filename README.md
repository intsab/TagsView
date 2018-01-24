# TagsView
TagView is the library that create view as Tags on website with icon.

# Properties:
1- You can set icon with url or with resource. <br>
2- You can change text color, text size of Tag. <br>
3- You can change Background resource of Tag. <br>
4- Can get Click and Long Clicks with Item and position. <br>

# Sample Code
Add Item as following
```java
 ArrayList<TagItem> items = new ArrayList<>();
        items.add(new TagItem("https://d30y9cdsu7xlg0.cloudfront.net/png/25961-200.png", "Apple"));
        items.add(new TagItem(R.drawable.almandinegarnet, "Programming"));
        items.add(new TagItem(R.drawable.angelite, "Java"));
        items.add(new TagItem(R.drawable.anhydrite, "Opp"));
        items.add(new TagItem(R.drawable.apatite_blue_, "I Love Programming"));
        items.add(new TagItem("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/C_plus_plus.svg/2000px-C_plus_plus.svg.png", "C++"));
        items.add(new TagItem(R.drawable.amazonite, "iOS Development"));
        items.add(new TagItem(R.drawable.apophyllite_green_, "Android"));
```
And Now Simply use Tagview as following..

```java
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
 ```

Methods .withBackground(R.drawable.my_bg).withCustomText(Color.parseColor("#000000"), 14) are OPTIONAL AND also you can call drawTags(items) with items only. 
        
# Screenshot
<img src="https://github.com/intsab/TagsView-Android/blob/master/Screenshot_20180124-142156.png">
