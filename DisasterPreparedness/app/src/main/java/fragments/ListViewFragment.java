package fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
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
public class ListViewFragment extends Fragment {

    private ArrayList<String> data= new ArrayList<>();


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listfrag,container,false);
        ListView lv= (ListView) rootView.findViewById(R.id.listView);
        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.i("tag", "keyCode:" + keyCode);
                if(keyCode== KeyEvent.KEYCODE_BACK)
                {
                    Log.i("tag","on key back");
                    getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    return true;
                }
                else{
                    return false;
                }
            }
        });
        generateListContent();
        lv.setAdapter(new MyListAdapter(getActivity().getApplicationContext(), R.layout.listitem, data));
        return rootView;
    }

    private void generateListContent() {
        data.add("RECOGNIZING SYMPTOMS AND CALLING FOR HELP "+"\n"+"in case of HEART ATTACK");
        data.add("SOME PRELIMINARY TIPS TO TREAT HEART ATTACK");
        data.add("TREATING SEVERE BLOOD ISSUES");
        data.add("FIRST AID TO STOP IMMENSE BLEEDING");
        data.add("FIRST AID TO TREAT BONE DISLOCATION");
        data.add("FIRST AID TO TREAT BREATHING PROBLEMS");
        data.add("FIRST AID TO TREAT OPEN FRACTURES");
        data.add("FIRST AID TO TREAT CLOSED FRACTURES");
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
                LayoutInflater inflater=LayoutInflater.from(getContext());
                convertView=inflater.inflate(layout,parent,false);
                ViewHolder viewHolder=new ViewHolder();
                viewHolder.tv=(TextView) convertView.findViewById(R.id.list_item_tv);
                viewHolder.btn=(Button) convertView.findViewById(R.id.list_item_btn);
                viewHolder.tv.setText(obj.get(position));
                viewHolder.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentManager fm=getFragmentManager();
                        if(position==0) {
                            fm.beginTransaction().replace(R.id.content_frame, new HeartInc()).addToBackStack("null").commit();
                        }
                        else if (position==1)
                        {
                            fm.beginTransaction().replace(R.id.content_frame, new HeartTwo()).addToBackStack("null").commit();
                            //Toast.makeText(getContext(), "Btton clicked is 1", Toast.LENGTH_SHORT).show();
                        }
                        else if (position==2)
                        {
                            fm.beginTransaction().replace(R.id.content_frame, new SevereBlood()).addToBackStack("null").commit();
                            //Toast.makeText(getContext(), "Btton clicked is 1", Toast.LENGTH_SHORT).show();
                        }
                        else if (position==3)
                        {
                            fm.beginTransaction().replace(R.id.content_frame, new BloodLoss()).addToBackStack("null").commit();
                            //Toast.makeText(getContext(), "Btton clicked is 1", Toast.LENGTH_SHORT).show();
                        }
                        else if (position==4)
                        {
                            fm.beginTransaction().replace(R.id.content_frame, new BoneDisc()).addToBackStack("null").commit();
                            //Toast.makeText(getContext(), "Btton clicked is 1", Toast.LENGTH_SHORT).show();
                        }
                        else if (position==5)
                        {
                            fm.beginTransaction().replace(R.id.content_frame, new Breathe()).addToBackStack("null").commit();
                            //Toast.makeText(getContext(), "Btton clicked is 1", Toast.LENGTH_SHORT).show();
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
        Button btn;
    }

}
