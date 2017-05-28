package com.shizy.androidsample.ui.wol;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.shizy.androidsample.R;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by shizy on 2017/5/28.
 * 远程唤醒需要向目标主机发送Magic Packet包
 */

public class WakeOnLanActivity extends AppCompatActivity {

    private static final String TAG = WakeOnLanActivity.class.getSimpleName();

    private static final String HOST = "192.168.1.123"; // 主机名/IP/广播地址
    private static final int PORT = 9;  // 端口
    private static final String MAC = "74-D4-35-86-87-88";   // 主机Mac地址

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wake_on_lan);
    }

    /**
     * 使用UDP方式发送Magic Packet包
     *
     * @param view
     */
    public void wakeOnLan(View view) {
        Log.d(TAG, "Wake On Lan!");
        new Thread() {
            @Override
            public void run() {
                sendMagicPacket();
            }
        }.start();
    }

    private void sendMagicPacket() {
        try {
            InetAddress address = InetAddress.getByName(HOST);
            byte[] data = getMagicPacketBytes(MAC);
            DatagramPacket packet = new DatagramPacket(data, data.length, address, PORT);
            DatagramSocket socket = new DatagramSocket();

            socket.send(packet);
            socket.close();

            Log.d(TAG, "Wake On Lan Success!");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 魔术包格式数据
     * 以6个FF开头，后面跟mac地址，mac地址需要重复16次，共 6 * 17 = 102个字节
     *
     * @param mac
     * @return
     */
    private byte[] getMagicPacketBytes(String mac) {
        byte[] data = new byte[102];
        for (int i = 0; i < 6; i++) {
            data[i] = (byte) 0xFF;
        }

        byte[] macBytes = getMacBytes(mac);
        for (int i = 0; i < 16; i++) {
            System.arraycopy(macBytes, 0, data, (i + 1) * 6, macBytes.length);
        }

        return data;
    }

    /**
     * 将Mac地址转换为二进制格式
     *
     * @param mac
     * @return
     */
    private byte[] getMacBytes(String mac) {
        String[] hex = mac.split(":|-");
        byte[] data = new byte[6];
        for (int i = 0; i < hex.length; i++) {
            data[i] = (byte) Integer.parseInt(hex[i], 16);
        }
        return data;
    }

}
