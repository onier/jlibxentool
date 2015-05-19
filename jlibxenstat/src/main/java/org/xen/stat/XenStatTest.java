/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xen.stat;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;

/**
 *
 * @author root
 */
public class XenStatTest {

    public static void main(String[] args) {
        xenstat_handle handler = XenstatLibrary.INSTANCE.xenstat_init();
//        System.out.println(handler);
        xenstat_node node = XenstatLibrary.INSTANCE.xenstat_get_node(handler, XenstatLibrary.XENSTAT_ALL);
        System.out.println(node.num_domains);
        Structure[] ss = node.domains.toArray(node.num_domains);
        for (int i = 0; i < ss.length; i++) {
            Structure s = ss[i];
            if(s instanceof xenstat_domain){
                xenstat_domain dom = (xenstat_domain) s;
                System.out.println(dom.id+" "+dom.name.getString(0));
            }
        }
//        int domainNumber = XenstatLibrary.INSTANCE.xenstat_node_num_domains(node);
//        System.out.println("domainNumber    " + domainNumber);
//        for (int i = 0; i < domainNumber; i++) {
//            xenstat_domain domain = XenstatLibrary.INSTANCE.xenstat_node_domain_by_index(node, i);
//            int domainID = XenstatLibrary.INSTANCE.xenstat_domain_id(domain);
//            System.out.print("domainID    " + domainID);
//            Pointer name = XenstatLibrary.INSTANCE.xenstat_domain_name(domain);
//            System.out.print("    domainName  " + name.getString(0));
//            int count = XenstatLibrary.INSTANCE.xenstat_domain_num_vcpus(domain);
//            System.out.print("    cpuNumber   " + count);
//            long cpuns = XenstatLibrary.INSTANCE.xenstat_domain_cpu_ns(domain);
//            System.out.print("    cpuNS   " + cpuns);
//            int ssid = XenstatLibrary.INSTANCE.xenstat_domain_ssid(domain);
//            System.out.print("    ssid    " + ssid);
//            long reservation = XenstatLibrary.INSTANCE.xenstat_domain_cur_mem(domain);
//            System.out.print("    reservation   " + reservation);
//            long maxMem = XenstatLibrary.INSTANCE.xenstat_domain_max_mem(domain);
//            System.out.print("    maxMem   " + maxMem);
//            int dying = XenstatLibrary.INSTANCE.xenstat_domain_dying(domain);
//            System.out.print("  dying   " + dying);
//            int crashed = XenstatLibrary.INSTANCE.xenstat_domain_crashed(domain);
//            System.out.print("  crashed   " + crashed);
//            int running = XenstatLibrary.INSTANCE.xenstat_domain_running(domain);
//            System.out.print("  running   " + running);
//            int blocked = XenstatLibrary.INSTANCE.xenstat_domain_blocked(domain);
//            System.out.print("  blocked   " + blocked);
//            System.out.println("");
//            printNetwork(domain);
//        }
        XenstatLibrary.INSTANCE.xenstat_free_node(node);
    }

    public static void printNetwork(xenstat_domain domain) {
        int networkNumber = XenstatLibrary.INSTANCE.xenstat_domain_num_networks(domain);
        System.out.println("networkNumber  " + networkNumber);
        for (int i = 0; i < networkNumber; i++) {
            xenstat_network network = XenstatLibrary.INSTANCE.xenstat_domain_network(domain, i);
        }
    }
}
