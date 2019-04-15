package com.azz.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import lombok.extern.slf4j.Slf4j;

/**
 * <P>二维码工具类</P>
 * 
 * @version 1.0
 * @author 朱建谱（15626573212） 2015-7-27 上午9:45:58
 */
@Slf4j
public class ZxingUtils {

	private static final String CHARACTERSET = "UTF-8";

	/**
	 * 
	 * <p>生成二维码</p>
	 * 
	 * @param content 二维码内容
	 * @param imagePath 二维码图片存放路径(含文件名)
	 * @param width 生成的二维码图片宽度
	 * @param height 生成的二维码图片高度
	 * @param logoPath logo头像存放路径(含文件名,若不加logo则传null即可)
	 * @return 生成二维码结果(true or false)
	 * @author 朱建谱（15626573212） 2015-7-27 下午3:41:12
	 */
	public static boolean encodeQRCodeImage(String content, String imagePath, int width, int height, String logoPath) {
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		// 指定编码格式
		hints.put(EncodeHintType.CHARACTER_SET, CHARACTERSET);
		// 指定纠错级别(L--7%,M--15%,Q--25%,H--30%)
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 编码内容,编码类型(这里指定为二维码),生成图片宽度,生成图片高度,设置参数
		BitMatrix bitMatrix = null;
		try {
			bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
		} catch (Exception e) {
			log.error("编码待生成二维码图片的文本时发生异常", e);
			return false;
		}
		// 这里要显式指定MatrixToImageConfig,否则还会按照默认处理将logo图像也变为黑白色
		MatrixToImageConfig config = new MatrixToImageConfig(0xFF000001, 0xFFFFFFFF);
		try {
			MatrixToImageWriter.writeToFile(bitMatrix, imagePath.substring(imagePath.lastIndexOf(".") + 1), new File(
					imagePath), config);
		} catch (IOException e) {
			log.error("生成二维码图片[" + imagePath + "]时遇到异常", e);
			return false;
		}
		// 此时二维码图片已经生成了,只不过没有logo头像,所以接下来根据传入的logoPath参数来决定是否加logo头像
		if (null == logoPath) {
			return true;
		} else {
			try {
				// 这里不需要判断logoPath是否指向了一个具体的文件,因为这种情景下overlapImage会抛IO异常
				overlapLogoImage(imagePath, logoPath);
				return true;
			} catch (IOException e) {
				log.error("为二维码图片[" + imagePath + "]添加logo头像[" + logoPath + "]时遇到异常", e);
				return false;
			}
		}
	}

	/**
	 * 
	 * <p>生成二维码</p>
	 * 
	 * @param content 二维码内容
	 * @param imagePath 二维码图片存放路径(含文件名)
	 * @param width 生成的二维码图片宽度
	 * @param height 生成的二维码图片高度
	 * @param logoPath logo头像存放路径(含文件名,若不加logo则传null即可)
	 * @return byte[]
	 * @author 朱建谱（15626573212） 2015-7-29 上午10:20:50
	 * @throws Exception
	 */
	public static byte[] encodeQRCodeOutStream(String content, String format, int width, int height, String logoPath)
			throws Exception {
		try {
			Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
			// 指定编码格式
			hints.put(EncodeHintType.CHARACTER_SET, CHARACTERSET);
			// 指定纠错级别(L--7%,M--15%,Q--25%,H--30%)
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
			// 编码内容,编码类型(这里指定为二维码),生成图片宽度,生成图片高度,设置参数
			hints.put(EncodeHintType.MARGIN, 0);
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
			// 这里要显式指定MatrixToImageConfig,否则还会按照默认处理将logo图像也变为黑白色
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, format, out);
			// 此时二维码图片已经生成了,只不过没有logo头像,所以接下来根据传入的logoPath参数来决定是否加logo头像
			if (null == logoPath) {
				return out.toByteArray();
			} else {
				// 这里不需要判断logoPath是否指向了一个具体的文件,因为这种情景下overlapImage会抛IO异常
				ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
				BufferedImage image = ImageIO.read(in);
				int logoWidth = image.getWidth() / 5;   // 设置logo图片宽度为二维码图片的五分之一
				int logoHeight = image.getHeight() / 5; // 设置logo图片高度为二维码图片的五分之一
				int logoX = (image.getWidth() - logoWidth) / 2;   // 设置logo图片的位置,这里令其居中
				int logoY = (image.getHeight() - logoHeight) / 2; // 设置logo图片的位置,这里令其居中
				Graphics2D graphics = image.createGraphics();
				graphics.drawImage(image, logoX, logoY, logoWidth, logoHeight, null);
				graphics.dispose();
				ImageIO.write(image, format, out);
				return out.toByteArray();
			}
		} catch (Exception e) {
			log.error("二维码生成异常", e);
			throw new Exception("二维码生成异常", e);
		}
	}

	/**
	 * 
	 * <p>生成二维码</p>
	 * 
	 * @param content 二维码内容
	 * @param imagePath 二维码图片存放路径(含文件名)
	 * @param width 生成的二维码图片宽度
	 * @param height 生成的二维码图片高度
	 * @param logoPath logo头像存放路径(含文件名,若不加logo则传null即可)
	 * @return file
	 * @author 朱建谱（15626573212） 2015-7-29 上午10:20:50
	 * @throws Exception
	 */
	public static File encodeQRCode(String content, String format, int width, int height, String logoPath)
			throws Exception {
		try {
			Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
			// 指定编码格式
			hints.put(EncodeHintType.CHARACTER_SET, CHARACTERSET);
			// 指定纠错级别(L--7%,M--15%,Q--25%,H--30%)
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
			// 编码内容,编码类型(这里指定为二维码),生成图片宽度,生成图片高度,设置参数
			String filePath = "Zxing" + DateFormatUtils.format(new Date(), DateUtils.FORMAT_YMDHM) + "." + format;
			File file = new File(filePath);
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
			// 这里要显式指定MatrixToImageConfig,否则还会按照默认处理将logo图像也变为黑白色
			MatrixToImageConfig config = new MatrixToImageConfig(0xFF000001, 0xFFFFFFFF);
			MatrixToImageWriter.writeToFile(bitMatrix, format, file, config);
			// 此时二维码图片已经生成了,只不过没有logo头像,所以接下来根据传入的logoPath参数来决定是否加logo头像
			if (null == logoPath) {
				return file;
			} else {
				// 这里不需要判断logoPath是否指向了一个具体的文件,因为这种情景下overlapImage会抛IO异常
				BufferedImage image = ImageIO.read(file);
				int logoWidth = image.getWidth() / 5;   // 设置logo图片宽度为二维码图片的五分之一
				int logoHeight = image.getHeight() / 5; // 设置logo图片高度为二维码图片的五分之一
				int logoX = (image.getWidth() - logoWidth) / 2;   // 设置logo图片的位置,这里令其居中
				int logoY = (image.getHeight() - logoHeight) / 2; // 设置logo图片的位置,这里令其居中
				Graphics2D graphics = image.createGraphics();
				graphics.drawImage(ImageIO.read(new File(logoPath)), logoX, logoY, logoWidth, logoHeight, null);
				graphics.dispose();
				ImageIO.write(image, format, file);
				return file;
			}
		} catch (Exception e) {
			log.error("二维码生成异常", e);
			throw new Exception("二维码生成异常", e);
		}
	}

	/**
	 * 
	 * <p>解析二维码</p>
	 * 
	 * @param 二维码图片存放路径(含文件名)
	 * @return 解析成功后返回二维码文本,否则返回空字符串
	 * @author 朱建谱（15626573212） 2015-7-27 下午3:42:23
	 */
	public static String decodeQRCodeImage(String imagePath) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			log.error("读取验证码异常", e);
			return "";
		}
		if (null == image) {
			log.info("Could not decode QRCodeImage");
			return "";
		}
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
		Map<DecodeHintType, String> hints = new HashMap<DecodeHintType, String>();
		hints.put(DecodeHintType.CHARACTER_SET, CHARACTERSET);
		Result result = null;
		try {
			result = new MultiFormatReader().decode(bitmap, hints);
			return result.getText();
		} catch (NotFoundException e) {
			log.error("二维码图片[" + imagePath + "]解析异常", e);
			return "";
		}
	}

	/**
	 * 
	 * <p>二维码图片增加logo头像</p>
	 * 
	 * @param imagePath 二维码图片存放路径(含文件名)
	 * @param logoPath logo头像存放路径(含文件名)
	 * @throws IOException
	 * @author 朱建谱（15626573212） 2015-7-27 下午1:40:38
	 */
	public static void overlapLogoImage(String imagePath, String logoPath) throws IOException {
		BufferedImage image = ImageIO.read(new File(imagePath));
		int logoWidth = image.getWidth() / 5;   // 设置logo图片宽度为二维码图片的五分之一
		int logoHeight = image.getHeight() / 5; // 设置logo图片高度为二维码图片的五分之一
		int logoX = (image.getWidth() - logoWidth) / 2;   // 设置logo图片的位置,这里令其居中
		int logoY = (image.getHeight() - logoHeight) / 2; // 设置logo图片的位置,这里令其居中
		Graphics2D graphics = image.createGraphics();
		graphics.drawImage(ImageIO.read(new File(logoPath)), logoX, logoY, logoWidth, logoHeight, null);
		graphics.dispose();
		ImageIO.write(image, imagePath.substring(imagePath.lastIndexOf(".") + 1), new File(imagePath));
	}

/*	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		json.put("url", "https://www.slsy.com");
		json.put("author", "slsy");
		json.put("describle", "测试描述");
		String content = json.toJSONString();// 内容
		int width = 200; // 图像宽度
		int height = 200; // 图像高度
		String filePath = "D://slsy.png";
		String logPath = "D://logo.png";
		// System.out.println("测试:" + encodeQRCodeImage(content, filePath, width, height, logPath));
		// File os = encodeQRCodeOutStream(content, "png", width, height, logPath);
		System.out.println(System.getProperty("user.dir"));
	}*/
}
