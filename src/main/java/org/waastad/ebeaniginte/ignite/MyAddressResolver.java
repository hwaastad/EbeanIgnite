/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeaniginte.ignite;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.IgniteCheckedException;
import org.apache.ignite.configuration.AddressResolver;

/**
 *
 * @author helge
 */
@Slf4j
public class MyAddressResolver implements AddressResolver {

    @Override
    public Collection<InetSocketAddress> getExternalAddresses(InetSocketAddress isa) throws IgniteCheckedException {
        Collection<InetSocketAddress> list = new ArrayList<>();
        String host = "rancher-01.lab.dax.local";
        list.add(new InetSocketAddress(host, isa.getPort()));
        log.info("Mapping {} to {}", isa.toString(), "rancher-01.lab.dax.local:" + isa.getPort());
        return list;
    }

}
