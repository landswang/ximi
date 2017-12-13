/**
 * TestC.java
 * com.ejie.nbrs.test
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   ver1.1  2017年10月25日 		torreswang
 *
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.test;

/**
 * 
 * ClassName:TestC（Describe this Class）
 * 
 * @author torreswang
 * @version Ver 1.1
 * @Date 2017 2017年10月25日 上午11:28:52
 * @see
 */
public class TestC {
    /**
     * tst:TODO （What does it mean to describe this variable）
     */
    String tst;//

    public String getTst() {
        return tst;
    }

    /**
     * 
     * setTst:(Describe the function of this method)
     * 
     * @param @param tst
     * @return void
     * @throws
     * @version Ver 1.0
     */
    public void setTst(String tst) {
        this.tst = tst;
    }

    /**
     * updateTest:(Describe the function of this method)
     * 
     * @param tst
     * @param i
     * @return void
     * @throws
     * @version Ver 1.0
     */
    public void updateTest(String tst, int i) {
        this.tst = tst;
    }

    /**
     * Creates a new instance of TestC
     * 
     * @param tst
     * @param i
     */
    public TestC(String tst, int i) {
        this.tst = tst;
    }
}
