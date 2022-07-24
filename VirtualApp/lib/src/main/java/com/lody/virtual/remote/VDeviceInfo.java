package com.lody.virtual.remote;

import android.os.Parcel;
import android.os.Parcelable;

import com.lody.virtual.os.VEnvironment;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Lody
 */
public class VDeviceInfo implements Parcelable {

    public String deviceId;
    public String androidId;
    public String wifiMac;// 形式为：00:00:00:00:00:00:00
    public String wifiBSSID;// 形式为：00:00:00:00:00:00:00
    public String wifiSSID;// 形式为：String, 任意
    public String wifiIp;// 形式为：192.168.x.x, xfrom3-254
    public String bluetoothMac;// 形式为：00:00:00:00:00:00:00
    public String iccId;
    public String serial;
    public String gmsAdId;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.deviceId);
        dest.writeString(this.androidId);
        dest.writeString(this.wifiMac);
        dest.writeString(this.wifiBSSID);
        dest.writeString(this.wifiSSID);
        dest.writeString(this.wifiIp);
        dest.writeString(this.bluetoothMac);
        dest.writeString(this.iccId);
        dest.writeString(this.serial);
        dest.writeString(this.gmsAdId);
    }

    public VDeviceInfo() {}

    public VDeviceInfo(Parcel in) {
        this.deviceId = in.readString();
        this.androidId = in.readString();
        this.wifiMac = in.readString();
        this.wifiBSSID = in.readString();
        this.wifiSSID = in.readString();
        this.wifiIp = in.readString();
        this.bluetoothMac = in.readString();
        this.iccId = in.readString();
        this.serial = in.readString();
        this.gmsAdId = in.readString();
    }

    public static final Parcelable.Creator<VDeviceInfo> CREATOR = new Parcelable.Creator<VDeviceInfo>() {
        @Override
        public VDeviceInfo createFromParcel(Parcel source) {
            return new VDeviceInfo(source);
        }

        @Override
        public VDeviceInfo[] newArray(int size) {
            return new VDeviceInfo[size];
        }
    };

    public File getWifiFile(int userId) {
        File wifiMacFie = VEnvironment.getWifiMacFile(userId);
        if (!wifiMacFie.exists()) {
            try {
                RandomAccessFile file = new RandomAccessFile(wifiMacFie, "rws");
                file.write((wifiMac + "\n").getBytes());
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return wifiMacFie;
    }
}
