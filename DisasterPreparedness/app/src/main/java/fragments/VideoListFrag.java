package fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teju.disasterpreparedness.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teju on 3/17/2017.
 */
public class VideoListFrag extends Fragment{
    private ArrayList<String> data= new ArrayList<>();
    String API_KEY="AIzaSyAQ_euJd8XSRgLaUaBEV9SCjobCqAMG-aE";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listfrag,container,false);
        ListView lv= (ListView) rootView.findViewById(R.id.listView);
        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.i("tag", "keyCode:" + keyCode);
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    Log.i("tag", "on key back");
                    getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    return true;
                } else {
                    return false;
                }
            }
        });
        generateListContent();
        lv.setAdapter(new MyListAdapter(getActivity().getApplicationContext(), R.layout.listitem2, data));
        return rootView;
    }

    private void generateListContent() {
        data.add("CPR TECHNIQUE");
        data.add("BREATHE RELATED FIRST AID");
        data.add("HOW TO SPLINT A BROKEN ARM");
        data.add("HOW TO TREAT CLOSED FRACTURE");
    }

    private class MyListAdapter extends ArrayAdapter<String>
    {
        private int layout;
        public List<String> obj;
        public MyListAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            layout=resource;
            obj=objects;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainViewHolder=null;
            if(convertView==null)
            {
                final LayoutInflater inflater=LayoutInflater.from(getContext());
                convertView=inflater.inflate(layout,parent,false);
                ViewHolder viewHolder=new ViewHolder();
                viewHolder.tv=(TextView)convertView.findViewById(R.id.list_item_tv);
                viewHolder.btn=(Button)convertView.findViewById(R.id.list_item_btn);
                viewHolder.tv.setText(obj.get(position));
                viewHolder.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentManager fm = getFragmentManager();
                        //Toast.makeText(getContext(), "Btton clicked for " + position, Toast.LENGTH_SHORT).show();
                        if (position == 0) {
                            Intent intent=new Intent(getActivity(),VideoOne.class);
                            startActivity(intent);
                        } else if (position == 2) {
                            Intent intent=new Intent(getActivity(),VideoTwo.class);
                            startActivity(intent);
                        }
                        else if (position == 3) {
                            Intent intent=new Intent(getActivity(),VideoThree.class);
                            startActivity(intent);
                        }
                        else if (position == 4) {
                            Intent intent=new Intent(getActivity(),VideoFour.class);
                            startActivity(intent);
                        }

                    }
                });
                convertView.setTag(viewHolder);
            }
            else
            {
                mainViewHolder=(ViewHolder)convertView.getTag();
                mainViewHolder.tv.setText(getItem(position));
            }
            return convertView;
        }

    }

    public class ViewHolder{
        TextView tv;
        Button btn;}

}

