package com.magen.EasyPush;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


public class EasyMessage {

    private final static String contentType = "content_type";
    private final static String auth = "authorization";
    private Context context;
    private boolean isObjectData;
    private boolean isTopics;
    private String sendTo;
    private FCMRequest mRequest;
    JSONObject extraData = new JSONObject();

    public EasyMessage(Context context, boolean isObjectData, String sendTo, String serverKey, boolean isTopics){
        this.context = context;
        this.isObjectData = isObjectData;
        this.sendTo = sendTo;
        this.mRequest = new FCMRequest(serverKey, context);
        this.isTopics = isTopics;
    }

    public EasyMessage(){

    }

    public EasyMessage setContext(Context context){
        this.context = context;
        return this;
    }

    public EasyMessage setIsObjectData(boolean isObjectData){
        this.isObjectData = isObjectData;
        return this;
    }

    public EasyMessage setSendTo(String sendTo){
        this.sendTo = sendTo;
        return this;
    }

    public EasyMessage setServerKey(String authKey, Context context){
        this.context = context;
        this.mRequest = new FCMRequest(authKey, context);
        return this;
    }

    public EasyMessage setIsTopics(boolean isTopics){
        this.isTopics = isTopics;
        return this;
    }

    public EasyMessage putData(String key, Object obj) throws JSONException {
        extraData.put(key, obj);
        return this;
    }

    public void sendFirebaseMessage(Consumer<String> result) throws JSONException {
        if (extraData.length() == 0){
            throw new IllegalArgumentException("you must send something, use 'putData' to set some data");
        }
        if(context == null){
            throw new IllegalStateException("you must initialized context");
        }
        if(sendTo == null){
            throw new IllegalStateException("you must initialized person/channel to send the message");
        }
        if(mRequest == null){
            throw new IllegalStateException("you must initialized server key");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("to", (isTopics?"/topics/":"") + sendTo);
        jsonObject.put(getExternalDataKey() , extraData);
        mRequest.requestQueue(jsonObject, result);
    }

    public String getExternalDataKey(){
        return isObjectData ? "notification" : "data";
    }


    private class FCMRequest{
        private final HashMap<String, String> headers = new HashMap<>();
        RequestQueue requestQueue;
        public FCMRequest(String auth, Context context){
            if(auth == null || auth.length() == 0) throw new IllegalArgumentException("auth must not be null");
            if(auth.contains("key=")) throw new IllegalArgumentException("auth must contain only the server key");
            requestQueue = Volley.newRequestQueue(context);
            headers.put(EasyMessage.contentType, "application/json");
            headers.put(EasyMessage.auth, "key="+auth);
        }

        public HashMap<String, String> getHeaders() {
            return headers;
        }

        public void requestQueue(JSONObject jsonObject, Consumer<String> result) {
            JsonObjectRequest request = new JsonObjectRequest(
                    Request.Method.POST,
                    "https://fcm.googleapis.com/fcm/send",
                    jsonObject,
                    response -> result.accept("request sent"),
                    error -> result.accept(error.getMessage())
            ){
                @Override
                public Map<String, String> getHeaders() {
                    return mRequest.getHeaders();
                }
            };
            requestQueue.add(request);
        }
    }
}
