package com.azz.util;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ClassName:ImageUtil <br/>
 * Function:使用JDK原生态类生成图片缩略图和裁剪图片 <br/>
 * date:     2016年7月6日 下午2:35:54 <br/>
 * Email: icerainsoft@hotmail.com
 * @author Ares
 * @date 2016年07月06日 上午10:24:26
 * @author   zjj
 * @since JDK 1.7
 */
public class ImageUtil {

	private static Logger log = LoggerFactory.getLogger(ImageUtil.class);

//	private static String DEFAULT_PREVFIX = "small_";
//	private static Boolean DEFAULT_FORCE = false;

	/**
	 * Title: thumbnailImage
	 * <p>Description: 根据图片路径生成缩略图</p>
	 * @param originalFile
	 *            原图片
	 * @param smallFile
	 *            缩略图
	 * @param w
	 *            缩略图宽
	 * @param h
	 *            缩略图高
	 * @param prevfix
	 *            生成缩略图的前缀，如果不需要前缀，则传入空字符串""
	 * @param force
	 *            是否强制按照宽高生成缩略图(如果为false，则生成最佳比例缩略图)
	 */
	public static File converSmallImage(File originalFile, File smallFile,int w, int h, String prevfix, boolean force) {
		if (originalFile.exists()) {
			try {
				// ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG,
				// JPEG, WBMP, GIF, gif]
				String types = Arrays.toString(ImageIO.getReaderFormatNames());
				String suffix = null;
				// 获取图片后缀
				if (originalFile.getName().indexOf(".") > -1) {
					suffix = originalFile.getName().substring(originalFile.getName().lastIndexOf(".") + 1);
				} // 类型和图片后缀全部小写，然后判断后缀是否合法
				if (suffix == null || types.toLowerCase().indexOf(suffix.toLowerCase()) < 0) {
					log.error("error, the image suffix is illegal. the standard image suffix is {}." + types);
					return null;
				}
				log.debug("target image's size, width:{}, height:{}.", w, h);
				Image img = ImageIO.read(originalFile);
				if (!force) {
					// 根据原图与要求的缩略图比例，找到最合适的缩略图比例
					int width = img.getWidth(null);
					int height = img.getHeight(null);
					if ((width * 1.0) / w < (height * 1.0) / h) {
						if (width > w) {
							h = Integer.parseInt(new java.text.DecimalFormat("0").format(height * w / (width * 1.0)));
							log.debug("change image's height, width:{}, height:{}.", w, h);
						}
					} else {
						if (height > h) {
							w = Integer.parseInt(new java.text.DecimalFormat("0").format(width * h / (height * 1.0)));
							log.debug("change image's width, width:{}, height:{}.", w, h);
						}
					}
				}
				BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
				Graphics g = bi.getGraphics();
				g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
				g.dispose();
				String p = originalFile.getPath();
				// 将图片保存在原目录并加上前缀
				if(smallFile == null){
					smallFile = new File(p.substring(0, p.lastIndexOf(File.separator)) + File.separator + prevfix + originalFile.getName());
				}
				ImageIO.write(bi, suffix,smallFile);
				return smallFile;
			} catch (IOException e) {
				log.error("generate thumbnail image failed.", e);
			}
		} else {
			log.warn("the image is not exist.");
		}
		return null;
	}

//	public static File converSmallImage(String imagePath, int w, int h, String prevfix, boolean force) {
//		File imgFile = new File(imagePath);
//		return converSmallImage(imgFile, w, h, prevfix, force);
//	}
//
//	public static File converSmallImage(String imagePath, int w, int h, boolean force) {
//		return converSmallImage(imagePath, w, h, DEFAULT_PREVFIX, force);
//	}
//
//	public static File converSmallImage(String imagePath, int w, int h) {
//		return converSmallImage(imagePath, w, h, DEFAULT_FORCE);
//	}

//	public static void main(String[] args) {
//		new ImageUtil().converSmallImage("d:/zjj.jpg", 50, 80);
//	}

}
