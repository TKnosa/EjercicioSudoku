package fuentes;

import java.awt.*;
import java.io.InputStream;

public class TitilliumWebBlack {
    private Font font = null;

    public TitilliumWebBlack(){
        String fontName = "TitilliumWeb-Black.ttf";
        try{
            InputStream is = getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        }catch(Exception ex){
            System.out.println(fontName + " no se cargo");
            font = new Font("Arial", Font.BOLD, 14);
        }
    }

    public Font MyFont(int style, float size){
        Font tFont = font.deriveFont(style, size);
        return tFont;
    }
}
