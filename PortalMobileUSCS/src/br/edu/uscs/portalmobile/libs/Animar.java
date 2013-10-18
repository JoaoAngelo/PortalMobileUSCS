package br.edu.uscs.portalmobile.libs;

import android.view.View;
import android.view.animation.TranslateAnimation;

import com.actionbarsherlock.app.SherlockActivity;

public class Animar extends SherlockActivity {
	// To animate view slide out from left to right
	public static void slideToRight(View view) {
		TranslateAnimation animate = new TranslateAnimation(0, view.getWidth(), 0, 0);
		animate.setDuration(500);
		animate.setFillAfter(true);
		view.startAnimation(animate);
	}

	// To animate view slide out from right to left
	public static void slideToLeft(View view) {
		TranslateAnimation animate = new TranslateAnimation(0, -view.getWidth(), 0, 0);
		animate.setDuration(500);
		animate.setFillAfter(true);
		view.startAnimation(animate);
	}

	// To animate view slide out from top to bottom
	public static void slideToBottom(View view) {
		TranslateAnimation animate = new TranslateAnimation(0, 0, 0, view.getHeight());
		animate.setDuration(500);
		animate.setFillAfter(true);
		view.startAnimation(animate);
	}

	// To animate view slide out from bottom to top
	public static void slideToTop(View view) {
		TranslateAnimation animate = new TranslateAnimation(0, 0, 0, -view.getHeight());
		animate.setDuration(500);
		animate.setFillAfter(true);
		view.startAnimation(animate);
	}

	// To animate view slide out from bottom to top
	public static void fadeout(View view) {
		animate(view).setDuration(500);
		animate(view).alpha(0);
		animate(view).translationY(1000);
	}

	// To animate view slide out from bottom to top
	public static void fadein(View view) {
		animate(view).setDuration(500);
		animate(view).alpha(1);
		animate(view).translationY(0);
	}

}
