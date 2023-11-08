package com.obzen.tagworks.handler;

import android.util.Log;

import androidx.annotation.NonNull;

import com.obzen.tagworks.TagWorks;
import com.obzen.tagworks.constants.StandardEvent;

public class ApplicationExceptionHandler implements Thread.UncaughtExceptionHandler {

    private TagWorks tagWorks;

    public ApplicationExceptionHandler(TagWorks tagWorks){
        this.tagWorks = tagWorks;
    }

    @Override
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable throwable) {
        Log.e("TAGWORKS_ERROR", throwable.toString());
        TagWorks.EventPushBuilder.event(StandardEvent.ERROR, null).dimension(51, throwable.toString()).push();
    }
}
