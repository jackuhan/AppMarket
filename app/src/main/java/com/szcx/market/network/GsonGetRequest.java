package com.szcx.market.network;

import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.JsonSyntaxException;
import com.szcx.market.MarketApplication;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

/**
 * Makes a get request and converts the response from JsonElement into a
 * list of objects/object using with Google Gson.
 */
public class GsonGetRequest<T> extends Request<T> {
  private final Type type;
  private final Response.Listener<T> listener;

  /**
   * Make a GET request and return a parsed object from JSON.
   *
   * @param url URL of the request to make
   * @param type is the type of the object to be returned
   * @param listener is the listener for the right answer
   * @param errorListener is the listener for the wrong answer
   */
  public GsonGetRequest(@NonNull final String url, @NonNull final Type type, @NonNull final Response.Listener<T> listener,
      @NonNull final Response.ErrorListener errorListener) {
    super(Method.GET, url, errorListener);

    Log.d("GET", url);
    this.type = type;
    this.listener = listener;
  }

  @Override protected void deliverResponse(T response) {
    listener.onResponse(response);
  }

  @SuppressWarnings("unchecked") @Override protected Response<T> parseNetworkResponse(NetworkResponse response) {
    try {
      String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
      Log.v("parseNetworkResponse", null == json ? "" : json);

      return (Response<T>) Response.success(MarketApplication.getInstance().getGson().fromJson(json, type),
          HttpHeaderParser.parseCacheHeaders(response));
    } catch (UnsupportedEncodingException e) {
      return Response.error(new ParseError(e));
    } catch (JsonSyntaxException e) {
      return Response.error(new ParseError(e));
    }
  }
}
