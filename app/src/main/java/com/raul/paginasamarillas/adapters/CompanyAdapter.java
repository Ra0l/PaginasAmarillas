package com.raul.paginasamarillas.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.raul.paginasamarillas.R;
import com.raul.paginasamarillas.activities.DetailCompanyActivity;
import com.raul.paginasamarillas.models.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.ViewHolder> {
    private static final String TAG = CompanyAdapter.class.getSimpleName();

    private AppCompatActivity activity;

    private List<Company> companys;

    public CompanyAdapter(AppCompatActivity activity){
        this.activity = activity;
        companys = new ArrayList<>();
    }

    public void setCompanys(List<Company>companys){

        this.companys = companys;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //cargar layouts
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_company,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyAdapter.ViewHolder viewHolder, int position) {
        final Company company = this.companys.get(position);

        viewHolder.nametext.setText(company.getName());
        viewHolder.addresstext.setText(company.getAddress());
        viewHolder.phonetext.setText(company.getPhone());

        Context context = viewHolder.itemView.getContext();
        int resourceid=context.getResources().getIdentifier(company.getPicture(),"drawable",context.getPackageName());

        viewHolder.pictureImage.setImageResource(resourceid);

        //definiendo el evento onclick
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: "+ company);

                Intent intent = new Intent(v.getContext(), DetailCompanyActivity.class);
                intent.putExtra("id", company.getId());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return companys.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView pictureImage;
        private TextView nametext;
        private TextView addresstext;
        private TextView phonetext;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pictureImage = itemView.findViewById(R.id.picture_image);
            nametext = itemView.findViewById(R.id.name_text);
            addresstext = itemView.findViewById(R.id.direccion_text);
            phonetext = itemView.findViewById(R.id.phone_text);
        }
    }
}
