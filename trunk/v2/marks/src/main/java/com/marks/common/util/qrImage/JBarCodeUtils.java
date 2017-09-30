package com.marks.common.util.qrImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.jbarcode.JBarcode;
import org.jbarcode.encode.Code128Encoder;
import org.jbarcode.encode.EAN13Encoder;
import org.jbarcode.encode.InvalidAtributeException;
import org.jbarcode.paint.BaseLineTextPainter;
import org.jbarcode.paint.EAN13TextPainter;
import org.jbarcode.paint.WidthCodedPainter;

/**
 * Created by zhangboqing on 2017/5/24.
 */
public class JBarCodeUtils {

	/**
	 * 128条形码
	 *
	 * @param strBarCode
	 *            条形码：0-100位
	 * @param dimension
	 *            商品条形码：尺寸
	 * @param barheight
	 *            商品条形码：高度
	 * @return 图片(Base64编码)
	 */
	public static void generateBarCode128(String strBarCode, String dimension, String barheight, OutputStream ous) {

		try {
			BufferedImage bi;
			int len = strBarCode.length();
			JBarcode productBarcode = new JBarcode(Code128Encoder.getInstance(), WidthCodedPainter.getInstance(),
					EAN13TextPainter.getInstance());

			// 尺寸，面积，大小 密集程度
			productBarcode.setXDimension(Double.valueOf(dimension).doubleValue());
			// 高度 10.0 = 1cm 默认1.5cm
			productBarcode.setBarHeight(Double.valueOf(barheight).doubleValue());
			// 宽度
			productBarcode.setWideRatio(Double.valueOf(30).doubleValue());
			// 是否显示字体
			productBarcode.setShowText(true);
			// 显示字体样式
			productBarcode.setTextPainter(BaseLineTextPainter.getInstance());
			// 生成二维码
			bi = productBarcode.createBarcode(strBarCode);

			ImageIO.write(bi, "jpg", ous);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 商品条形码
	 * 
	 * @param strBarCode
	 *            商品条形码：13位
	 * @param dimension
	 *            商品条形码：尺寸
	 * @param barheight
	 *            商品条形码：高度
	 * @return 图片(Base64编码)
	 */
	public static void generateBarCode(String strBarCode, String dimension, String barheight, OutputStream ous) {
		// isNumeric 是否是数值
		// 校验。。。。。

		try {
			BufferedImage bi;
			int len = strBarCode.length();
			JBarcode productBarcode = new JBarcode(EAN13Encoder.getInstance(), WidthCodedPainter.getInstance(),
					EAN13TextPainter.getInstance());

			String barCode = strBarCode.substring(0, len - 1);
			String code = strBarCode.substring(len - 1, len);

			// 校验13位
			String checkCode = productBarcode.calcCheckSum(barCode);
			if (!code.equals(checkCode)) {
			}

			// 尺寸，面积，大小
			productBarcode.setXDimension(Double.valueOf(dimension).doubleValue());
			// 高度 10.0 = 1cm 默认1.5cm
			productBarcode.setBarHeight(Double.valueOf(barheight).doubleValue());
			// 宽度
			productBarcode.setWideRatio(Double.valueOf(25).doubleValue());

			// 是否校验13位，默认false
			productBarcode.setShowCheckDigit(true);

			// 显示字符串内容中是否显示检查码内容
			// productBarcode.setShowCheckDigit(true);

			// 生成二维码
			bi = productBarcode.createBarcode(barCode);

			ImageIO.write(bi, "jpg", ous);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param args
	 * @throws InvalidAtributeException
	 */
	public static void main(String[] args) throws Exception {
		String msg = "6943171293557111111";
		String path = "/Users/cjmei/Documents/project/puredo/platform/trunk/V1/marks/barcode.jpg";
		File file=new File(path);
		FileOutputStream out = new FileOutputStream(file);
		generateBarCode128(msg, "0.8", "30", out);
	}
}
