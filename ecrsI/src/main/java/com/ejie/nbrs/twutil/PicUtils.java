/**
 * PicUtil.java
 * com.ejie.nbrs.twutil
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   ver1.0  2017年12月13日 		torreswang
 *
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.twutil;

/**
 * ClassName:PicUtil（Describe this Class）
 * @author   torreswang
 * @version  Ver 1.0
 * @Date	 2017年12月13日		下午2:53:19
 * @see 	 
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import org.apache.commons.lang3.StringUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class PicUtils {

    public static void main(String[] args) {
        // (int even, int odd) -> a + b;
        String imgFilePath = "D:\\wqs\\mo\\myffffffff\\田晴_3613_新网征信授权书.JPG";
        String pdfFilePath = "D:\\wqs\\mo\\myffffffff\\newPDF.pdf";
        PicUtils.commpressPicForScale(imgFilePath, "D:\\wqs\\mo\\myffffffff\\IMG_20170916_1754383.jpg", 200, 0.8); // 图片小于500kb
        try {
            Thumbnails.of(imgFilePath).scale(0.5f).toFile("D:\\wqs\\mo\\myffffffff\\田晴_3613_新网征信授权书5.JPG");

            PicUtils.imgToPdf(imgFilePath, pdfFilePath);
        } catch (IOException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 将图片转换成pdf文件 imgFilePath 需要被转换的img所存放的位置。
     * 例如imgFilePath="D:\\projectPath\\55555.jpg"; pdfFilePath 转换后的pdf所存放的位置
     * 例如pdfFilePath="D:\\projectPath\\test.pdf";
     * 
     * @param image
     * @return
     * @throws IOException
     */

    public static boolean imgToPdf(String imgFilePath, String pdfFilePath) throws IOException {
        File file = new File(imgFilePath);
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
                // document.add(new Paragraph("JUST TEST ..."));
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

    /**
     * 根据指定大小和指定精度压缩图片
     * 
     * @param srcPath
     *            源图片地址
     * @param desPath
     *            目标图片地址
     * @param desFilesize
     *            指定图片大小，单位kb
     * @param accuracy
     *            精度，递归压缩的比率，建议小于0.9
     * @return
     */
    public static String commpressPicForScale(String srcPath, String desPath, long desFileSize, double accuracy) {
        if (StringUtils.isEmpty(srcPath) || StringUtils.isEmpty(srcPath)) {
            return null;
        }
        if (!new File(srcPath).exists()) {
            return null;
        }
        try {
            File srcFile = new File(srcPath);
            // long srcFileSize = srcFile.length();
            // System.out.println("源图片：" + srcPath + "，大小：" + srcFileSize / 1024
            // + "kb");

            // 1、先转换成jpg
            Thumbnails.of(srcPath).scale(1f).toFile(desPath);
            // 递归压缩，直到目标文件大小小于desFileSize
            commpressPicCycle(desPath, desFileSize, accuracy);

            File desFile = new File(desPath);
            // System.out.println("目标图片：" + desPath + "，大小" + desFile.length() /
            // 1024 + "kb");
            // System.out.println("图片压缩完成！");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return desPath;
    }

    private static void commpressPicCycle(String desPath, long desFileSize, double accuracy) throws IOException {
        File srcFileJPG = new File(desPath);
        long srcFileSizeJPG = srcFileJPG.length();
        // 2、判断大小，如果小于500kb，不压缩；如果大于等于500kb，压缩
        if (srcFileSizeJPG <= desFileSize * 1024) {
            return;
        }
        // 计算宽高
        BufferedImage bim = ImageIO.read(srcFileJPG);
        int srcWdith = bim.getWidth();
        int srcHeigth = bim.getHeight();
        int desWidth = new BigDecimal(srcWdith).multiply(new BigDecimal(accuracy)).intValue();
        int desHeight = new BigDecimal(srcHeigth).multiply(new BigDecimal(accuracy)).intValue();

        Thumbnails.of(desPath).size(desWidth, desHeight)
                .watermark(Positions.BOTTOM_LEFT, new BufferedImage(100, 100, 5), 0.5f).outputQuality(accuracy)
                .toFile(desPath);
        commpressPicCycle(desPath, desFileSize, accuracy);
    }

}
