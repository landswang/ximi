/**
 * StringTest.java
 * com.ejie.nbrs.test
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   ver1.1  2017年10月12日 		zlg
 *
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.test;


/**
 * ClassName:StringTest
 * 
 * @author zlg
 * @version
 * @since Ver 1.1
 * @Date 2017年10月12日 下午12:14:09
 * @see
 */
public class StringTest {

    public StringTest() {

        // TODO Auto-generated constructor stub

    }

    public static void main(String[] args) {
        // PicUtils.commpressPicForScale("D:\\wqs\\mo\\myffffffff\\IMG_20170916_175438.jpg",
        // "D:\\wqs\\mo\\myffffffff\\IMG_20170916_1754381.jpg", 50, 0.8); //
        // 图片小于500kb
        String m = "{四川省}{成都市}{温江区}";
        // StringUtils.isEmpty(m);
        String hareaString = m.replaceAll("{", ".");
        System.out.println(hareaString);
        // TODO Auto-generated method stub

    }

}
