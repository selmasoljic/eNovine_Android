package android.fit.ba.myapp.data;

import java.io.Serializable;
import java.util.List;

public class VijestPregledVM {

    public static class Row
    {
        public int id;
        public String nazivKategorije;
        public String naslovVijesti;
        public String sadrzajVijesti;
        public int brojVijesti;
    }

    public List<Row> rows;

}
