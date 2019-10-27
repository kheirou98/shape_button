package com.example.shape_bouton;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Implementation of App Widget functionality.
 */
public class widget extends AppWidgetProvider {

   /* static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }*/

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId=0; appWidgetId<appWidgetIds.length;appWidgetId++) {
            int appid=appWidgetIds[appWidgetId];
            RemoteViews view= new RemoteViews(context.getPackageName(),R.layout.widget);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
            String currentDateandTime= sdf.format(new Date());
            view.setTextViewText(R.id.appwidget_text,currentDateandTime);
            Intent intent =new Intent(context,MainActivity.class);
            PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intent,0);
            view.setOnClickPendingIntent(R.id.button6,pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetIds,view);



            //updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    /*@Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }*/
}

