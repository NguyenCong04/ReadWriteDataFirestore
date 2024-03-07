package congntph34559.fpoly.lab1readwritedatabaseapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

public class AdapterCity extends RecyclerView.Adapter<AdapterCity.ViewHolder> {

    List<City> list;
    Context context;

    public AdapterCity(List<City> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_city, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.tvName.setText(list.get(position).getNameCity());
        holder.tvCountry.setText(list.get(position).getCountryCity());
        holder.tvState.setText(list.get(position).getStateCity());
        holder.tvPopulation.setText(list.get(position).getPopulationCity()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName,tvState,tvCountry,tvPopulation;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNamCity);
            tvState = itemView.findViewById(R.id.tvStateCity);
            tvCountry = itemView.findViewById(R.id.tvCountryCity);
            tvPopulation = itemView.findViewById(R.id.tvPopulationCity);


        }
    }


}
