package com.zsoftware;



import com.chiclam.android.updater.Updater;
import com.chiclam.android.updater.UpdaterConfig;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.DownloadManager;

public class AppUpdaterPlugin extends CordovaPlugin {


    /**
     * 重写方法
     *
     * @param action          The action to execute.
     * @param args            The exec() arguments.
     * @param callbackContext The callback context used when calling back into JavaScript.
     * @return
     * @throws JSONException
     */
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if("downloadInstallAPK".equals(action)){
            //下载地址url
            String url = args.getString(0);
            UpdaterConfig config = new UpdaterConfig.Builder(this.cordova.getActivity())
                    .setTitle("更新应用")
                    .setDescription("更新应用中")
                    .setFileUrl(url)
                    .setCanMediaScanner(false)
                    .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE
                            | DownloadManager.Request.NETWORK_WIFI)
                    .build();
            Updater.get().showLog(false).download(config);
            return true;
        }

        return false;
    }


}
