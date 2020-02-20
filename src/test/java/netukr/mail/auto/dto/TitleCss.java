package netukr.mail.auto.dto;

public class TitleCss {
    private String color;
    private String fontSize;
    private String fontWeight;
    private String lineHeight;

    private String fontFamily;

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
    public String getFontFamily() {
        return fontFamily;
    }
    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    @Override
    public String toString() {
        return "Title{" +
                "color='" + color + '\'' +
                ", fontSize='" + fontSize + '\'' +
                ", fontWeight='" + fontWeight + '\'' +
                ", lineHeight='" + lineHeight + '\'' +
                ", fontFamily='" + fontFamily + '\'' +
                '}';
    }
}
