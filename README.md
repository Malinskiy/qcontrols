QControls
==============

Annotation
--------------------
This library contains classes that are exactly the same as Android's quick controls found in
Browser but with additional improvements for handling.

Usage
--------------------
See sample activity code below:
````
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.malinskiy.qcontrols.PieControl;
import com.malinskiy.qcontrols.PieItem;

import java.util.ArrayList;
import java.util.List;


public class TestActivity extends Activity {
    private TestMenu testMenu;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); //replace with your layout id
        testMenu = new TestMenu(this);
        LinearLayout frame = (LinearLayout) findViewById(R.id.main_frame); //replace with id of your frame
        testMenu.attachToContainer(frame);
        testMenu.setListeners();
    }

    private class TestMenu extends PieControl {
        List<PieItem> plus_sub;
        List<PieItem> minus_sub;
        PieItem close;

        public TestMenu(Activity activity) {
            super(activity);
        }

        protected void populateMenu() {
            PieItem plus = makeItem(android.R.drawable.ic_input_add,1);
            {
                plus_sub = new ArrayList<PieItem>(2);
                plus_sub.add(makeItem(android.R.drawable.ic_input_add,1));
                plus_sub.add(makeItem(android.R.drawable.ic_input_add, 1));
                plus.addItems(plus_sub);
            }
            PieItem minus = makeItem(android.R.drawable.ic_menu_preferences,1);
            {
                minus_sub = new ArrayList<PieItem>(2);
                minus_sub.add(makeItem(android.R.drawable.ic_menu_preferences,1));
                minus_sub.add(makeItem(android.R.drawable.ic_menu_preferences, 1));
                minus.addItems(minus_sub);
            }
            close = makeItem(android.R.drawable.ic_menu_close_clear_cancel,1);
            mPie.addItem(plus);
            mPie.addItem(minus);
            mPie.addItem(close);
        }

        public void setListeners() {
            this.setClickListener(plus_sub.get(0),new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),"Clicked plus 1", Toast.LENGTH_SHORT).show();
                }
            });
            this.setClickListener(plus_sub.get(1), new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),"Clicked plus 2", Toast.LENGTH_SHORT).show();
                }
            });
            this.setClickListener(minus_sub.get(0), new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),"Clicked minus 1", Toast.LENGTH_SHORT).show();
                }
            });
            this.setClickListener(minus_sub.get(1), new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),"Clicked minus 2", Toast.LENGTH_SHORT).show();
                }
            });
            this.setClickListener(close, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }
}
````
