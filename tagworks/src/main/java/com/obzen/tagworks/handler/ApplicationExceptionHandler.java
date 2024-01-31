package com.obzen.tagworks.handler;

import android.util.Log;

import androidx.annotation.NonNull;

import com.obzen.tagworks.TagWorks;
import com.obzen.tagworks.constants.StandardEvent;

public class ApplicationExceptionHandler  {

    /*private TagWorks tagWorks;

    public ApplicationExceptionHandler(TagWorks tagWorks){
        this.tagWorks = tagWorks;
    }

    @Override
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable throwable) {
        try{
            TagWorks.EventPushBuilder.event(StandardEvent.ERROR, null).dimension(51, throwable.getMessage()).push();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(!(Thread.getDefaultUncaughtExceptionHandler() instanceof ApplicationExceptionHandler)){
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(thread, throwable);
            }
        }
    }*/
}
