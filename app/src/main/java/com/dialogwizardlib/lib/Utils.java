package com.dialogwizardlib.lib;

import android.app.Activity;
import android.graphics.Rect;
import android.view.Window;

public class Utils {
    public static class DisplayTools {
        private static final String TAG = "DisplayUtils";
        private final Activity mActivity;

        public DisplayTools(Activity act) {
            mActivity = act;
        }

        public Rect getScreenRectangle() {
            Rect displayRectangle = new Rect();
            Window window = mActivity.getWindow();

            window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);

            return displayRectangle;
        }



    }

}
