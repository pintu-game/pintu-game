package com.example.renkai.login_test.utils;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class ImageSplitterUtil
{

	/**
	 * @param bitmap
	 * @param piece
	 *            切成piece*piece块
	 * @return List<ImagePiece>
	 */
	public static List<ImagePiece> splitImage(Bitmap bitmap, int piece)
	{
		List<ImagePiece> imagePieces = new ArrayList<ImagePiece>();

		int width = bitmap.getWidth();
		int height = bitmap.getHeight();

		int pieceWidth = Math.min(width, height) / piece;

		for (int i = 0; i < piece; i++)
		{
			for (int j = 0; j < piece; j++)
			{

				ImagePiece imagePiece = new ImagePiece();
				imagePiece.setIndex(j + i * piece);

				int x = j * pieceWidth;
				int y = i * pieceWidth;
				
				imagePiece.setBitmap(Bitmap.createBitmap(bitmap, x, y,
						pieceWidth, pieceWidth));
				imagePieces.add(imagePiece);
			}
		}

		return imagePieces;
	}

}
