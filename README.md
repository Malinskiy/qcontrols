QControls
==============

Annotation
--------------------
This library contains classes that are exactly the same as Android's quick controls found in
Browser but with additional improvements for handling.

Usage
--------------------
Sample activity code for qcontrols:
````java
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

Sample activity code for ccontrols:
````java

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.Toast;
import com.malinskiy.ccontrols.*;

/**
 * Demo activity
 */
public class MainActivity extends Activity {
    private static float FLOAT_PI_DIVIDED_BY_TWO = (float) Math.PI / 2;
    private final static float sweep = FLOAT_PI_DIVIDED_BY_TWO / 2;
    private PieRenderer pieRenderer;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Important!!
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.main);

        pieRenderer = new PieRenderer(getApplicationContext());
        PieController pieController = new PieController(this, pieRenderer);

        RenderOverlay renderOverlay = (RenderOverlay) findViewById(R.id.render_overlay); //insert your id

        PieItem item0 = pieController.makeItem(android.R.drawable.arrow_up_float);
        item0.setFixedSlice(FLOAT_PI_DIVIDED_BY_TWO, sweep);
        item0.setOnClickListener(new PieItem.OnClickListener() {
            @Override
            public void onClick(PieItem item) {
                Toast.makeText(getApplicationContext(), "some cmd", Toast.LENGTH_SHORT).show();
            }
        });

        PieItem item1 = pieController.makeItem(android.R.drawable.arrow_up_float);
        item1.setFixedSlice(FLOAT_PI_DIVIDED_BY_TWO + sweep, sweep);
        item1.setOnClickListener(new PieItem.OnClickListener() {
            @Override
            public void onClick(PieItem item) {
                Toast.makeText(getApplicationContext(), "some cmd 2", Toast.LENGTH_SHORT).show();
            }
        });

        PieItem item7 = pieController.makeItem(android.R.drawable.arrow_up_float);
        item7.setFixedSlice(FLOAT_PI_DIVIDED_BY_TWO - sweep, sweep);
        item7.setOnClickListener(new PieItem.OnClickListener() {
            @Override
            public void onClick(PieItem item) {
                Toast.makeText(getApplicationContext(), "some cmd 7", Toast.LENGTH_SHORT).show();
            }
        });

        pieRenderer.addItem(item0);
        pieRenderer.addItem(item1);
        pieRenderer.addItem(item7);

        PieItem item0_0 = pieController.makeItem(android.R.drawable.ic_menu_add);
        item0_0.setFixedSlice(FLOAT_PI_DIVIDED_BY_TWO, sweep);
        item0_0.setOnClickListener(new PieItem.OnClickListener() {
            @Override
            public void onClick(PieItem item) {
                Toast.makeText(getApplicationContext(), "some cmd", Toast.LENGTH_SHORT).show();
            }
        });

        PieItem item0_6 = pieController.makeItem(android.R.drawable.ic_menu_add);
        item0_6.setFixedSlice(FLOAT_PI_DIVIDED_BY_TWO + sweep, sweep);
        item0_6.setOnClickListener(new PieItem.OnClickListener() {
            @Override
            public void onClick(PieItem item) {
                Toast.makeText(getApplicationContext(), "some cmd 2", Toast.LENGTH_SHORT).show();
            }
        });

        PieItem item0_7 = pieController.makeItem(android.R.drawable.ic_menu_add);
        item0_7.setFixedSlice(FLOAT_PI_DIVIDED_BY_TWO - sweep, sweep);
        item0_7.setOnClickListener(new PieItem.OnClickListener() {
            @Override
            public void onClick(PieItem item) {
                Toast.makeText(getApplicationContext(), "some cmd 7", Toast.LENGTH_SHORT).show();
            }
        });

        item0.addItem(item0_0);
        item0.addItem(item0_6);
        item0.addItem(item0_7);

        renderOverlay.addRenderer(pieRenderer);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        pieRenderer.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
````