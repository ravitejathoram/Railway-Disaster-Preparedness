package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teju.disasterpreparedness.R;


/**
 * Created by teju on 2/17/2017.
 */
public class HeartInc extends Fragment{

    //@Override
   /* protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heartinc);

    }*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        View rootView =inflater.inflate(R.layout.heartinc,container,false);
        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.i("tag", "keyCode:" + keyCode);
                if(keyCode== KeyEvent.KEYCODE_BACK)
                {
                    Log.i("tag","on key back");
                    getFragmentManager().popBackStack();
                    return true;
                }
                else{
                    return false;
                }
            }
        });
        return rootView;
    }

}
