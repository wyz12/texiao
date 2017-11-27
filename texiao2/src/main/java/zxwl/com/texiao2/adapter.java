package zxwl.com.texiao2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2017/11/17.
 */

public class adapter extends BaseAdapter {
    private List<String> list;
    private Context context;
    private HH hh;

    public adapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null){
            hh = new HH();
            view = LayoutInflater.from(context).inflate(R.layout.bb, null);
            hh.name=view.findViewById(R.id.imageView);
            view.setTag(hh);
        }else{
            view= (View) view.getTag();
        }
        Glide.with(context).load(list.get(i)).into(hh.name);


        return view;
    }

    class HH{
        ImageView name;
    }
}
