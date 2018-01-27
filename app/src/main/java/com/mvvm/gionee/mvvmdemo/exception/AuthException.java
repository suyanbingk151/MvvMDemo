package com.mvvm.gionee.mvvmdemo.exception;

/**
 * Created by sulc on 2017/9/19.
 */


public class AuthException
        extends Exception
{
    public AuthException(String message)
    {
        super(message);
    }

    public AuthException(String message, Throwable cause)
    {
        super(message, cause);
    }
}

