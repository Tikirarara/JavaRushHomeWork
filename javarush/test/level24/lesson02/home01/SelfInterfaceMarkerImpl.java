package com.javarush.test.level24.lesson02.home01;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker
{

    public SelfInterfaceMarkerImpl()
    {
    }

    @Override
    public String toString()
    {
        return "SelfInterfaceMarkerImpl{}";
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }
}
