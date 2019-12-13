import java.awt.image.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;

import org.bytedeco.ffmpeg.*;
import org.bytedeco.ffmpeg.avcodec.*;
import org.bytedeco.ffmpeg.avformat.*;
import org.bytedeco.ffmpeg.avutil.*;

import static org.bytedeco.ffmpeg.global.avcodec.*;
import static org.bytedeco.ffmpeg.global.avformat.*;
import static org.bytedeco.ffmpeg.global.avutil.*;

import org.bytedeco.javacv.*;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.Java2DFrameConverter;


public class parabolicHW
{
	static int 	WIDTH = 868;
	static int	HEIGHT = 868;


	static int	VWIDTH = WIDTH*2;
	static int	VHEIGHT = HEIGHT*2;


	static		FFmpegFrameRecorder 		recorder;
	static		File				outfile;
	static		Frame				frame;
	static		BufferedImage			buffer;



	static 		int 				R[][] = new int[WIDTH][HEIGHT];
	static 		int 				G[][] = new int[WIDTH][HEIGHT];
	static 		int 				B[][] = new int[WIDTH][HEIGHT];
	
	
	static 		int 				VR[][] = new int[VWIDTH][VHEIGHT];
	static 		int 				VG[][] = new int[VWIDTH][VHEIGHT];
	static 		int 				VB[][] = new int[VWIDTH][VHEIGHT];

	
	static		Java2DFrameConverter		converter;

	public static void main (String args[]) throws Exception, IOException
	{
		if (args.length != 1)
		{
			System.out.println ("Usage: java demo <output file name>");
			System.exit(0);
		}

	
		outfile = new File(args[0]);
		
		
		recorder = new FFmpegFrameRecorder (outfile, VWIDTH, VHEIGHT);

		
		recorder.setVideoCodec (AV_CODEC_ID_WMV2);
		
		
		recorder.setFrameRate(30);

		
		recorder.setVideoOption ("preset", "ultrafast");

		
		recorder.setVideoBitrate(35000000);

		
		recorder.start();

		
		buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);

		
		converter = new Java2DFrameConverter();

		
		for (int a = 0; a < 110; a++)
		{
//
			drawline (0, a, a, 1540, 51, 255, 255);
			drawline (0, 110+a, 110+a, 1545, 51, 255, 255);
			drawline (0, 210+a, 210+a, 1545, 51, 255, 255);
			drawline (0, 320+a, 320+a, 1545, 51, 255, 255);
			drawline (0, 430+a, 430+a, 1545, 51, 255, 255);
			drawline (0, 540+a, 540+a, 1545, 51, 255, 255);
			drawline (0, 650+a, 650+a, 1545, 51, 255, 255);
			drawline (0, 760+a, 760+a, 1545, 51, 255, 255);
			drawline (0, 870+a, 870+a, 1545, 51, 255, 255);
			drawline (0, 980+a, 980+a, 1545, 51, 255, 255);
			drawline (0, 1010+a, 1010+a, 1545, 51, 255, 255);
			drawline (0, 1120+a, 1120+a, 1545, 51, 255, 255);
			drawline (0, 1230+a, 1230+a, 1545, 51, 255, 255);
			drawline (0, 1340+a, 1340+a, 1545, 51, 255, 255);
			drawline (0, 1450+a, 1450+a, 1545, 51, 255, 255);
			 
			drawline (1545, 1540-a, 1540-a, 51, 51, 255, 255);
			drawline (1545, 1450-a, 1450-a, 51, 51, 255, 255);
			drawline (1545, 1340-a, 1340-a, 51, 51, 255, 255);
			drawline (1545, 1230-a, 1230-a, 51, 51, 255, 255);
			drawline (1545, 1120-a, 1120-a, 51, 51, 255, 255);
			drawline (1545, 1010-a, 1010-a, 51, 51, 255, 255);
			drawline (1545, 980-a, 980-a, 51, 51, 255, 255);
			drawline (1545, 870-a, 870-a, 51, 51, 255, 255);
			drawline (1545, 760-a, 760-a, 51, 51, 255, 255);
			drawline (1545, 650-a, 650-a, 51, 51, 255, 255);
			drawline (1545, 540-a, 540-a, 51, 51, 255, 255);
			drawline (1545, 430-a, 430-a, 51, 51, 255, 255);
			drawline (1545, 320-a, 320-a, 51, 51, 255, 255);
			drawline (1545, 210-a, 210-a, 51, 51, 255, 255);
			drawline (1545, 110-a, 110-a, 51, 51, 255, 255);
			
			drawline (1545, a, 1540-a, 1545, 51, 255, 255);
			drawline (1545, 110+a, 1450-a, 1545, 51, 255, 255);
			drawline (1545, 210+a, 1340-a, 1545, 51, 255, 255);
			drawline (1545, 320+a, 1230-a, 1545, 51, 255, 255);
			drawline (1545, 430+a, 1120-a, 1545, 51, 255, 255);
			drawline (1545, 540+a, 1010-a, 1545, 51, 255, 255);
			drawline (1545, 650+a, 980-a, 1545, 51, 255, 255);
			drawline (1545, 760+a, 870-a, 1545, 51, 255, 255);
			drawline (1545, 870+a, 760-a, 1545, 51, 255, 255);
			drawline (1545, 980+a, 650-a, 1545, 51, 255, 255);
			drawline (1545, 1010+a, 540-a, 1545, 51, 255, 255);
			drawline (1545, 1120+a, 430-a, 1545, 51, 255, 255);
			drawline (1545, 1230+a, 320-a, 1545, 51, 255, 255);
			drawline (1545, 1340+a, 210-a, 1545, 51, 255, 255);
			drawline (1545, 1450+a, 110-a, 1545, 51, 255, 255);
			
			drawline (0, 1540-a, a, 0, 51, 255, 255);
			drawline (0, 1450-a, 110+a, 51, 51, 255, 255);
			drawline (0, 1340-a, 210+a, 51, 51, 255, 255);
			drawline (0, 1230-a, 320+a, 51, 51, 255, 255);
			drawline (0, 1120-a, 430+a, 51, 51, 255, 255);
			drawline (0, 1010-a, 540+a, 51, 51, 255, 255);
			drawline (0, 980-a, 650+a, 51, 51, 255, 255);
			drawline (0, 870-a, 760+a, 51, 51, 255, 255);
			drawline (0, 760-a, 870+a, 51, 51, 255, 255);
			drawline (0, 650-a, 980+a, 51, 51, 255, 255);
			drawline (0, 540-a, 1010+a, 51, 51, 255, 255);
			drawline (0, 430-a, 1120+a, 51, 51, 255, 255);
			drawline (0, 320-a, 1230+a, 51, 51, 255, 255);
			drawline (0, 210-a, 1340+a, 51, 51, 255, 255);
			drawline (0, 110-a, 1450+a, 51, 51, 255, 255);
			
			
			
			aa(true);
			drawframe();
			cleararrays(false);
		}
		recorder.stop();
	}


	public static void aa(boolean trueaa)
	{
		int	x, y;
		int	newx, newy;

		newx = newy = 0;

		
		cleararrays(true);

		
		if (!trueaa)
		{
			for (y=0; y<VHEIGHT; y+=2)
			{
				for (x=0; x<VWIDTH; x+=2)
				{
					R[newx][newy] = VR[x][y];
					G[newx][newy] = VG[x][y];
					B[newx][newy] = VB[x][y];
					newx++;
				}
				newx = 0;
				newy++;
			}
		}
		
		else
		{
			for (y=0; y<VHEIGHT; y+=2)
			{
				for (x=0; x<VWIDTH; x+=2)
				{
					
					R[newx][newy] = (VR[x][y] + VR[x+1][y] +
							 VR[x][y+1] + VR[x+1][y+1])/4;
					G[newx][newy] = (VG[x][y] + VG[x+1][y] +
							 VG[x][y+1] + VG[x+1][y+1])/4;
					B[newx][newy] = (VB[x][y] + VB[x+1][y] +
							 VB[x][y+1] + VB[x+1][y+1])/4;
					newx++;
				}
				newx = 0;
				newy++;
			}
		}

	}

	
	public static void cleararrays(boolean erasergb)
	{
		int x, y;

		if (erasergb)
			for (x = 0; x < WIDTH; x++)
				for (y = 0; y < HEIGHT; y++)
					R[x][y] = G[x][y] = B[x][y] = 0;
		else
			for (x = 0; x < VWIDTH; x++)
				for (y = 0; y < VHEIGHT; y++)
					VR[x][y] = VG[x][y] = VB[x][y] = 0;
	}

	public static void drawline(int x0, int y0, int x1, int y1, 
		int red, int grn, int blu)
	{	
		int z = 0;
		
 //The java.lang.Math.abs() returns the absolute value of a given argument.


        int ax = Math.abs(x1 - x0);
        int ay = Math.abs(y1 - y0);
 
        int ax2 = 2 * ax; 
        int ay2 = 2 * ay; 
 
        int ix = x0 < x1 ? 1 : -1; 
        int iy = y0 < y1 ? 1 : -1;
 
        int x = x0;
        int y = y0;
 
        if (ax >= ay) 
		{
            while (true) 
			{
				//System.out.println(String.format("x: %s, y: %s", x, y)); because i have no idea where the error was coming from
				VR[x][y] = red;
				VG[x][y] = grn;
				VB[x][y] = blu;
                if (x == x1)
                    break;
                x += ix;
                z += ay2;
                if (z > ax) 
				{
                    y += iy;
                    z -= ax2;
                }
            }
        } 
		else 
		{
            while (true) 
			{
				VR[x][y] = red;
				VG[x][y] = grn;
				VB[x][y] = blu;
                if (y == y1)
                    break;
                y += iy;
                z += ax2;
                if (z > ay) 
				{
                    x += ix;
                    z -= ay2;
                }
            }
        }
	}
	


	public static void drawframe () throws Exception, IOException
	{
		int 	x, y;
		int	pixcolor;	
		Color	pcolor;

		for (x=0; x<WIDTH; x++)
		{
			for (y=0; y<HEIGHT; y++)
			{

				buffer.setRGB(x, y, R[x][y] << 16 | G[x][y] << 8 | B[x][y]);
			}
		}

		
		frame = converter.convert(buffer);
		
		
		
		recorder.record(frame, AV_PIX_FMT_ARGB);
	}
}