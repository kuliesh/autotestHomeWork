package netukr.mail.auto.dto;

public class TitleInactiveCss {
    private String color;
    private String fontSize;
    private String fontWeight;
    private String lineHeight;
    private String margin;
    private String paddingTop;
    private String fontFamily;
    private String cursor;

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getFontSize() {
        return fontSize;
    }
    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }
    public String getFontWeight() {
        return fontWeight;
    }
    public void setFontWeight(String fontWeight) {
        this.fontWeight = fontWeight;
    }
    public String getLineHeight() {
        return lineHeight;
    }
    public void setLineHeight(String lineHeight) {
        this.lineHeight = lineHeight;
    }
    public String getMargin() {
        return margin;
    }
    public void setMargin(String margin) {
        this.margin = margin;
    }
    public String getPaddingTop() {
        return paddingTop;
    }
    public void setPaddingTop(String paddingTop) {
        this.paddingTop = paddingTop;
    }
    public String getFontFamily() {
        return fontFamily;
    }
    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }
    public String getCursor() {
        return cursor;
    }
    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    @Override
    public String toString() {
        return "TitleInactive{" +
                "color='" + color + '\'' +
                ", fontSize='" + fontSize + '\'' +
                ", fontWeight='" + fontWeight + '\'' +
                ", lineHeight='" + lineHeight + '\'' +
                ", margin='" + margin + '\'' +
                ", paddingTop='" + paddingTop + '\'' +
                ", fontFamily='" + fontFamily + '\'' +
                ", cursor ='" + cursor + '\'' +
                '}';
    }
}
