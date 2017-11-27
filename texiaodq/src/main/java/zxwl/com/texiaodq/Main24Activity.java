package zxwl.com.texiaodq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import lt.lemonlabs.android.expandablebuttonmenu.ExpandableButtonMenu;
import lt.lemonlabs.android.expandablebuttonmenu.ExpandableMenuOverlay;

public class Main24Activity extends AppCompatActivity {

    private ExpandableMenuOverlay menuOverlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main24);

        menuOverlay = (ExpandableMenuOverlay) findViewById(R.id.button_menu);
        menuOverlay.setOnMenuButtonClickListener(new ExpandableButtonMenu.OnMenuButtonClick() {
            @Override
            public void onClick(ExpandableButtonMenu.MenuButton action) {
                switch (action) {
                    case MID:
                        // do stuff and dismiss
                        menuOverlay.getButtonMenu().toggle();
                        break;
                    case LEFT:
                        // do stuff
                        break;
                    case RIGHT:
                        // do stuff
                        break;
                }
            }
        });

    }
}
