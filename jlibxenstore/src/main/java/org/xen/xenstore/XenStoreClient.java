/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xen.xenstore;

import com.sun.jna.Memory;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author root
 */
public class XenStoreClient {

    XenstoreLibrary.xs_handle xs_handle;

    public XenStoreClient() {
        xs_handle = XenstoreLibrary.INSTANCE.xs_open(new NativeLong(0));
    }

    public static void main(String[] args) {
        XenStoreClient client = new XenStoreClient();
        List<String> dirs = client.listDirectory("/local/domain/0a");
        if (dirs != null) {
            System.out.println(Arrays.toString(dirs.toArray()));
        }
        dirs = client.listDirectory("/local/domain/0/test");
        if (dirs != null) {
            System.out.println(Arrays.toString(dirs.toArray()));
        }
        boolean rec = client.mkdir("/local/domain/0/test");
        System.out.println(rec);
        String path = "/local/domain/0/test/" + UUID.randomUUID().toString();
        rec = client.write(path, System.currentTimeMillis() + "");
        System.out.println(rec);
        client.read(path);
        rec = client.rm("/local/domain/0/test/a6555e63-e273-4136-9120-cfbbc00676d6");
        System.out.println(rec);
    }

    /**
     * list the content of the path,if path is no exists will return null.
     *
     * @param path the query path.
     * @return list the content of the path,if path is no exists will return
     * null.
     */
    public List<String> listDirectory(String path) {
        List<String> list = new ArrayList<>();
        int tran = XenstoreLibrary.INSTANCE.xs_transaction_start(xs_handle);
        IntBuffer intBuffer = IntBuffer.allocate(1);
        PointerByReference pbr = XenstoreLibrary.INSTANCE.xs_directory(xs_handle, tran, path, intBuffer);
        int n = intBuffer.get();
        if (pbr == null || n <= 0) {
            return null;
        }
        Pointer[] arrays = pbr.getPointer().getPointerArray(0, n);
        for (int i = 0; i < arrays.length; i++) {
            Pointer array = arrays[i];
            list.add(array.getString(0));
        }
        XenstoreLibrary.INSTANCE.xs_transaction_end(xs_handle, tran, (byte) 1);
        return list;
    }

    /**
     * create dir.
     *
     * @param path
     * @return 1 sucess.
     */
    public boolean mkdir(String path) {
        int tran = XenstoreLibrary.INSTANCE.xs_transaction_start(xs_handle);
        byte rec = XenstoreLibrary.INSTANCE.xs_mkdir(xs_handle, tran, path);
        XenstoreLibrary.INSTANCE.xs_transaction_end(xs_handle, tran, (byte) 0);
        return rec == 1;
    }

    /**
     * write value at path.
     *
     * @param path
     * @param value
     * @return
     */
    public boolean write(String path, String value) {
        int tran = XenstoreLibrary.INSTANCE.xs_transaction_start(xs_handle);
        Memory memory = new Memory(value.length() + 1);
        memory.setString(0, value);
        byte re = XenstoreLibrary.INSTANCE.xs_write(xs_handle, tran, path, memory, value.length());
        XenstoreLibrary.INSTANCE.xs_transaction_end(xs_handle, tran, (byte) 0);
        return re == 1;
    }

    public boolean rm(String path) {
        int tran = XenstoreLibrary.INSTANCE.xs_transaction_start(xs_handle);
        byte re = XenstoreLibrary.INSTANCE.xs_rm(xs_handle, tran, path);
        XenstoreLibrary.INSTANCE.xs_transaction_end(xs_handle, tran, (byte) 0);
        return re == 1;
    }

    /**
     * read data .
     *
     * @param path
     * @return
     */
    public String read(String path) {
        int tran = XenstoreLibrary.INSTANCE.xs_transaction_start(xs_handle);
        IntBuffer intBuffer = IntBuffer.allocate(1);
        Pointer data = XenstoreLibrary.INSTANCE.xs_read(xs_handle, tran, path, intBuffer);
        return (data.getString(0));
    }
}
