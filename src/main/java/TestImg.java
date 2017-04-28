import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * 
 * @Class Name TestImg
 * @author wangyingjie
 * @Create 2017年4月21日
 */
public class TestImg {
	
	private static String fromFileStr = "sss:/dddd111.jpg";
	
	private static String saveToFileStr = "d:/111_copy.jpg" + System.currentTimeMillis();

	/**
	 * 
	 * @author wangyingjie
	 * @Create 2017年4月21日
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args){
		System.out.println("开始执行图片压缩拷贝。。。。。。。。。。。。。。。。。。");
		try {
			saveImageAsJpg(fromFileStr, saveToFileStr, 200, 400);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("执行图片压缩拷贝完毕。。。。。。。。。。。。。。。。。。");

	}

	public static BufferedImage resize(BufferedImage source, int targetW, int targetH) {
		// targetW，targetH分别表示目标长和宽
		int type = source.getType();
		BufferedImage target = null;
		double sx = (double) targetW / source.getWidth();
		double sy = (double) targetH / source.getHeight();
		// 这里想实现在targetW，targetH范围内实现等比缩放。如果不需要等比缩放
		// 则将下面的if else语句注释即可
		if (sx > sy) {
			sx = sy;
			targetW = (int) (sx * source.getWidth());
		} else {
			sy = sx;
			targetH = (int) (sy * source.getHeight());
		}
		if (type == BufferedImage.TYPE_CUSTOM) { // handmade
			ColorModel cm = source.getColorModel();
			WritableRaster raster = cm.createCompatibleWritableRaster(targetW, targetH);
			boolean alphaPremultiplied = cm.isAlphaPremultiplied();
			target = new BufferedImage(cm, raster, alphaPremultiplied, null);
		} else {
			target = new BufferedImage(targetW, targetH, type);
		}
		System.setProperty("java.awt.headless", "true");
		Graphics2D g = target.createGraphics();
		// smoother than exlax:
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
		g.dispose();
		return target;
	}

	public static void saveImageAsJpg(String fromFileStr, String saveToFileStr, int width, int hight) throws Exception {
		BufferedImage srcImage;
		// String ex = fromFileStr.substring(fromFileStr.indexOf("."),fromFileStr.length());
		String imgType = "JPEG";
		if (fromFileStr.toLowerCase().endsWith(".jpg")) {
			imgType = "jpg";
		}
		// System.out.println(ex);
		File saveFile = new File(saveToFileStr);
		File fromFile = new File(fromFileStr);
		if (fromFile.exists()) {
			srcImage = ImageIO.read(fromFile);
			if (width > 0 || hight > 0) {
				srcImage = resize(srcImage, width, hight);
			}
			ImageIO.write(srcImage, imgType, saveFile);
		}

	}

}
