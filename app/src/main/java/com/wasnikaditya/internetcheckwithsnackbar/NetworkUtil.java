package com.wasnikaditya.internetcheckwithsnackbar;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;

class NetworkUtil
{

    public static String getConnectivityStatusString(Context context) {
        String status = null;
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                status = "Wifi enabled";

                Snacky.builder().setActivity((Activity) context).setActionText("ACTION").setActionClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //do something
                    }
              //  }).setText("Snackbar text is not cut after two lines, you can use setMaxLines(int) to achieve this")
                }).setText(status)
                        .setDuration(Snacky.LENGTH_INDEFINITE).build().show();



                return status;

            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                status = "Mobile data enabled";
                return status;
            }
        }else{
            status = "No internet is available";
            return status;
        }

        return status;
    }
}
