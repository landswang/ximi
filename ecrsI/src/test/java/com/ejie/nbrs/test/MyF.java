/**
 * MyF.java com.ejie.nbrs.test
 * 
 * Function： TODO
 * 
 * ver date author ────────────────────────────────── ver1.0 2017年11月14日 torreswang
 * 
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * ClassName:我的测试类
 * 
 * @author torreswang
 * @version Ver 1.0
 * @Date 2017年11月14日 下午3:29:59
 * @see
 */
public class MyF {
    public static List<String> outData = new ArrayList<String>();

    public static void fileM(String inFile, String outFile) throws IOException {

        BufferedReader bs = null;
        BufferedWriter bw = null;

        try {
            bs = new BufferedReader(new FileReader(new File(inFile)));
            String line = null;
            String outStr = "";
            // String tempString = "";
            // outData = new ArrayList<String>();
            boolean flagString = false;
            while ((line = bs.readLine()) != null) {//
                if (line.indexOf("insert") != -1 || line.indexOf("INSERT") != -1 || line.indexOf("UPDATE") != -1
                        || line.indexOf("update") != -1 || line.indexOf("delete") != -1 || line.indexOf("DELETE") != -1
                        || line.indexOf("replace") != -1) {

                    flagString = true;

                }
                if (flagString) {
                    outStr += line;
                    if (line.indexOf(";") != -1) {
                        if (outStr.indexOf("images_info") != -1 || outStr.indexOf("loan_audit") != -1
                                || outStr.indexOf("log_management") != -1 || outStr.indexOf("delete_file") != -1
                                || outStr.indexOf("ftp_doc") != -1 || outStr.indexOf("scratch_file") != -1
                                || outStr.indexOf("applicant_base") != -1 || outStr.indexOf("guarantee_value") != -1
                                || outStr.indexOf("guarantee") != -1 || outStr.indexOf("loan_info") != -1
                                || outStr.indexOf("mortgage_house") != -1 || outStr.indexOf("mate_info") != -1
                                || outStr.indexOf("role_privilege") != -1 || outStr.indexOf("common_applicant") != -1
                                || outStr.indexOf("guarantee_management") != -1 || outStr.indexOf("grant_money") != -1
                                || outStr.indexOf("doc_info_rel") != -1 || outStr.indexOf("doc_info") != -1
                                || outStr.indexOf("privilege") != -1 || outStr.indexOf("account") != -1
                                || outStr.indexOf("role_info") != -1 || outStr.indexOf("doctype_info") != -1) {
                            // System.out.println(outStr);
                            outData.add(outStr);
                        }
                        outStr = "";
                        flagString = false;
                    }
                }

            }

            bw = new BufferedWriter(new FileWriter(new File(outFile)));
            for (String s : outData) {
                bw.write(s + "\r\n");
            }
            // System.out.println(outStr);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bs != null) {
                bs.close();
            }
            if (bw != null) {
                bw.close();
            }
        }
    }

    public static void filew(String outFile) throws IOException {

        BufferedWriter bw = null;

        try {

            bw = new BufferedWriter(new FileWriter(new File(outFile)));
            for (String s : outData) {
                bw.write(s + "\r\n");
            }
            // System.out.println(outStr);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        // D:\mms\sql_03
        // String inFile = "D:\\mms\\sql_01\\005\\mysql-bin.0004";
        // String inFile = "D:\\mms\\sql_03\\mysql-bin.0004";
        // String outFile = "D:\\mms\\";
        // for (int i = 81; i < 98; i++) {
        // inFile += i + ".sql";
        // outFile += "4" + i + ".sql";
        //
        // MyF.fileM(inFile, outFile);
        // inFile = "D:\\mms\\sql_03\\mysql-bin.0004";
        // outFile = "D:\\mms\\";
        // }
        // http://192.168.1.12:8080/staticresource/image/SXL/YJ2017110800008/9%E5%AE%A1%E6%89%B9%E4%B9%A620171121102129124.JPG
        // String outFile1 = "D:\\mms\\all.sql";
        // MyF.filew(outFile1);

        String inFile1 = "D:\\wqs\\mo\\myffffffff\\IMG_20160325_091954.jpg";
        String inFile = "D:\\wqs\\mo\\myffffffff\\IMG_20160325_092029.jpg";
        String inFile3 = "http://192.168.1.12:83/staticresource/image/SXL/YJ2017110800008/9%E5%AE%A1%E6%89%B9%E4%B9%A620171121102129124.JPG";
        String outFile = "D:\\wqs\\mo\\myffffffff\\IMG_20160325_092029.pdf";
        imgToPdf(inFile3, inFile1, outFile);
    }

    /**
     * D:\wqs\mo\9.23日上午cs实战活动照片.白鹭湾 将图片转换成pdf文件 imgFilePath 需要被转换的img所存放的位置。
     * *例如imgFilePath="D:\\projectPath\\55555.jpg"; pdfFilePath 转换后的pdf所存放的位置
     * *例如pdfFilePath="D:\\projectPath\\test.pdf";
     * 
     * @param image
     * @return
     * @throws IOException
     */

    public static boolean imgToPdf(String imgFilePath, String imgFilePath2, String pdfFilePath) throws IOException {
        File file = new File(imgFilePath);
        File file2 = new File(imgFilePath2);
        if (file.exists()) {
            Document document = new Document();
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(pdfFilePath);
                PdfWriter.getInstance(document, fos);

                // 添加PDF文档的某些信息，比如作者，主题等等
                document.addAuthor("arui");
                document.addSubject("test pdf.");
                // 设置文档的大小
                document.setPageSize(PageSize.A4);
                // 打开文档
                document.open();
                // 写入一段文字
                document.add(new Paragraph("JUST TEST ..."));
                // 读取一个图片
                Image image = Image.getInstance(imgFilePath);
                float imageHeight = image.getScaledHeight();
                float imageWidth = image.getScaledWidth();
                int i = 0;
                while (imageHeight > 500 || imageWidth > 500) {
                    image.scalePercent(100 - i);
                    i++;
                    imageHeight = image.getScaledHeight();
                    imageWidth = image.getScaledWidth();
                    System.out.println("imageHeight->" + imageHeight);
                    System.out.println("imageWidth->" + imageWidth);
                }

                image.setAlignment(Image.ALIGN_CENTER);
                // //设置图片的绝对位置
                // image.setAbsolutePosition(0, 0);
                // image.scaleAbsolute(500, 400);
                // 插入一个图片
                document.add(image);
            } catch (DocumentException de) {
                System.out.println(de.getMessage());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
            document.close();
            fos.flush();
            fos.close();
            return true;
        } else {
            return false;
        }
    }
}
