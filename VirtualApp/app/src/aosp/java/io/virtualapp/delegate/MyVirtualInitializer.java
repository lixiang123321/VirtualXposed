package io.virtualapp.delegate;

import android.app.Application;

import com.lody.virtual.client.core.VirtualCore;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

/**
 * @author weishu
 * @date 2019/2/25.
 */
public class MyVirtualInitializer extends BaseVirtualInitializer {
    public MyVirtualInitializer(Application application, VirtualCore core) {
        super(application, core);
    }

    @Override
    public void onMainProcess() {
        AppCenter.start(application, "bf5e74bd-3795-49bd-95c8-327db494dd11",
                Analytics.class, Crashes.class);
        super.onMainProcess();
    }

    @Override
    public void onVirtualProcess() {

        // For Crash statics
        AppCenter.start(application, "bf5e74bd-3795-49bd-95c8-327db494dd11",
                Analytics.class, Crashes.class);

        super.onVirtualProcess();

        // Override
        virtualCore.setCrashHandler(new MyCrashHandler());

		// 希望做Java Hook
        // TODO: 2022/7/24 virtualCore.setAppCallback, set MyXposedJavaHook method
        // failed： 没这块代码了

        // 直接Xposed也不行

        // 反射？

    }
}
