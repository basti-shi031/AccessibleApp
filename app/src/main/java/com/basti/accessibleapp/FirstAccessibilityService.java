package com.basti.accessibleapp;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

/**
 * Created by Boateng17 on 2017/3/11.
 */

public class FirstAccessibilityService extends AccessibilityService {
    /**
     * 启动服务时回调
     *
     * @param accessibilityEvent
     */
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int eventType = accessibilityEvent.getEventType();
        Log.i("eventType", String.valueOf(eventType));
        switch (eventType) {
            case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
                //正文部分发生变化
                List<AccessibilityNodeInfo> nodeInfos = accessibilityEvent.getSource().findAccessibilityNodeInfosByViewId("com.tencent.mm:id/a4w");
                Log.i("size", String.valueOf(nodeInfos.size()));
                if (nodeInfos.size() >= 1) {
                    AccessibilityNodeInfo fileNode = nodeInfos.get(0);
                    fileNode.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
                break;
        }
    }

    /**
     * 中断服务
     */
    @Override
    public void onInterrupt() {

    }
}
