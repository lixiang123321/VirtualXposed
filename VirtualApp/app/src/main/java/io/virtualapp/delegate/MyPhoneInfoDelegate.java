package io.virtualapp.delegate;

import com.lody.virtual.client.hook.delegate.PhoneInfoDelegate;
import com.lody.virtual.helper.utils.VLog;


/**
 * Fake the Device ID.
 */
public class MyPhoneInfoDelegate implements PhoneInfoDelegate {

    private static final String TAG = MyPhoneInfoDelegate.class.getSimpleName();

	// 增加了log，但好像这个类没被调用到。
	
    @Override
    public String getDeviceId(String oldDeviceId, int userId) {
        VLog.i(TAG, "getDeviceId() : "
                + " oldDeviceId = " + oldDeviceId + ","
                + " userId = " + userId + ","
        );
        return oldDeviceId;
    }

    @Override
    public String getBluetoothAddress(String oldAddress, int userId) {
        VLog.i(TAG, "getBluetoothAddress() : "
                + " oldAddress = " + oldAddress + ","
                + " userId = " + userId + ","
        );
        return oldAddress;
    }

    @Override
    public String getMacAddress(String oldAddress, int userId) {
        VLog.i(TAG, "getMacAddress() : "
                + " oldAddress = " + oldAddress + ","
                + " userId = " + userId + ","
        );
//        return "02:00:00:00:00:00";
        return oldAddress;
    }
}
