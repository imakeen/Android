package com.ui.liangxi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.ToastUtils;
import com.example.myapplication.R;
import com.mvpdemo.MvpActivity;

import butterknife.BindView;


public class MainActivity extends MvpActivity<MainContranct.View, MainPresenter> implements MainContranct.View {
    @BindView(R.id.image)
    ImageView imageView;
    @BindView(R.id.layout)
    RelativeLayout relativeLayout;
    IntentFilter intentFilter;
    NetworkChamgeReciver networkChamgeReciver;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    protected void init() {
        mPresenter.get();
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChamgeReciver = new NetworkChamgeReciver();
        registerReceiver(networkChamgeReciver, intentFilter);
    }



    @Override
    public void onFailed() {

    }

    @Override
    public void get() {

    }

    class NetworkChamgeReciver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = ( ConnectivityManager )
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null&&networkInfo.isAvailable()){
                ToastUtils.showShort("HAVE");
            }
            else {
                ToastUtils.showShort("NO");
            }
        }
    }
}
/**
 * Fragment添加
 *
 * @time 2020/4/9  15:58
 * //
 */
//        fragment fragmet = new fragment();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.list, fragmet);
//        fragmet.refrech("ttt", "tttt");


//打电话
//     Uri number = Uri.parse("tel:"+111);
//     Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

//地图
//Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
// Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
//Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

//        Uri location = Uri.parse("geo:0,0?q北京");
//        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
//        PackageManager packageManager = getPackageManager();
//        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
//        boolean isIntentSafe = activities.size() > 0;
//
//        // Start an activity if it's safe
//        if (isIntentSafe) {
//            startActivity(mapIntent);
//        }

//日程
//        Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
//        Calendar beginTime = Calendar.getInstance();
//        beginTime.set(2012, 0, 19, 7, 30);
//        Calendar endTime = Calendar.getInstance();
//        endTime.set(2012, 0, 19, 10, 30);
//        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
//        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
//        calendarIntent.putExtra(CalendarContract.Events.TITLE, "Ninja class");
//        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo");

//点击联系人获取手机号
//        Intent intent = new Intent(Intent.ACTION_PICK, Uri.parse("content://content"));
//        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
//        startActivityForResult(intent, PICK_CONTACT_REQUEST);


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == PICK_CONTACT_REQUEST) {
//            if (resultCode == RESULT_OK) {
//                Uri contactUri = data.getData();
//                String[] projectin = {ContactsContract.CommonDataKinds.Phone.NUMBER};
//                Cursor cursor = getContentResolver().query(contactUri, projectin, null, null, null);
//                cursor.moveToFirst();
//                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
//                String string = cursor.getString(column);
//                ToastUtils.showShort(string);
//            }
//        }
//    }

