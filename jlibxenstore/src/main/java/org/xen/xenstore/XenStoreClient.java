/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xen.xenstore;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<String> dirs = client.listDirectory("/local/domain/0");
        System.out.println(Arrays.toString(dirs.toArray()));
    }

    public List<String> listDirectory(String path) {
        List<String> list = new ArrayList<>();
        int tran = XenstoreLibrary.INSTANCE.xs_transaction_start(xs_handle);
        IntBuffer intBuffer = IntBuffer.allocate(1);
        PointerByReference pbr = XenstoreLibrary.INSTANCE.xs_directory(xs_handle, tran, path, intBuffer);
        int n = intBuffer.get();
        System.out.println(n);
        Pointer[] arrays = pbr.getPointer().getPointerArray(0, n);
        for (int i = 0; i < arrays.length; i++) {
            Pointer array = arrays[i];
            list.add(array.getString(0));
        }
        XenstoreLibrary.INSTANCE.xs_transaction_end(xs_handle, tran, (byte) 1);
        return list;
    }
}
