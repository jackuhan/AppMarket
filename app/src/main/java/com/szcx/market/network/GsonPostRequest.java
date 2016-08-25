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
import java.util.Map;

/**
 * Created by C on 2015/10/7.
 */
public class GsonPostRequest<T> extends Request<T> {

  private Map<String, String> params;
  private final Type type;
  private final Response.Listener<T> listener;

  public GsonPostRequest(@NonNull final String url, @NonNull final Type type, @NonNull final Map<String, String> params,
      @NonNull final Response.Listener<T> listener, @NonNull final Response.ErrorListener errorListener) {
    super(Method.POST, url, errorListener);

    Log.d("POST", url);
    if (null != params) {
      Log.d("POST", params.toString());
    }
    this.type = type;
    this.listener = listener;
    this.params = params;
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

  @Override protected void deliverResponse(T response) {
    listener.onResponse(response);
  }

  @Override public Map<String, String> getParams() throws com.android.volley.AuthFailureError {
    return params;
  }
}
