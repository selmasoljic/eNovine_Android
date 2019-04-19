package android.fit.ba.myapp.helper;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MyUtil {
    public static void pozoviFragment(FragmentActivity activity, int id, Fragment fragment) {
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(id,fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public static void pozoviDialog(FragmentActivity activity, DialogFragment dlg) {
        FragmentManager fm = activity.getSupportFragmentManager();

        dlg.show(fm,"tagNeki");
    }

}
