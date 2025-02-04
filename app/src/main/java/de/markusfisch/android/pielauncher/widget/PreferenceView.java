package de.markusfisch.android.pielauncher.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

import de.markusfisch.android.pielauncher.graphics.Ripple;

public class PreferenceView extends TextView {
	private final Ripple ripple = Ripple.newPressRipple();

	public PreferenceView(Context context) {
		super(context);
		initTouchListener();
	}

	public PreferenceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initTouchListener();
	}

	public PreferenceView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initTouchListener();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (ripple.draw(canvas)) {
			invalidate();
		}
	}

	private void initTouchListener() {
		setOnTouchListener(ripple.getOnTouchListener());
	}
}
