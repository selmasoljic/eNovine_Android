package android.fit.ba.myapp.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.fit.ba.myapp.R;
import android.fit.ba.myapp.data.VijestPregledVM;
import android.fit.ba.myapp.data.VijestVM;
import android.fit.ba.myapp.helper.MyApiRequest;
import android.fit.ba.myapp.helper.MyRunnable;
import android.fit.ba.myapp.helper.MyUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class ListaVijesti_Fragment1 extends Fragment {

    private ListView lvVijesti;
    private BaseAdapter adapter;
    private SearchView traziKat;
    private VijestPregledVM vijesti;

    public static ListaVijesti_Fragment1 newInstance() {
        
        Bundle args = new Bundle();
        ListaVijesti_Fragment1 fragment = new ListaVijesti_Fragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        
        View view = inflater.inflate(R.layout.lista_vijesti_fragment1,container,false);

        traziKat = view.findViewById(R.id.srcKat);
        traziKat.setQueryHint("Unesite kategoriju...");

        traziKat.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                btnTrazi(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                btnTrazi(query);
                return false;
            }
        });
        traziKat.setIconifiedByDefault(false);

        lvVijesti = view.findViewById(R.id.lvVijesti);
        
        final FloatingActionButton btnDodajVijest = view.findViewById(R.id.fab);
        btnDodajVijest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_dodajVijest();
            }
        });

        popuniPodatkeTask("");
        return view;
    }

    private void btnTrazi(String query) {
        popuniPodatkeTask(query);
    }

    private void popuniPodatkeTask(String query) {
        MyApiRequest.get(getActivity(),"Vijesti/Find2?query=" + query, new MyRunnable<VijestPregledVM>() {
            @Override
            public void run(VijestPregledVM x) {
                vijesti = x;
                popuniPodatke();
            }
        });
    }


    private VijestVM vijestVM = new VijestVM();

    private void btn_dodajVijest() {
        MyUtil.pozoviDialog(getActivity(), DialogFragmentDodaj.newInstance());
    }

    private TextView txtSadrzaj;
    private TextView txtNaslov;
    private void popuniPodatke() {


        adapter = new BaseAdapter() {

            @Override
            public int getCount() {
                return vijesti.rows.size();
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

                if (view == null) {
                    LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(R.layout.stavka_vijesti, parent, false);
                }

                txtNaslov = view.findViewById(R.id.txtNaslov);
                txtSadrzaj = view.findViewById(R.id.txt1);

                VijestPregledVM.Row vijest = vijesti.rows.get(position);

                txtNaslov.setText(vijest.naslovVijesti + " : " + vijest.nazivKategorije);
                txtSadrzaj.setText(vijest.sadrzajVijesti);


                return view;
            }
        };
        lvVijesti.setAdapter(adapter);


        lvVijesti.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                VijestPregledVM.Row odabrana = vijesti.rows.get(position);
                MyUtil.pozoviFragment(getActivity(),R.id.mjestoFragment,PrikazVijesti.newInstance(odabrana.naslovVijesti.toString(),odabrana.sadrzajVijesti.toString()));
            }
        });

        lvVijesti.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                VijestPregledVM.Row od = vijesti.rows.get(position);
                do_listViewLongClick(od);
                return true;
            }
        });

    }

    private void do_listViewLongClick(final VijestPregledVM.Row od) {
        {

            final AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
            adb.setMessage("Da li želite obrisati vijest?");

            adb.setPositiveButton("DA", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    int SacuvajID = od.id;
                    MyApiRequest.delete(getActivity(), "Vijesti/Remove?id=" + od.id, new MyRunnable<Integer>() {
                        @Override
                        public void run(Integer o) {

                            vijesti.rows.remove(od);
                            adapter.notifyDataSetChanged();
                        }
                    });



                }
            });

            adb.setNegativeButton("NE", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            adb.setIcon(android.R.drawable.ic_dialog_alert);
            adb.show();

        }

    }


}
