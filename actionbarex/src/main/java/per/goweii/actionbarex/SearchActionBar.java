package per.goweii.actionbarex;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import per.goweii.actionbarex.listener.OnLeftImageClickListener;
import per.goweii.actionbarex.listener.OnLeftTextClickListener;
import per.goweii.actionbarex.listener.OnRightImageClickListener;
import per.goweii.actionbarex.listener.OnRightTextClickListener;

/**
 * @author Cuizhen
 * @date 2018/8/30-上午11:10
 */
public final class SearchActionBar extends ActionBarEx {

    private String leftText;
    private float leftTextSize;
    private int leftTextColor;
    private int leftTextPaddingLeft;
    private int leftTextPaddingRight;
    private int leftImageRes;
    private int leftImageColor;
    private int leftImagePadding;
    private String rightText;
    private float rightTextSize;
    private int rightTextColor;
    private int rightTextPaddingLeft;
    private int rightTextPaddingRight;
    private int rightImageRes;
    private int rightImageColor;
    private int rightImagePadding;
    private String titleHintText;
    private float titleTextSize;
    private int titleTextColor;
    private int titleHintColor;
    private int titleBgRes;
    private int titlePaddingHorizontal;
    private int titleMarginVertical;

    private RelativeLayout titleBarChild;
    private ImageView leftImageView;
    private TextView leftTextView;
    private EditText titleEditText;
    private TextView rightTextView;
    private ImageView rightImageView;

    public SearchActionBar(Context context) {
        this(context, null);
    }

    public SearchActionBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchActionBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public RelativeLayout getTitleBarChild() {
        return titleBarChild;
    }

    public ImageView getLeftImageView() {
        return leftImageView;
    }

    public TextView getLeftTextView() {
        return leftTextView;
    }

    public EditText getEditTextView() {
        return titleEditText;
    }

    public TextView getRightTextView() {
        return rightTextView;
    }

    public ImageView getRightImageView() {
        return rightImageView;
    }

    @Override
    protected void initAttrs(AttributeSet attrs) {
        super.initAttrs(attrs);

        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.SearchActionBar);

        float iconPaddingDef = mContext.getResources().getDimension(R.dimen.title_bar_icon_padding_def);
        float textSizeDef = mContext.getResources().getDimension(R.dimen.title_bar_text_size_def);
        float textPaddingLeftDef = mContext.getResources().getDimension(R.dimen.title_bar_text_padding_left_def);
        float textPaddingRightDef = mContext.getResources().getDimension(R.dimen.title_bar_text_padding_right_def);
        float titleTextSizeDef = mContext.getResources().getDimension(R.dimen.title_bar_title_text_size_def);
        int iconColorDef = ContextCompat.getColor(mContext, R.color.icon_color_def);
        int textColorDef = ContextCompat.getColor(mContext, R.color.text_color_def);
        int titleTextColorDef = ContextCompat.getColor(mContext, R.color.title_text_color_def);
        int titleTextHintColorDef = ContextCompat.getColor(mContext, R.color.title_text_hint_color_def);

        leftText = typedArray.getString(R.styleable.SearchActionBar_search_left_text);
        leftTextSize = mDisplayInfoUtils.px2sp(typedArray.getDimension(R.styleable.SearchActionBar_search_left_text_size, textSizeDef));
        leftTextColor = typedArray.getColor(R.styleable.SearchActionBar_search_left_text_color, textColorDef);
        leftTextPaddingLeft = (int) typedArray.getDimension(R.styleable.SearchActionBar_search_left_text_padding_left, textPaddingLeftDef);
        leftTextPaddingRight = (int) typedArray.getDimension(R.styleable.SearchActionBar_search_left_text_padding_right, textPaddingRightDef);
        leftImageRes = typedArray.getResourceId(R.styleable.SearchActionBar_search_left_image_res, 0);
        leftImageColor = typedArray.getColor(R.styleable.SearchActionBar_search_left_image_color, iconColorDef);
        leftImagePadding = (int) typedArray.getDimension(R.styleable.SearchActionBar_search_left_image_padding, iconPaddingDef);

        rightText = typedArray.getString(R.styleable.SearchActionBar_search_right_text);
        rightTextSize = mDisplayInfoUtils.px2sp(typedArray.getDimension(R.styleable.SearchActionBar_search_right_text_size, textSizeDef));
        rightTextColor = typedArray.getColor(R.styleable.SearchActionBar_search_right_text_color, textColorDef);
        rightTextPaddingLeft = (int) typedArray.getDimension(R.styleable.SearchActionBar_search_right_text_padding_left, textPaddingLeftDef);
        rightTextPaddingRight = (int) typedArray.getDimension(R.styleable.SearchActionBar_search_right_text_padding_right, textPaddingRightDef);
        rightImageRes = typedArray.getResourceId(R.styleable.SearchActionBar_search_right_image_res, 0);
        rightImageColor = typedArray.getColor(R.styleable.SearchActionBar_search_right_image_color, iconColorDef);
        rightImagePadding = (int) typedArray.getDimension(R.styleable.SearchActionBar_search_right_image_padding, iconPaddingDef);

        titleBgRes = typedArray.getResourceId(R.styleable.SearchActionBar_search_title_bg_res, 0);
        titleHintText = typedArray.getString(R.styleable.SearchActionBar_search_title_hint_text);
        titleTextSize = mDisplayInfoUtils.px2sp(typedArray.getDimension(R.styleable.SearchActionBar_search_title_text_size, titleTextSizeDef));
        titleTextColor = typedArray.getColor(R.styleable.SearchActionBar_search_title_text_color, titleTextColorDef);
        titleHintColor = typedArray.getColor(R.styleable.SearchActionBar_search_title_hint_color, titleTextHintColorDef);
        titlePaddingHorizontal = (int) typedArray.getDimension(R.styleable.SearchActionBar_search_title_padding_horizontal, 0);
        titleMarginVertical = (int) typedArray.getDimension(R.styleable.SearchActionBar_search_title_margin_vertical, 0);

        typedArray.recycle();
    }

    @Override
    protected View inflateTitleBar() {
        titleBarChild = (RelativeLayout) inflate(getContext(), R.layout.title_bar_search, null);

        leftImageView = titleBarChild.findViewById(R.id.iv_left);
        leftTextView = titleBarChild.findViewById(R.id.tv_left);
        titleEditText = titleBarChild.findViewById(R.id.et_title);
        rightTextView = titleBarChild.findViewById(R.id.tv_right);
        rightImageView = titleBarChild.findViewById(R.id.iv_right);

        if (leftImageRes > 0) {
            leftImageView.setVisibility(VISIBLE);
            leftImageView.setPadding(leftImagePadding, leftImagePadding, leftImagePadding, leftImagePadding);
            leftImageView.setImageResource(leftImageRes);
            leftImageView.setColorFilter(leftImageColor);
        } else {
            leftImageView.setVisibility(GONE);
        }

        if (!TextUtils.isEmpty(leftText)) {
            leftTextView.setVisibility(VISIBLE);
            leftTextView.setText(leftText);
            leftTextView.setTextColor(leftTextColor);
            leftTextView.setTextSize(leftTextSize);
            leftTextView.setPadding(leftTextPaddingLeft, 0, leftTextPaddingRight, 0);
        } else {
            leftTextView.setVisibility(GONE);
        }

        titleEditText.setVisibility(VISIBLE);
        titleEditText.setHint(titleHintText);
        titleEditText.setTextColor(titleTextColor);
        titleEditText.setTextSize(titleTextSize);
        titleEditText.setHintTextColor(titleHintColor);
        if (titleBgRes > 0) {
            titleEditText.setBackgroundResource(titleBgRes);
        }
        titleEditText.setPadding(titlePaddingHorizontal, 0, titlePaddingHorizontal, 0);
        RelativeLayout.LayoutParams titleParams = (RelativeLayout.LayoutParams) titleEditText.getLayoutParams();
        titleParams.topMargin = titleMarginVertical;
        titleParams.bottomMargin = titleMarginVertical;
        titleEditText.setLayoutParams(titleParams);

        if (rightImageRes > 0) {
            rightImageView.setVisibility(VISIBLE);
            leftImageView.setPadding(rightImagePadding, rightImagePadding, rightImagePadding, rightImagePadding);
            rightImageView.setImageResource(rightImageRes);
            rightImageView.setColorFilter(rightImageColor);
        } else {
            rightImageView.setVisibility(GONE);
        }

        if (!TextUtils.isEmpty(rightText)) {
            rightTextView.setVisibility(VISIBLE);
            rightTextView.setText(rightText);
            rightTextView.setTextColor(rightTextColor);
            rightTextView.setTextSize(rightTextSize);
            rightTextView.setPadding(rightTextPaddingLeft, 0, rightTextPaddingRight, 0);
        } else {
            rightTextView.setVisibility(GONE);
        }

        return titleBarChild;
    }

    public void setOnLeftImageClickListener(final OnLeftImageClickListener onLeftImageClickListener) {
        leftImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLeftImageClickListener != null) {
                    onLeftImageClickListener.onClick();
                }
            }
        });
    }

    public void setOnLeftTextClickListener(final OnLeftTextClickListener onLeftTextClickListener) {
        leftTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLeftTextClickListener != null) {
                    onLeftTextClickListener.onClick();
                }
            }
        });
    }

    public void setOnRightTextClickListener(final OnRightTextClickListener onRightTextClickListener) {
        rightTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onRightTextClickListener != null) {
                    onRightTextClickListener.onClick();
                }
            }
        });
    }

    public void setOnRightImageClickListener(final OnRightImageClickListener onRightImageClickListener) {
        rightImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onRightImageClickListener != null) {
                    onRightImageClickListener.onClick();
                }
            }
        });
    }
}
