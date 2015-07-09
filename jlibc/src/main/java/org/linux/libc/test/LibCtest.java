/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.linux.libc.test;

import org.linux.libc.LibC;

/**
 *
 * @author root
 */
public class LibCtest {

    public static void main(String[] args) {
        String name = "/dev/nbd1";
        String host = "10.10.112.115";
        int port = 1234;
        int fd = LibC.INSTANCE.open(name, 0x02);
        System.out.println(fd);
        if (fd < 0) {
            System.out.println("can not open NBD" + name);
        }
        LibC.INSTANCE.op
    }
}
