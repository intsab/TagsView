package intandif.icontags;

/**
 * Created by intsab on 22/01/2018.
 */

public class TagItem {
    int _resource;
    String _title;
    String _iconUrl;


    public TagItem(int resource, String title){
     this._resource= resource;
     this._title= title;
    }
    public TagItem(String iconUrl, String title){
        this._iconUrl= iconUrl;
        this._title= title;
    }
    public String get_iconUrl() {
        return _iconUrl;
    }

    public void set_iconUrl(String _iconUrl) {
        this._iconUrl = _iconUrl;
    }

    public int getResource() {
        return _resource;
    }

    public void setResource(int resource) {
        this._resource = resource;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        this._title = title;
    }



}
