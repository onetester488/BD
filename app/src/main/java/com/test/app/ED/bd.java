package com.test.app.ED;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;



//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")
//                || FINGERPRINT.contains("")

/**
 * Copyright 2023 SAID-DEV, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.2 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * Created by SAID-Dev on 02/02/23.
 **/
public final class bd {
    public static String kernelVersion = System.getProperty("os.version");
    public static String basebandVersion = Build.getRadioVersion();
    public static final String FINGERPRINT = DFingerprint();

    public interface OnEmulatorDetectorListener {
        void onResult(boolean isEmulator);
    }



    @SuppressLint("StaticFieldLeak")
    private static  Context mContext;

    private static final List<String> mListPackageName = new ArrayList<>();

    @SuppressLint("StaticFieldLeak")
    private static bd mED;

    public static bd with(Context pContext) {
        if (pContext == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        if (mED == null)
            mED = new bd(pContext.getApplicationContext());
        return mED;
    }

    private bd(Context pContext) {
        mContext = pContext;
        mListPackageName.add("com.google.android.launcher.layouts.genymotion");
        mListPackageName.add("com.bluestacks");
        mListPackageName.add("com.bignox.app");
    }



    public static void detect(final OnEmulatorDetectorListener pOnEmulatorDetectorListener) {
        new Thread(() -> {
            boolean isEmulator = detect();
            if (pOnEmulatorDetectorListener != null) {
                pOnEmulatorDetectorListener.onResult(isEmulator);
            }
        }).start();
    }

    private static boolean detect () {
        boolean result = false;


        // Check Basic
        if (!result) {
            result = checkBasic();
        }

        // Check Advanced
        if (!result) {
            result = checkAdvanced();
        }
         return result;
    }



    private static boolean checkBasic () {
        @SuppressLint("HardwareIds") boolean result =
                 Build.MODEL.contains("google_sdk")
                || Build.MODEL.toLowerCase().contains("droid4x")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MODEL.contains("google")
                || Build.MODEL.contains("SM-A217F")
                || Build.MODEL.contains("SM-A528B")
                || Build.MODEL.contains("SM-A325F")
                || Build.MODEL.contains("SM-A235F")
                || Build.MODEL.contains("SM-A326B")
                || Build.MODEL.contains("SM-A336E")
                || Build.MODEL.contains("SM-A715F")
                || Build.MODEL.contains("SM-A226B")
                || Build.MODEL.contains("Pixel 4a")
                || Build.MODEL.contains("Pixel 6")
                || Build.MODEL.contains("Pixel 4 XL")
                || Build.MODEL.contains("Pixel 2 XL")
                || Build.MODEL.contains("OnePlus8Pro")
                || Build.MODEL.contains("Nexus 5X")
                || Build.BRAND.contains("Pixel")
                || Build.BRAND.contains("Google")
                || Build.BRAND.contains("google")
                || Build.MANUFACTURER.contains("Genymotion")
                || Build.MANUFACTURER.contains("Google")
                || Build.HARDWARE.equals("goldfish")
                || Build.HARDWARE.equals("android_x86")
                || Build.HARDWARE.equals("vbox86")
                || Build.PRODUCT.equals("sdk")
                || Build.PRODUCT.equals("google_sdk")
                || Build.PRODUCT.equals("sdk_x86")
                || Build.PRODUCT.equals("vbox86p")
                || Build.PRODUCT.equals("google Pixel ")
                || Build.BOARD.toLowerCase().contains("nox")
                || Build.BOOTLOADER.toLowerCase().contains("nox")
                || Build.HARDWARE.toLowerCase().contains("nox")
                || Build.PRODUCT.toLowerCase().contains("nox")
                || Build.SERIAL.toLowerCase().contains("nox");

        if (result) return true;
        result = Build.BRAND.startsWith ("generic") && Build.DEVICE.startsWith ("generic");
        if (result) return true;
        result = "google_sdk".equals (Build.PRODUCT);
        return result;
    }

    private static boolean checkAdvanced () {
        boolean result= (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || Build.HARDWARE.contains("goldfish")
                || Build.HARDWARE.contains("ranchu")

                || FINGERPRINT.contains(st.FINGERPRINT1)
                || FINGERPRINT.contains(st.FINGERPRINT2)
                || FINGERPRINT.contains(st.FINGERPRINT3)
                || FINGERPRINT.contains(st.FINGERPRINT4)
                || FINGERPRINT.contains(st.FINGERPRINT5)
                || FINGERPRINT.contains(st.FINGERPRINT6)
                || FINGERPRINT.contains(st.FINGERPRINT7)
                || FINGERPRINT.contains(st.FINGERPRINT8)
                || FINGERPRINT.contains(st.FINGERPRINT9)
                || FINGERPRINT.contains(st.FINGERPRINT10)
                || Build.SERIAL.contains("nox")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || Build.MANUFACTURER.contains("Google")
                || Build.PRODUCT.contains("sdk")
                || Build.PRODUCT.contains("sdk_x86")
                || Build.PRODUCT.contains("sdk_gphone64_arm64")
                || Build.PRODUCT.contains("vbox86p")
                || Build.PRODUCT.contains("emulator")
                || Build.PRODUCT.contains("simulator");


        return result;
    }





    public static String getDeviceInfo() {
        return  "Build.kernelVersion: " + kernelVersion + "\n" +
                "Build.basebandVersion: " + basebandVersion + "\n" +
                "Build.PRODUCT: " + Build.PRODUCT + "\n" +
                "Build.MANUFACTURER: " + Build.MANUFACTURER + "\n" +
                "Build.BRAND: " + Build.BRAND + "\n" +
                "Build.DEVICE: " + Build.DEVICE + "\n" +
                "Build.MODEL: " + Build.MODEL + "\n" +
                "Build.BOOTLOADER: " + Build.BOOTLOADER + "\n" +
                "Build.ID: " + Build.ID + "\n" +
                "Build.USER: " + Build.USER + "\n" +
                "Build.SERIAL: " + Build.SERIAL + "\n" +
                "Build.HARDWARE: " + Build.HARDWARE + "\n" +
                "FINGERPRINT:" + FINGERPRINT;
    }

    private static String DFingerprint() {
        return  "MODEL:" +Build.MODEL +'|' +
                "PRODUCT:" +Build.PRODUCT +'|' +
                "BRAND:" +Build.BRAND + '|' +
                "MANUFACTURER:" +Build.MANUFACTURER +'|' +
                "DEVICE:" +Build.DEVICE +'|' +
                "BOOTLOADER:" +Build.BOOTLOADER +'|' +
                "ID:" +Build.ID  +'|' +
                "HARDWARE:" +Build.HARDWARE +'|' +
                "kernelVersion:" +kernelVersion;
        }




}
