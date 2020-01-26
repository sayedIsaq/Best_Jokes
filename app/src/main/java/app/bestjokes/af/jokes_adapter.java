package app.bestjokes.af;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class jokes_adapter extends RecyclerView.Adapter<jokes_adapter.jokesviewholder> {

    String title[];
    String jokes[];

    public jokes_adapter(String[] title, String[] jokes) {
        this.title = title;
        this.jokes= jokes;

        Log.d("message2", "onCreate: "+title.length+""+jokes.length);

    }

    @NonNull
    @Override
    public jokesviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main,parent,false);

        return new jokesviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull jokesviewholder holder, int position) {

        holder.tvtitle.setText(title[position]);
        holder.tvjokes.setText(jokes[position]);

    }

    @Override
    public int getItemCount()
    {
        return title.length;
    }

    public class jokesviewholder extends RecyclerView.ViewHolder{
        TextView tvtitle,tvjokes;
        public jokesviewholder(@NonNull View itemView) {
            super(itemView);

            tvtitle = itemView.findViewById(R.id.Tvtittle);
            tvjokes = itemView.findViewById(R.id.Tvjoke);
        }
    }
}
