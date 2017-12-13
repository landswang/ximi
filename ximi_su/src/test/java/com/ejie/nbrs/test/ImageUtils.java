/**
 * ImageUtils.java
 * com.ejie.nbrs.test
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   ver1.0  2017年12月13日 		torreswang
 *
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.test;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

/**
 * ClassName:ImageUtils（Describe this Class）
 * 
 * @author torreswang
 * @version Ver 1.0
 * @Date 2017年12月13日 上午10:55:49
 * @see
 */
public class ImageUtils {

    public static void main(String[] args) {
        try {
            Thumbnails.of(new File("D:\\wqs\\mo\\myffffffff\\IMG_20170916_175427.jpg")).toFile(
                    new File("D:\\wqs\\mo\\myffffffff\\1a_size_2.jpg"));
        } catch (IOException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }
}
