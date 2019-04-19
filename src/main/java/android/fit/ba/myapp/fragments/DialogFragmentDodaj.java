package android.fit.ba.myapp.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.fit.ba.myapp.R;
import android.fit.ba.myapp.data.AutentifikacijaResultVM;
import android.fit.ba.myapp.data.KategorijaPregledVM;
import android.fit.ba.myapp.data.VijestVM;
import android.fit.ba.myapp.helper.MyApiRequest;
import android.fit.ba.myapp.helper.MyRunnable;
import android.fit.ba.myapp.helper.MySession;
import android.fit.ba.myapp.helper.MyUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class DialogFragmentDodaj extends DialogFragment {

    private EditText txtNaslov;
    private EditText txtSadrzaj;
    private BaseAdapter adapter;
    private ListView lvKategorije;
    private KategorijaPregledVM Kat;
    private KategorijaPregledVM kategorije;
    private KategorijaPregledVM.Row odabranaKat;

    public static DialogFragmentDodaj newInstance() {

        Bundle args = new Bundle();
        DialogFragmentDodaj fragment = new DialogFragmentDodaj();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!= null)
        {

        }

        setStyle(STYLE_NORMAL, R.style.NoviStil);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_dodaj,container,false);

        view.findViewById(R.id.btnClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });


        txtNaslov = view.findViewById(R.id.naslovId);
        if(txtNaslov.getText().toString().length()==0)
            txtNaslov.setError("Naslov je obavezan");

        txtSadrzaj = view.findViewById(R.id.sadrzajId);
        if(txtSadrzaj.getText().toString().length()==0)
            txtSadrzaj.setError("Sadržaj je obavezan");

        lvKategorije = view.findViewById(R.id.lvKat);
        popuniPodatkeTask();

        final Button btnSacuvaj = view.findViewById(R.id.btnNovaVijest);

        btnSacuvaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_Sacuvaj();
            }
        });

        return view;
    }

    private void popuniPodatkeTask()
    {
        MyApiRequest.get(getActivity(),"Kategorija/Index", new MyRunnable<KategorijaPregledVM>() {
            @Override
            public void run(KategorijaPregledVM x) {
                kategorije = x;
                popuniPodatke();
            }
        });


    }


    private void popuniPodatke() {

       //final List<KategorijaPregledVM> podaci = Storage.getKategorije();

        lvKategorije.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return kategorije.rows.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View view, ViewGroup parent) {

                if(view == null)
                {
                    LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(R.layout.kategorije_layout,parent,false);
                }

                final TextView txtImeKat = view.findViewById(R.id.txtKat);
                KategorijaPregledVM.Row x = kategorije.rows.get(position);

                txtImeKat.setText(x.naziv);

                return view;
            }

        });

        lvKategorije.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                odabranaKat = kategorije.rows.get(position);
                view.setSelected(true);
            }
        });
    }

    private void btn_Sacuvaj() {

        final AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());

        adb.setMessage("Da li želite spremiti vijest?");

        adb.setPositiveButton("DA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(txtNaslov.getText().toString().length()==0 || txtSadrzaj.getText().toString().length()==0  || odabranaKat == null)
                {

                    Toast.makeText(getContext(),"Popunite sva polja!",Toast.LENGTH_LONG).show();

                    MyUtil.pozoviDialog(getActivity(), DialogFragmentDodaj.newInstance());

                }
                else{
                    final int min = 20;
                    final int max = 80;
                    final int random = new Random().nextInt((max - min) + 1) + min;

                    AutentifikacijaResultVM kor= MySession.getKorisnik();


                    VijestVM novaVijest = new VijestVM();
                    novaVijest.naslovVijesti = txtNaslov.getText().toString();
                    novaVijest.kategorijaId = odabranaKat.id;
                    novaVijest.sadrzajVijesti = txtSadrzaj.getText().toString();
                    novaVijest.brojVijesti = random;
                    novaVijest.korisnikId = kor.korisnickiNalogId;


                    MyApiRequest.post(getActivity(), "Vijesti/Add", novaVijest, null);


                    //Storage.addVijest(novaVijest);
                    MyUtil.pozoviFragment(getActivity(),R.id.mjestoFragment,ListaVijesti_Fragment1.newInstance());
                    getDialog().dismiss();
                    Toast.makeText(getContext(),"Vijest spremljena.",Toast.LENGTH_LONG).show();
                }
            }
        });

        adb.setNegativeButton("NE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getDialog().dismiss();
            }
        });

        adb.show();

    }
}
