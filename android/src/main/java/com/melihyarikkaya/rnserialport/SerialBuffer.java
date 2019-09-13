package com.melihyarikkaya.rnserialport;
public class SerialBuffer
{
    private static final int DEFAULT_CAPACITY = 4;
    private byte[] bufferArray;
    private int size;
    private int capacity;

    public SerialBuffer()
    {
        clean();
    }

    public void clean()
    {
        size = 0;
        capacity = DEFAULT_CAPACITY;
        bufferArray = new byte[capacity];
    }

    private boolean canAddElement()
    {
        return size < capacity;
    }

    private void extendBuffer()
    {
        capacity = size * 2;
        byte[] newBuffer = new byte[capacity];
        System.arraycopy(bufferArray, 0, newBuffer, 0, size);
        bufferArray = newBuffer;
    }

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public byte[] getBufferArray()
    {
        byte[] resultBuffer = new byte[size];
        System.arraycopy(bufferArray, 0, resultBuffer, 0, size);
        return resultBuffer;
    }

    public void add(byte element)
    {
        if(!canAddElement())
        {
            extendBuffer();
        }
        bufferArray[size++] = element;
    }
}
