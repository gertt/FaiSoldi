package com.dailybenefit1k.repository.network;

import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by gPrifti on 7/5/2018.
 */

public class HttpLoggingInterceptor  implements Interceptor {

    private static final Charset UTF8 = Charset.forName("UTF-8");
    private Level level;
    public enum Level {

        BODY
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }

    public HttpLoggingInterceptor setLevel(Level level) {
        if (level == null) throw new NullPointerException("level == null. Use Level.NONE instead.");
        this.level = level;
        return this;
    }

}

