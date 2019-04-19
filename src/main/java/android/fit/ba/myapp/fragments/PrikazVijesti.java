package android.fit.ba.myapp.fragments;


import android.fit.ba.myapp.R;
import android.fit.ba.myapp.data.VijestVM;
import android.fit.ba.myapp.helper.MyUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PrikazVijesti extends Fragment {

    private static String key1 ="key1";
    private TextView naslov;
    private TextView sadrzaj;
    private VijestVM vijestVM;
    private static String key = "key";
    private String sadrzaj1;
    private String naslov1;


    public static PrikazVijesti newInstance(String naslov, String sadrzaj) {

        Bundle args = new Bundle();
        PrikazVijesti fragment = new PrikazVijesti();
        args.putSerializable(key,naslov);
        args.putSerializable(key1,sadrzaj);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!= null)
        {
            naslov1 = (String) getArguments().getSerializable(key);
            sadrzaj1 = (String) getArguments().getSerializable(key1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.stavka_prikaz_vijesti,container,false);

        naslov = view.findViewById(R.id.naslovId);
        sadrzaj = view.findViewById(R.id.sadrzajId);
        final Button btnNazad = view.findViewById(R.id.btnNazad);

        naslov.setText(naslov1);
        sadrzaj.setText(sadrzaj1);

        btnNazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_clickNazad();
            }
        });


        return view;

    }

    private void btn_clickNazad() {
        MyUtil.pozoviFragment(getActivity(),R.id.mjestoFragment,ListaVijesti_Fragment1.newInstance());
    }
}
