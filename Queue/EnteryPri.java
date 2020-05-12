/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureaplication.Queue;

import java.util.Comparator;

/**
 *
 * @author hp
 * @param <SH>
 */
public  abstract class EnteryPri<SH> implements Comparator<SH> {

    SH pro;
    Comparator<SH> com;

    

    SH getPriorty() {
        return this.pro;

    }

    @Override
    public int compare(SH t, SH t1) {
    return  com.compare(t, t1);
    }

    /**
     *
     * @param t
     * @return
     */
}
