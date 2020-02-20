package netukr.mail.auto.dto;

public class DesTitleInactiveCss {
    private String color;
    private String fontSize;
    private String margin;
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
    public String getMargin() {
        return margin;
    }
    public void setMargin(String margin) {
        this.margin = margin;
    }
    public String getFontFamily() {
        return fontFamily;
    }
    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    @Override
    public String toString() {
        return "DesTitleInactive{" +
                "color='" + color + '\'' +
                ", fontSize='" + fontSize + '\'' +
                ", margin='" + margin + '\'' +
                ", fontFamily='" + fontFamily + '\'' +
                '}';
    }
}
